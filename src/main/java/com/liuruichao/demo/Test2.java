package com.liuruichao.demo;

/**
 * Test2
 *
 * @author liuruichao
 * Created on 2015-12-27 17:06
 */
public class Test2 {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new ClassA());
        Thread thread2 = new Thread(new ClassB());
        Thread thread3 = new Thread(new ClassC());
        thread1.start();
        Thread.sleep(50);
        thread2.start();
        Thread.sleep(50);
        thread3.start();
    }

    private static class ClassA implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock1) {
                        synchronized (lock2) {
                            System.out.println("A");
                            // 唤醒lock2(B线程), 并等待lock2解锁本线程
                            lock2.notify();
                            lock2.wait();
                        }
                        // 唤醒lock1(C线程), 并等待lock1解锁本线程
                        lock1.notify();
                        lock1.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 解锁B线程和C线程
                synchronized (lock1) {
                    lock1.notify();
                }
                synchronized (lock2) {
                    lock2.notify();
                }
            }
        }
    }

    private static class ClassB implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock2) {
                        System.out.println("B");
                        // 解锁A线程,并等待A线程下次解锁本线程
                        lock2.notify();
                        lock2.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClassC implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock1) {
                        System.out.println("C");
                        // 通知A线程,并等待A线程下次解锁本线程
                        lock1.notify();
                        lock1.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
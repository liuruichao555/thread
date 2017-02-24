package com.liuruichao.demo;

/**
 * Test1
 *
 * @author liuruichao
 * Created on 2015-12-27 16:58
 */
public class Test1 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(new ClassA(lock));
        Thread thread2 = new Thread(new ClassB(lock));
        thread1.start();
        thread2.start();
    }

    private static class ClassA implements Runnable {
        private Object lock;

        public ClassA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println("A");
                    lock.notify();
                    try {
                        Thread.sleep(1000);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class ClassB implements Runnable {
        private Object lock;

        public ClassB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    System.out.println("B");
                    lock.notify();
                    try {
                        Thread.sleep(1000);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

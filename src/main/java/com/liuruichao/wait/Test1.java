package com.liuruichao.wait;

/**
 * SimulatedCAS
 *
 * @author liuruichao
 * @date 15/8/20 下午1:27
 */
public class Test1 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        MyThread t1 = new MyThread(lock1);
        MyThread2 t2 = new MyThread2(lock1);
        t1.start();
        t2.start();
    }

    private static class MyThread extends Thread {
        private String name = "A";
        private Object lock1;

        public MyThread(Object lock1) {
            this.lock1 = lock1;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    System.out.println(name);
                    lock1.notify();
                    try {
                        Thread.sleep(1000);
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class MyThread2 extends Thread {
        private String name = "B";
        private Object lock1;

        public MyThread2(Object lock1) {
            this.lock1 = lock1;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    System.out.println(name);
                    lock1.notify();
                    try {
                        Thread.sleep(1000);
                        lock1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

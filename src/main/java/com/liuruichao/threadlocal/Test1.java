package com.liuruichao.threadlocal;

/**
 * Test1
 *
 * @author liuruichao
 * @date 15/9/18 下午2:36
 */
public class Test1 {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        new MyThread1().start();
        new MyThread2().start();

        while (true) {
            Thread.sleep(1000);
            System.out.println("main : " + threadLocal.get());
        }
    }

    private static class MyThread1 extends Thread {
        private String name =  "thread1";

        public MyThread1() {
            // 执行构造函数时是主线程(main)
            threadLocal.set("liuruichao");
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("thread : " + name + " , value : " + threadLocal.get());
                    Thread.sleep(1000);
                    if (threadLocal.get() == null) {
                        threadLocal.set("thread1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class MyThread2 extends Thread {
        private String name = "thread2";

        public MyThread2() {
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("thread : " + name + " , value : " + threadLocal.get());
                    Thread.sleep(1000);
                    if (threadLocal.get() == null) {
                        threadLocal.set("thread2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

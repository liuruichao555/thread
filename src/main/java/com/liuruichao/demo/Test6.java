package com.liuruichao.demo;

/**
 * 这不是也能实现么,问题是没有意义
 * 
 * @author liuruichao
 * Created on 2015-12-28 10:09
 */
public class Test6 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread2);
        thread1.start();
        thread2.start();
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class MyThread2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.liuruichao.demo;

/**
 * Test5
 * 
 * @author liuruichao
 * Created on 2015-12-28 10:01
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread.sleep(50);
        thread1.start();
        thread2.start();
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    //Thread.yield();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

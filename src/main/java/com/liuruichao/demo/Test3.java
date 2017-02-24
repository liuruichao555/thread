package com.liuruichao.demo;

/**
 * notify()通知wait()的线程,并不交出控制权
 * wait()交出控制权
 * 
 * @author liuruichao
 * Created on 2015-12-27 17:20
 */
public class Test3 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        thread1.start();
        thread2.start();
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

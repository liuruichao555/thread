package com.liuruichao.demo;

/**
 * Test7
 * 
 * @author liuruichao
 * Created on 2015-12-28 10:15
 */
public class Test7 {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        MyThread myThread = new MyThread(thread2);
        myThread.start();
    }

    private static class MyThread extends Thread {
        private MyThread2 thread2;

        public MyThread(MyThread2 thread2) {
            this.thread2 = thread2;
        }

        @Override
        public void run() {
            try {
                // 先启动thread2, 再等待thread2执行完毕再往下执行,否则两条线成就是同时执行
                thread2.start();
                thread2.join();

                System.out.println("MyThread start...");
                System.out.println("MyThread done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("MyThread2 start...");
                Thread.sleep(5000);
                System.out.println("MyThread2 done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

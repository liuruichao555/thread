package com.liuruichao.wait;

/**
 * Test7
 *
 * @author liuruichao
 * Created on 2017/2/24 14:18
 */
public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(new MyThread(obj, "A"));
        Thread t2 = new Thread(new MyThread(obj, "B"));
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }

    private static class MyThread implements Runnable {
        private final Object obj;

        private String text;

        public MyThread(Object obj, String text) {
            this.obj = obj;
            this.text = text;
        }


        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    System.out.println(text);
                    obj.notify();
                    try {
                        obj.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

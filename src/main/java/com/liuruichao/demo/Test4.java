package com.liuruichao.demo;

/**
 * Test4
 * 
 * @author liuruichao
 * Created on 2015-12-27 23:57
 */
public class Test4 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static class MyThread implements Runnable {
        private String name = "A";

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (this) {
                    System.out.println(name);
                    if ("A".equals(name)) {
                        name = "B";
                    } else if ("B".equals(name)) {
                        name = "C";
                    } else {
                        name = "A";
                    }
                }
            }
        }
    }
}

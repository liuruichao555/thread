package com.liuruichao.wait;

/**
 * Test3
 *
 * @author liuruichao
 * @date 15/8/20 下午3:06
 */
public class Test3 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello World!");
        }
    }
}

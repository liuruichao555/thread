package com.liuruichao.threadlocal;

import java.util.Random;

/**
 * Test2
 *
 * @author liuruichao
 * @date 15/9/18 下午2:50
 */
public class Test2 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        for (int i = 0; i < 10; i++) {
            new Thread(thread).start();
            Thread.sleep(500);
        }
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            if (threadLocal.get() == null) {
                threadLocal.set("liuruichao-" + new Random().nextInt());
            }
            System.out.println(Thread.currentThread().getName() + "  " + threadLocal.get());
        }
    }
}
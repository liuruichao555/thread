package com.liuruichao.interrupt;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * InterruptTest
 *
 * @author liuruichao
 * @date 15/7/29 下午4:02
 */
public class InterruptTest {
    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        Thread.sleep(2000);
        System.out.println("main : " + thread.isInterrupted());
    }

    private static class MyThread extends Thread {
        private BlockingQueue<String> queue;

        public MyThread() {
            queue = new ArrayBlockingQueue<String>(5);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(isInterrupted());
                    Thread.sleep(100);
                    queue.put("liuruichao");
                } catch (Exception e) {
                    e.printStackTrace();
                    queue.clear();
                }
            }
        }
    }
}
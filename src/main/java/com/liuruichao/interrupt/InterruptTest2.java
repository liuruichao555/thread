package com.liuruichao.interrupt;

import java.io.File;

/**
 * InterruptTest2
 *
 * @author liuruichao
 * @date 15/8/19 下午5:07
 */
public class InterruptTest2 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        // 当这个线程没有结束，才能获得isInterrupted的值，如果这个线程已经结束，那么isInterrupted的值就为false.
        System.out.println("main : " + myThread.getState().name() + ", interrupter : " + myThread.isInterrupted());
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // jvm 会自动清除打断状态，因为已经捕获了这个打断异常，所以jvm把打断状态置为false
                // 如果需要保持打断状态，再次调用打断方法即可
                // isInterrupted为true时，需要处理打断操作，否则，将打断操作置为原来状态
                Thread.currentThread().interrupt();
            }
            System.out.println("interrupt2 : " + Thread.currentThread().isInterrupted());
            // 返回当前打断状态，并将interrupter状态置为清除（置为false）
            // 如果当前状态为true，说明需要处理
            System.out.println("interrupted : " + Thread.interrupted());
            System.out.println("interrupt3 : " + Thread.currentThread().isInterrupted());
        }
    }
}

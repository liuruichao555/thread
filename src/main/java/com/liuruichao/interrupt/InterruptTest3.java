package com.liuruichao.interrupt;

/**
 * InterruptTest3
 *
 * @author liuruichao
 * @date 15/8/20 下午1:20
 */
public class InterruptTest3 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        Thread.sleep(5000);
        System.out.println("main done. myThread interrupt : " + myThread.isInterrupted());
    }

    private static class MyThread extends Thread {
        private int i = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("interrupt : " + Thread.currentThread().isInterrupted());
                    // 清除中断状态
                    Thread.sleep(1000);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

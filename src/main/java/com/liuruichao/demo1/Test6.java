package com.liuruichao.demo1;

/**
 * Test6
 *
 * @author liuruichao
 * @date 15/8/3 下午2:43
 */
public class Test6 {
    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread(5000, null);
        Thread t2 = new MyThread(1000, t1);
        t1.start();
        t2.start();
    }
    private static class MyThread extends Thread {
        private final long num;
        private final Thread thread;

        public MyThread(long num, Thread thread) {
            this.num = num;
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                if (thread != null) {
                    try {
                        System.out.println("join start");
                        // 等待thread处理完后，本线程才开始
                        thread.join();
                        System.out.println("join end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep(num);
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

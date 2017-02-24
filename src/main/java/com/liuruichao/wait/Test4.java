package com.liuruichao.wait;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 测试轮询和通知
 * 肯定是通知更好。
 * 轮询：每隔一段时间去查看状态，响应性会慢一点，耗费资源。
 * 通知：条件队列，如果条件满足则立即执行，节省资源。
 * <p>
 * 轮询：  put success.1440142126018
 * take success.1440142126528
 * 通知：  put success.1440142929738
 * take success.1440142929738 (响应性)
 *
 * @author liuruichao
 * @date 15/8/21 下午2:23
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        //SleepMyQueue sleepMyQueue = new SleepMyQueue(3);
        ////sleepMyQueue.put("liuruichao1");
        ////Thread.sleep(1000);
        ////sleepMyQueue.put("liuruichao2");
        ////Thread.sleep(1000);
        ////sleepMyQueue.put("liuruichao3");
        ////Thread.sleep(1000);
        ////sleepMyQueue.put("liuruichao4");

        //new Thread(() -> {
        //    try {
        //        sleepMyQueue.take();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();
        //Thread.sleep(3500);
        //sleepMyQueue.put("liuruichao");

        BoundedBuffer boundedBuffer = new BoundedBuffer(3);
        new Thread(() -> {
            try {
                boundedBuffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        boundedBuffer.put("liuruichao123");
    }

    private abstract static class MyQueue {
        private String[] buf;
        private int head = 0;
        private int tail = 0;
        private int count = 0;

        public MyQueue(int capacity) {
            buf = new String[capacity];
        }

        protected synchronized void doPut(String v) {
            buf[tail] = v;
            if (++tail == buf.length) {
                tail = 0;
            }
            ++count;
        }

        protected synchronized String doTake() {
            String v = buf[head];
            buf[head] = null;
            if (++head == buf.length) {
                head = 0;
            }
            --count;
            return v;
        }

        protected synchronized boolean isEmpty() {
            return count == 0;
        }

        protected synchronized boolean isFull() {
            return count == buf.length;
        }
    }

    private static class SleepMyQueue extends MyQueue {
        public SleepMyQueue(int size) {
            super(size);
        }

        /**
         * 每隔一秒检查
         *
         * @param v
         * @throws InterruptedException
         */
        public void put(String v) throws InterruptedException {
            while (true) {
                if (!isFull()) {
                    System.out.println("put success." + System.currentTimeMillis());
                    doPut(v);
                    return;
                }
                System.out.println("put fail.");
                Thread.sleep(1000);
            }
        }

        public String take() throws InterruptedException {
            while (true) {
                if (!isEmpty()) {
                    System.out.println("take success." + System.currentTimeMillis());
                    return doTake();
                }
                System.out.println("take fail.");
                Thread.sleep(1000);
            }
        }
    }

    private static class BoundedBuffer extends MyQueue {
        public BoundedBuffer(int size) {
            super(size);
        }

        public synchronized void put(String v) throws InterruptedException {
            while (isFull()) {
                wait();
            }
            System.out.println("put success." + System.currentTimeMillis());
            doPut(v);
            notifyAll();
        }

        public synchronized String take() throws InterruptedException {
            while (isEmpty()) {
                wait();
            }
            notifyAll();
            System.out.println("take success." + System.currentTimeMillis());
            return doTake();
        }
    }
}

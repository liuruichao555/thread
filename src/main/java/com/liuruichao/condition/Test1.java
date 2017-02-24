package com.liuruichao.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SimulatedCAS
 *
 * @author liuruichao
 * @date 15/8/24 上午8:49
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyQueue<String> queue = new MyQueue<>(3);
        queue.put("liuruichao1");
        queue.put("liuruichao2");
        queue.put("liuruichao3");
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                queue.put("liuruichao4");
                queue.put("liuruichao5");
                queue.put("liuruichao6");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(5000);
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    private static class MyQueue<T> {
        private Lock lock = new ReentrantLock();
        private Condition notFull = lock.newCondition();
        private Condition notEmpty = lock.newCondition();
        private final T[] items;
        private int tail = 0;
        private int head = 0;
        private int count = 0;

        private MyQueue(int size) {
            items = (T[]) new Object[size];
        }

        public void put(T t) throws InterruptedException {
            lock.lock();
            try {
                while (count >= items.length) {
                    System.out.println("queue is full.");
                    notFull.await();
                }
                items[tail++] = t;
                count++;
                if (tail >= items.length) {
                    tail = 0;
                }
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0) {
                    System.out.println("queue is empty.");
                    notEmpty.await();
                }
                T v = items[head++];
                if (head >= items.length) {
                    head = 0;
                }
                count--;
                notFull.signal();
                return v;
            } finally {
                lock.unlock();
            }
        }
    }
}

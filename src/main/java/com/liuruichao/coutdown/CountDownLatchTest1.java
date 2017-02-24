package com.liuruichao.coutdown;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchTest1
 * 
 * @author liuruichao
 * Created on 2016-04-08 14:13
 */
public class CountDownLatchTest1 {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        Thread task1 = new Thread(() -> {
            try {
                System.out.println("task1 等待3个task2任务完成.");
                countDownLatch.await();
                System.out.println();
                System.out.println("task2 已经完成了3个,task1被唤醒.");
                System.out.println(Thread.currentThread().getName() + " task1 执行任务...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " task1 执行完毕...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            Thread task2 = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " task2 执行任务...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " task2 执行完毕...");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            task2.start();
        }

        task1.start();
    }
}

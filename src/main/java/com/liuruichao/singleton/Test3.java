package com.liuruichao.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Test3
 *
 * @author liuruichao
 * Created on 2018/4/19 13:54
 */
public class Test3 {
    private static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        int threadSize = 100;
        CyclicBarrier barrier = new CyclicBarrier(threadSize);
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                num ++;
            }).start();
        }
        Thread.sleep(3);
        System.out.println(num);
    }
}

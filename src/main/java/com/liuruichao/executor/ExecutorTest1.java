package com.liuruichao.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool : 有空闲线程则用空闲线程，没有则新开，新开线程有上限。
 *
 * @author liuruichao
 * @date 15/7/28 上午10:48
 */
public class ExecutorTest1 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(Thread.currentThread().getName());
        exec.shutdown();
    }
}

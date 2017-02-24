package com.liuruichao.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadExecutor : 只有一个线程。
 *
 * @author liuruichao
 * @date 15/7/28 上午10:56
 */
public class ExecutorTest3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            exec.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }
}

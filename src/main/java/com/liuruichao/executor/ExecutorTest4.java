package com.liuruichao.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WorkStealingPool : 。。。
 *
 * @author liuruichao
 * @date 15/7/28 上午10:59
 */
public class ExecutorTest4 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newWorkStealingPool();
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

package com.liuruichao.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool : 有空闲进程则使用空闲进程，没有则新开，新开线程没有上限。
 *
 * @author liuruichao
 * @date 15/7/28 上午10:52
 */
public class ExecutorTest2 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(3005);
        }
        System.out.println(Thread.currentThread().getName());
        exec.shutdown();
    }
}

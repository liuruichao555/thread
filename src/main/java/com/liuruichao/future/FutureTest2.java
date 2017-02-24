package com.liuruichao.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FutureTest2
 *
 * @author liuruichao
 * @date 15/7/31 下午1:44
 */
public class FutureTest2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 预加载，无需等待，可以调用isDone()轮询查看完成与否。
        exec.submit(() -> {
            Thread.sleep(5000);
            return "liuruichao";
        });

        System.out.println(Thread.currentThread().getName());
        exec.shutdown();
    }
}

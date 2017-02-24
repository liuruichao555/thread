package com.liuruichao.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTest1
 *
 * @author liuruichao
 * @date 15/7/28 上午9:39
 */
public class FutureTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Future<String> future = exec.submit(() -> {
            Thread.sleep(3000);
            return "liuruichao";
        });
        // 阻塞等待结果
        //System.out.println(future.get());

        // 轮询查询结果
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            }
            System.out.println(Thread.currentThread().getName() + " exec ...");
            Thread.sleep(1000);
        }

        //Future<String> future = new FutureTask<String>(() -> {
        //    Thread.sleep(3000);
        //    return "liuruichao";
        //});
        //Future<Void> future2 = new FutureTask<Void>(() -> {
        //    System.out.println("没有返回值。");
        //    return Void.TYPE.newInstance();
        //});

        exec.shutdown();
    }
}

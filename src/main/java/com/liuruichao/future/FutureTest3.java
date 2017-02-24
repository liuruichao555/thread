package com.liuruichao.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTest3
 * 
 * @author liuruichao
 * Created on 2016-04-08 13:55
 */
public class FutureTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(2);

        Future<String> future = exec.submit(() -> {
            Thread.sleep(3000);
            return "liuruichao";
        });

        System.out.println(future.get());
        System.out.println("heheda");

        exec.shutdown();
    }
}

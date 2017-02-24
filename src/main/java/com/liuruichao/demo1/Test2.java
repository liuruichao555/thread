package com.liuruichao.demo1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author liuruichao
 *
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Executor exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 10; i++) {
            exec.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName());
    }
}

package com.liuruichao.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author liuruichao
 * @date 15/9/7 上午11:21
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        int num = 5;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < num + 1; i++) {
            semaphore.acquire();
        }
    }
}

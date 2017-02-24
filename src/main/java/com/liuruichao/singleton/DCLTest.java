package com.liuruichao.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * DCL ： 双重检查加锁
 * 双重检查锁真正的问题在于
 * 没有很好地理解“可见性”的含义。
 * 一个线程的instance的引用值有可能是已经失效的（无效或者错误的状态），所以会重新创建一次。
 * 但是如果把instance生命为volatile，那么就能启动DCL
 * @author liuruichao
 * @date 15/9/7 上午10:51
 */
public class DCLTest {
    public static void main(String[] args) {
        int threadSize = 100;
        CyclicBarrier barrier = new CyclicBarrier(threadSize);
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                try {
                    barrier.await();
                    MyClass.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    private static class MyClass {
        private static MyClass instance;

        private MyClass() {
            System.out.println("myClass init.");
        }

        public static MyClass getInstance() {
            if (instance == null) {
                synchronized (MyClass.class) {
                    if (instance == null) {
                        instance = new MyClass();
                    }
                }
            }
            return instance;
        }
    }
}

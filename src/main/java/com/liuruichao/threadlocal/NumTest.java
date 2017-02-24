package com.liuruichao.threadlocal;

/**
 * NumTest
 *
 * @author liuruichao
 *         Created on 2016-03-22 16:19
 */
public class NumTest {
    // 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        NumTest numTest = new NumTest();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    System.out.println(String.format("thread: %s, num: %s.", Thread.currentThread().getName(), numTest.getNextNum()));
                }
            }).start();
        }
    }
}

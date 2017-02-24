package com.liuruichao.demo1;

/**
 *
 * @author liuruichao
 *
 */
public class Test1 {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
    }
}

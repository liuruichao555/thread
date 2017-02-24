package com.liuruichao.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Test7
 *
 * @author liuruichao
 * @date 15/8/3 下午2:58
 */
public class Test7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread();
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
        System.out.println("打断完成。");
    }
    private static class MyThread extends Thread {
        private BufferedReader reader;

        public MyThread() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        @Override
        public void run() {
            while (true) {
                String str = null;
                try {
                    str = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(str);
            }
        }

        @Override
        public void interrupt() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            super.interrupt();
        }
    }
}

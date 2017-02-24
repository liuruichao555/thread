package com.liuruichao.wait;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Test6
 * 
 * @author liuruichao
 * Created on 2016-04-25 17:53
 */
public class Test6 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        System.out.println(queue.offer("liuruichao"));
        System.out.println(queue.offer("liuruichao"));
    }
}

package com.liuruichao.wait;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test5
 * 
 * @author liuruichao
 * Created on 2016-04-19 13:36
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.wait(3000);
        System.out.println("liuruichao");
    }
}

package joda;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * JodaTest4
 * 
 * @author liuruichao
 * Created on 2016-05-11 15:11
 */
public class JodaTest4 {
    public static void main(String[] args) {
        int maxThread = 8;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(maxThread);
        //Vector<String> list = new Vector<>();
        //Map<String, String> map = new HashMap<>();
        Map<String, String> map = new Hashtable<>();
        //Map<String, String> map = new ConcurrentHashMap<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < maxThread; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                String key = Thread.currentThread().getName();
                for (int j = 0; j < 1000000; j++) {
                    map.put(key + j, "liuruichao" + key + "_" + j);
                }
                System.out.println(Thread.currentThread().getName() + " " + map.size());
                if (map.size() == 8000000) {
                    long endTime = System.currentTimeMillis();
                    System.out.println(endTime - startTime);
                }
            }).start();
        }
    }

    private static long putTime() {
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

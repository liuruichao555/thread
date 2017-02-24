package com.liuruichao.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapTest
 *
 * @author liuruichao
 * @date 15/8/9 下午10:42
 */
public class MapTest {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
//        Map<String, String> map = new ConcurrentHashMap<>();
        List<Thread> consumeres = new ArrayList<>();
        List<Thread> producers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Consumer consumer = new Consumer(map);
            Producer producer = new Producer(map);
            consumer.start();
            producer.start();
            consumeres.add(consumer);
            producers.add(producer);
        }
        Thread.sleep(5000);
        producers.forEach(p -> p.interrupt());
        consumeres.forEach(c -> c.interrupt());
        System.out.println("main done. map size : " + map.size());
        System.out.println("Hello World");
    }
}

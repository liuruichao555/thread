package com.liuruichao.map;

import java.util.Map;

/**
 * Consumer
 *
 * @author liuruichao
 * @date 15/8/9 下午10:48
 */
public class Consumer extends Thread {
    private volatile int i = 0;
    private Map<String, String> map;

    public Consumer(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                task();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void task() {
        System.out.println(Thread.currentThread().getName() + " map size : " + map.size());
//        String key = "liuruichao" + i;
//        if (map.containsKey(key)) {
//            String value = map.get(key);
//            System.out.println(Thread.currentThread().getName() + " consumer : " + value);
//            i++;
//            map.remove(key);
//        }
    }
}

package com.liuruichao.map;

import java.util.Map;

/**
 * Producer
 *
 * @author liuruichao
 * @date 15/8/9 下午10:43
 */
public class Producer extends Thread {
    private volatile int i = 0;
    private Map<String, String> map;

    public Producer(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                map.put("liuruichao" + i, "liuruichao" + i);
                System.out.println(Thread.currentThread().getName() + " producer : liuruichao" + i);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

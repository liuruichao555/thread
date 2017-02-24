package com.liuruichao.threadpool;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * ThreadPoolTest1
 *
 * @author liuruichao
 * Created on 2017/2/24 14:45
 */
public class ThreadPoolTest1 extends ThreadPoolExecutor {
    private ConcurrentHashMap<String, Date> startTimes;

    public ThreadPoolTest1(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTimes = new ConcurrentHashMap<>();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimes.put(String.valueOf(r.hashCode()), new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long finishDate = new Date().getTime();
        long diff = finishDate - startTimes.get(String.valueOf(r.hashCode())).getTime();
        System.out.println(diff + "ms");
    }

    public static void main(String[] args) {
        ThreadPoolTest1 test1 = new ThreadPoolTest1(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            test1.execute(() -> {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        test1.shutdown();
    }
}

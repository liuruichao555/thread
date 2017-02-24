package demo5;

import java.util.concurrent.CountDownLatch;

/**
 * TestHarness
 *
 * @author liuruichao
 * @date 15/7/17 下午2:01
 */
public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        long time = timeTasks(5, () -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(time);
    }

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (Exception e) {
                }
            }).start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println("start : " + start);
        System.out.println("end   : " + end);
        return end - start;
    }
}

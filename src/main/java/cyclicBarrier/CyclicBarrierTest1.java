package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest1
 *
 * @author liuruichao
 * @date 15/9/3 下午5:25
 */
public class CyclicBarrierTest1 {
    private static int MAX_NUM = 5;
    private static CyclicBarrier barrier = new CyclicBarrier(MAX_NUM);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < MAX_NUM; i++) {
            new MyThread().start();
        }
        System.out.println("done");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Worker's waiting");
            try {
                // 线程在这里等待，直到所有线程都到达barrier
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " Working");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

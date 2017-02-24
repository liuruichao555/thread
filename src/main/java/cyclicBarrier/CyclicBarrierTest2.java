package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest2
 *
 * @author liuruichao
 * Created on 2017/2/24 14:24
 */
public class CyclicBarrierTest2 {
    private static final int num = 5;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

    public static void main(String[] args) {
        for (int i = 0; i < num; i++) {
            new Thread(new MyThread()).start();
        }
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println(String.format("%s Worker's waiting", Thread.currentThread().getName()));
            try {
                cyclicBarrier.await();
                System.out.println(String.format("%s Working", Thread.currentThread().getName()));
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

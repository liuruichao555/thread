package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest3
 *
 * @author liuruichao
 * Created on 2017/2/24 14:37
 */
public class CyclicBarrierTest3 {
    private static final int num = 5;

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println("线程执行完毕。");
    });

    public static void main(String[] args) {
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                System.out.println(String.format("%s 等待其他线程执行到此处。", Thread.currentThread().getName()));
                try {
                    cyclicBarrier.await();
                    System.out.println(String.format("%s 执行中。", Thread.currentThread().getName()));
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

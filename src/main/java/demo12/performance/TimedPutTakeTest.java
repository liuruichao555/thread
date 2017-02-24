package demo12.performance;

import demo12.BoundedBuffer;
import junit.framework.TestCase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 安全性测试
 *
 * @author liuruichao
 * @date 15/9/3 下午5:04
 */
public class TimedPutTakeTest extends TestCase {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger putSum = new AtomicInteger(0);
    private final AtomicInteger takeSum = new AtomicInteger(0);
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> bb;
    private final int nTrials, nPairs;
    private BarrierTimer timer = new BarrierTimer();

    public static void main(String[] args) throws InterruptedException {
        //new TimedPutTakeTest(10, 10, 100000).test();
        //pool.shutdown();
        int tpt = 100000; // 每条线程中的测试次数
        for (int cap = 1; cap <= 1000; cap*= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs*= 2) {
                // pairs 线程数
                TimedPutTakeTest t = new TimedPutTakeTest(cap, pairs, tpt);
                System.out.print("Pairs: " + pairs + "\t");
                t.test();
                System.out.print("\t");
                Thread.sleep(1000);
                t.test();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        pool.shutdown();
    }

    public TimedPutTakeTest(int capacity, int npairs, int ntrials) {
        this.bb = new BoundedBuffer<>(capacity);
        this.nTrials = ntrials;
        this.nPairs = npairs;
        // 加一代表主线程，*2 代表生产者和消费者:w
        this.barrier = new CyclicBarrier(npairs * 2 + 1, timer);
    }

    void test() {
        try {
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // 等待所有线程就绪
            barrier.await(); // 等待所有线程执行完成
            long nsPerItem = timer.getTime() / (nPairs * (long)nTrials);
            System.out.println("Throughput: " + nsPerItem + " ns/item");
            // 如果相等则什么都不输出(没有结果才是最好的结果)
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 随机数，防止JVM优化（预判下一个随机数）
    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; i--) {
                    bb.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = nTrials; i > 0; i--) {
                    sum += bb.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }

    class BarrierTimer implements Runnable {
        private boolean started;
        private long startTime, endTime;

        @Override
        public synchronized void run() {
            long t = System.nanoTime();
            if (!started) {
                started = true;
                startTime = t;
            } else {
                endTime = t;
            }
        }

        public synchronized void clear() {
            started = false;
        }

        public synchronized long getTime() {
            return endTime - startTime;
        }
    }
}

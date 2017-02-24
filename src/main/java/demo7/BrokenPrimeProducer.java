package demo7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BrokenPrimeProducer
 *
 * @author liuruichao
 * @date 15/7/29 上午11:08
 */
public class BrokenPrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        try {
            while (!cancelled) {
                p = p.nextProbablePrime();
                // 到达最大长度时会阻塞，这时consumer已经停止消费，所以会一直阻塞下去，造成资源浪费，JVM无法退出。
                queue.put(p);
                System.out.println(queue.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }

    public void cancel() {
        cancelled = true;
    }

    public static void main(String[] args) throws Exception {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);
        BrokenPrimeProducer producer = new BrokenPrimeProducer(queue);
        producer.start();
        try {
            Thread.sleep(1000);
        } finally {
            producer.cancel();
        }
    }
}

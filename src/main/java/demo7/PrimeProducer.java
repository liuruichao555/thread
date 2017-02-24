package demo7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * PrimeProducer
 *
 * @author liuruichao
 * @date 15/7/29 下午4:22
 */
public class PrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        boolean flag = false;
        try {
            // 此处为了调试。
            while (!(flag = Thread.currentThread().isInterrupted())) {
                System.out.println(flag);
                p = p.nextProbablePrime();
                // 到达最大长度时会阻塞，这时consumer已经停止消费，所以会一直阻塞下去，造成资源浪费，JVM无法退出。
                queue.put(p);
                System.out.println(queue.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(flag);
    }

    public void cancel() {
        interrupt();
    }

    public static void main(String[] args) throws Exception {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(10);
        PrimeProducer producer = new PrimeProducer(queue);
        producer.start();
        try {
            Thread.sleep(1000);
        } finally {
            producer.cancel();
            System.out.println("cancel");
        }
    }
}

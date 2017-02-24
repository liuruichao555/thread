package demo7;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * PrimeGenerator
 *
 * @author liuruichao
 * @date 15/7/29 上午10:42
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        // 安全发布
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws Exception {
        PrimeGenerator generator = new PrimeGenerator();
        Thread thread = new Thread(generator);
        thread.start();
        try {
            Thread.sleep(1000);
        } finally {
            generator.cancel();
        }
        List<BigInteger> list = generator.get();
    }
}

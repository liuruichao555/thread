package demo2;

import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子变量类同步
 *
 * @author liuruichao
 * @date 15/6/9 下午3:35
 */
@ThreadSafe
public class CountingFactorizer {
    private final AtomicLong count = new AtomicLong();

    @Deprecated
    public long getCount() {
        return count.get();
    }

    public void service() {
        System.out.println(count.incrementAndGet());
    }

    public static void main(String[] args) {
        final CountingFactorizer countingFactorizer = new CountingFactorizer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> countingFactorizer.service()).start();
        }
    }
}

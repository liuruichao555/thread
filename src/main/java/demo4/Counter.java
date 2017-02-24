package demo4;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * 线程安全
 *
 * @author liuruichao
 * @date 15/6/10 下午2:10
 */
@ThreadSafe
public class Counter {
    @GuardedBy("this") private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            new IllegalStateException("counter overflow");
        }
        return ++value;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> counter.increment()).start();
        }
    }
}

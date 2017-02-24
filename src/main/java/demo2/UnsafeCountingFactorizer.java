package demo2;

import org.apache.http.annotation.NotThreadSafe;

/**
 * 没有同步
 *
 * @author liuruichao
 * @date 15/6/9 下午3:28
 */
@NotThreadSafe
public class UnsafeCountingFactorizer {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void service() {
        ++count;
        System.out.println(count);
    }

    public static void main(String[] args) {
        final UnsafeCountingFactorizer unsafeCountingFactorizer = new UnsafeCountingFactorizer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> unsafeCountingFactorizer.service()).start();
        }
    }
}

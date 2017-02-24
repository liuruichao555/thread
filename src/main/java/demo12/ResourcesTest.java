package demo12;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * 测试资源泄露问题
 *
 * @author liuruichao
 * @date 15/9/3 下午7:53
 */
public class ResourcesTest extends TestCase {
    private static final int THRESHOLD = 1;

    void testLeak() throws InterruptedException {
        BoundedBuffer<Big> bb = new BoundedBuffer<>(10);
        int heapSize1 = 0/* 生成堆的快照 */;
        for (int i = 0; i < 10; i++) {
            bb.put(new Big());
        }

        for (int i = 0; i < 10; i++) {
            bb.take();
        }
        int heapSize2 = 0 /* 生成堆的快照 */;
        assertTrue(Math.abs(heapSize1 - heapSize2) < THRESHOLD);
    }

    class Big {
        double[] data = new double[100000];
    }
}

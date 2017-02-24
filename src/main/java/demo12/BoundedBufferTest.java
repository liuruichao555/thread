package demo12;

import junit.framework.TestCase;

/**
 * BoundedBufferTest
 *
 * @author liuruichao
 * @date 15/8/31 下午9:21
 */
public class BoundedBufferTest extends TestCase {
    void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread() {
            @Override
            public void run() {
                try {
                    int unused = bb.take();
                    fail();
                } catch (InterruptedException success) {
                }
            }
        };
        try {
            taker.start();
            Thread.sleep(1000);
            taker.interrupt();
            taker.join(1000);
            assertFalse(taker.isAlive());
        } catch (Exception e) {
            fail();
        }
    }
}

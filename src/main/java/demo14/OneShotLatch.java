package demo14;

import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * OneShotLatch
 *
 * @author liuruichao
 * @date 15/8/24 上午9:34
 */
@ThreadSafe
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            // 如果闭锁是开的(state == 1),那么这个操作将成功，否则将失败
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            // 现在打开闭锁
            setState(1);
            // 现在其他的线程可以获取该闭锁
            return true;
        }
    }
}

package demo14;

/**
 * 轮询与休眠实现简单的阻塞
 *
 * @author liuruichao
 * @date 15/8/11 上午12:18
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    /**
     * @param size 容量
     */
    protected SleepyBoundedBuffer(int size) {
        super(size);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(1000);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(1000);
        }
    }
}

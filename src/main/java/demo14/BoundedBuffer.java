package demo14;

/**
 * 条件队列
 * 使用notify(),wait(), 保证响应性
 * 不用再轮询
 *
 * 假设环境：producer和consumer都是单线程。
 *
 * @author liuruichao
 * @date 15/8/21 上午10:26
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    /**
     * @param capacity 容量
     */
    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        // 本次添加之前如果为空，代表有take线程wait中，需要唤醒。
        // 本次添加之前如果不为空，那么take不在wait中，所以不需要唤醒。
        boolean wasEmpty = isEmpty();
        doPut(v);
        if (wasEmpty) {
            notifyAll();
        }
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        // 本次take之前如果队列是满的，代表有put线程wait中，需要唤醒。
        // 本次take之前如果队列不是满的，代表put线程不在wait中，所以不需要唤醒。
        boolean wasFull = isFull();
        V v = doTake();
        if (wasFull) {
            notifyAll();
        }
        return v;
    }
}

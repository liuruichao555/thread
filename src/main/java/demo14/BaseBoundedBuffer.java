package demo14;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * BaseBoundedBuffer
 *
 * @author liuruichao
 * @date 15/8/10 下午11:59
 */
@ThreadSafe
public class BaseBoundedBuffer<V> {
    @GuardedBy("this")
    private final V[] buf;
    @GuardedBy("this")
    private int tail  = 0;
    @GuardedBy("this")
    private int head  = 0;
    @GuardedBy("this")
    private int count = 0;

    /**
     * @param capacity 容量
     */
    protected BaseBoundedBuffer(int capacity) {
        this.buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v) {
        buf[tail] = v;
        if (++tail == buf.length) {
            tail = 0;
        }
        ++count;
    }

    protected synchronized final V doTake() {
        V v = buf[head];
        buf[head] = null;
        if (++head == buf.length) {
            head = 0;
        }
        --count;
        return v;
    }

    public synchronized final boolean isFull() {
        return count == buf.length;
    }

    public synchronized final boolean isEmpty() {
        return count == 0;
    }
}

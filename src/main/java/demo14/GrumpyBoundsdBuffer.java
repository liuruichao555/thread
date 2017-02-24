package demo14;

import demo14.execption.BufferEmptyException;
import demo14.execption.BufferFullException;

/**
 * 将前提条件的失败传递给调用者（抛异常）
 * “缓存已满”并不是有界缓存的一个异常条件，就像“红灯”并不表示交通信号灯出现了异常。
 *
 * @author liuruichao
 * @date 15/8/11 上午12:06
 */
public class GrumpyBoundsdBuffer<V> extends BaseBoundedBuffer<V> {
    /**
     * @param size 容量
     */
    protected GrumpyBoundsdBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }
}

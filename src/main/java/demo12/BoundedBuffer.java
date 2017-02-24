package demo12;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.concurrent.Semaphore;

/**
 *
 * @author liuruichao
 * @date 15/8/24 下午5:36
 */
@ThreadSafe
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availableSpaces;
    @GuardedBy("this")
    private final E[] items;
    @GuardedBy("this")
    private int putPosition = 0;
    @GuardedBy("this")
    private int takePosition = 0;

    public BoundedBuffer(int size) {
        availableItems = new Semaphore(0);
        availableSpaces = new Semaphore(size);
        items = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpaces.availablePermits() == 0;
    }

    public void put(E e) throws InterruptedException {
        availableSpaces.acquire();
        doInsert(e);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availableSpaces.release();
        return item;
    }

    private synchronized void doInsert(E e) {
        int i = putPosition;
        items[i] = e;
        putPosition = (++i == items.length) ? 0 : i;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E e = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return e;
    }
}

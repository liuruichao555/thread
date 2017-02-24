package demo14;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * ThreadGate
 *
 * @author liuruichao
 * @date 15/8/22 下午1:30
 */
@ThreadSafe
public class ThreadGate {
    @GuardedBy("this")
    private boolean isOpen;
    @GuardedBy("this")
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        int arrivalGeneration = generation;
        // 如果阀门是打开的，或者阀门自从该线程到达后就一直是打开的，那么线程就可以通过wait
        while (!isOpen && generation == arrivalGeneration) {
            wait();
        }
    }
}

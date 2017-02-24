package heheda2;

import java.util.ArrayList;
import java.util.List;

/**
 * Test2
 *
 * @author liuruichao
 * Created on 2016-01-06 16:52
 */
public class Test2 {
    private static int ThreadCount = 2;

    public static void main(String[] args) throws InterruptedException {

        List<PrintTask> list = new ArrayList<PrintTask>();

        for (int i = 0; i < ThreadCount; i++) {
            PrintTask pt = new PrintTask();
            list.add(pt);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNext(list.get((i + 1) % list.size()));
        }

        for (PrintTask pt : list) {
            pt.start();
        }

        synchronized (list.get(0).lock) {
            list.get(0).lock.notify();
        }
    }

    private static class PrintTask implements Runnable {

        private static int count = 0;
        private final int id = ++count;

        final Object lock = new Object();
        Object nextLock;
        Thread thread = new Thread(this);

        private static boolean cancel = false;

        public void setNext(PrintTask next) {
            this.nextLock = next.lock;
        }

        private void start() {
            thread.start();
        }

        public void run() {
            while (!cancel) {
                try {
                    synchronized (lock) {
                        System.out.println(String.format("id : %s, 等待.", id));
                        lock.wait();
                        System.out.println(String.format("id : %s, 被唤醒.", id));
                        synchronized (nextLock) {
                            System.out.println(id);
                            nextLock.notify();
                        }
                    }
                    // 如果第一个线程执行到这,释放了他自己的锁(第一个锁)
                    // 轮到第二个线程执行   打印后通知第一个锁,但是此时第一个锁没有进入wait状态 (第二个线程wait)
                    // 轮到第一个线程执行   获取第一个锁然后wait,第二个线程也在wait,所以造成了死锁
                    // 两个锁和五个锁是一样的(同理)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

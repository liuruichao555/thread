package demo11;

import java.util.concurrent.BlockingQueue;

/**
 * WorkerThread
 *
 * @author liuruichao
 * @date 15/8/9 下午7:03
 */
public class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;

    public WorkerThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // queue.take() 是原子操作，这里是串行的。
                Runnable task = queue.take();
            } catch (InterruptedException e) {
                // 允许线程退出
                break;
            }
        }
    }
}

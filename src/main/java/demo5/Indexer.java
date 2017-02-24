package demo5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Indexer
 *
 * @author liuruichao
 * @date 15/7/16 下午5:36
 */
public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override

    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 创建索引
     * @param take
     */
    private void indexFile(File take) {
    }
}

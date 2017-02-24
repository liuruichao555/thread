package demo7;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 毒丸对象
 * 扩展到多个生产者：只需每个生产者都向队列中放入一个”毒丸对象“，消费者仅当收到N(producers)个“毒丸”对象时才停止。
 *
 * @author liuruichao
 * @date 15/8/4 上午10:17
 */
public class IndexingService {
    // 毒丸对象
    private static final File POISON = new File("");
    private final IndexerThread consumer = new IndexerThread();
    private final CrawlerThread producer = new CrawlerThread();
    private final BlockingQueue<File> queue;
    private final File root;

    public IndexingService() {
        queue = new ArrayBlockingQueue<File>(10);
        root = new File("root");
    }

    public void start() {
        producer.start();
        consumer.start();
    }

    public void stop() {
        producer.interrupt();
    }

    private class CrawlerThread extends Thread {
        @Override
        public void run() {
            try {
                crawl();
            } finally {
                while (true) {
                    try {
                        queue.put(POISON);
                    } catch (InterruptedException e) {
                        // 重新尝试
                    }
                }
            }
        }

        private void crawl() {

        }
    }

    private class IndexerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    File file = queue.take();
                    if (file == POISON) {
                        break;
                    } else {
                        indexFile();
                    }
                }
            } catch (InterruptedException e) {
            }
        }

        private void indexFile() {
            // 执行创建索引操作
        }
    }
}
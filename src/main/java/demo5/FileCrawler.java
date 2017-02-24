package demo5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * FileCrawler
 *
 * @author liuruichao
 * @date 15/7/16 下午5:30
 */
public class FileCrawler implements Runnable {
    private final BlockingQueue<File> fileQueue = new ArrayBlockingQueue<File>(10);
    private File root = new File("demo");

    @Override
    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                } else if (!alreadyIndexed(entry)) {
                    fileQueue.put(entry);
                }
            }
        }
    }

    /**
     * 判断file是否创建过索引
     * @param entry
     * @return
     */
    private boolean alreadyIndexed(File entry) {
        return false;
    }
}

package curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Test1
 *
 * @author liuruichao
 * @date 15/11/26 下午3:39
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        int threadNum = 10;
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        final CuratorFramework curator =
                CuratorFrameworkFactory.newClient("localhost:2181", new ExponentialBackoffRetry(5000, 5));
        curator.start();
        for (int i = 0; i < threadNum; i++) {
            exec.execute(() -> {
                InterProcessMutex lock = new InterProcessMutex(curator, "/lock");
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " 尝试获得锁...");
                    lock.acquire();
                    System.out.println(threadName + " 获得锁...");
                    System.out.println(threadName + " jobs start ...");
                    Thread.sleep(5000);
                    System.out.println(threadName + " jobs end ...");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        lock.release();
                    } catch (Exception e) {
                    }
                }
            });
        }
        //curator.close();
        exec.shutdown();
    }
}
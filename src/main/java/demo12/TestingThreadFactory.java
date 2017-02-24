package demo12;

import junit.framework.TestCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用回调测试
 * 测试线程池线程会不会超过10个线程
 *
 * @author liuruichao
 * @date 15/9/3 下午8:01
 */
public class TestingThreadFactory extends TestCase implements ThreadFactory {
    public final AtomicInteger numCreated = new AtomicInteger();
    private final ThreadFactory factory = Executors.defaultThreadFactory();

    public static void main(String[] args) throws InterruptedException {
        testPoolExpansion();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        numCreated.incrementAndGet();
        return factory.newThread(runnable);
    }

    public static void testPoolExpansion() throws InterruptedException {
        int MAX_SIZE = 10;
        TestingThreadFactory threadFactory = new TestingThreadFactory();
        ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE, threadFactory);

        for (int i = 0; i < 10 * MAX_SIZE; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        for (int i = 0; i < 20 && threadFactory.numCreated.get() < MAX_SIZE; i++) {
            Thread.sleep(100);
        }
        System.out.println("thread num : " + threadFactory.numCreated.get());
        assertEquals(threadFactory.numCreated.get(), MAX_SIZE);
        exec.shutdown();
    }
}

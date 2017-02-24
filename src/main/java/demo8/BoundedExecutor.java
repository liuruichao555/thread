package demo8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * BoundedExecutor
 *
 * @author liuruichao
 * @date 15/8/5 下午4:52
 */
public class BoundedExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, Semaphore semaphore) {
        this.exec = exec;
        this.semaphore = semaphore;
    }

    public void submitTask(final Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(() -> {
                try {
                    command.run();
                } finally {
                    semaphore.release();
                }
            });
        } catch (RejectedExecutionException e) {
            // 不能使用finally,如果是用finlly那么每次刚提交完任务就会释放。
            semaphore.release();
        }
    }
}

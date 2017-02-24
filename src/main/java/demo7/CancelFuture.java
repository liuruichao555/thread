package demo7;

import java.util.concurrent.*;

/**
 * CancelFuture
 *
 * @author liuruichao
 * @date 15/8/3 下午3:13
 */
public class CancelFuture {
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    public static void timeRun(Runnable r, long timeout, TimeUnit unit) throws ExecutionException {
        Future<?> future = exec.submit(r);
        try {
            future.get(timeout, unit);
        } catch (InterruptedException e) {
            // 打断操作->取消任务
        } catch (ExecutionException e) {
            // 如果在任务中跑出了一场，那么重新抛出该一场
            throw e;
        } catch (TimeoutException e) {
            // 超时任务将被取消
        } finally {
            // 如果任务技术那么执行取消操作也不会带来任何影响。
            // 如果任务正在运行，那么将被中断
            future.cancel(true);
        }
    }
}

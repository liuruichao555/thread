package demo7;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TrackingExecutor
 *
 * @author liuruichao
 * @date 15/8/4 上午10:44
 */
public class TrackingExecutor extends AbstractExecutorService {
    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor() {
        exec = Executors.newCachedThreadPool();
    }

    @Override
    public void shutdown() {
        exec.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return exec.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return exec.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return exec.awaitTermination(timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        exec.execute(() -> {
            try {
                command.run();
            } finally {
                if (isShutdown() && Thread.currentThread().isInterrupted()) {
                    // 如果已经关闭，且是被打断的线程则加入到取消列表里
                    tasksCancelledAtShutdown.add(command);
                }
            }
        });
    }

    public List<Runnable> getCancelledTasks() {
        if (!exec.isTerminated()) {
            throw new IllegalStateException("ExecutorService is not terminated");
        }
        return new ArrayList<>(tasksCancelledAtShutdown);
    }
}

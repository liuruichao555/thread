package demo7;


import java.net.Socket;
import java.util.concurrent.*;

/**
 * ReaderThread4
 *
 * @author liuruichao
 * @date 15/8/3 下午4:14
 */
public class ReaderThread4 implements CancellableTask<String> {
    private Socket socket;

    public synchronized void cancel() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public RunnableFuture<String> newTask() {
        return new FutureTask<String>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    ReaderThread4.this.cancel();
                } catch (Exception e) {
                } finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }

    @Override
    public String call() throws Exception {
        return null;
    }

    private class CancellingExecutor extends ThreadPoolExecutor {
        public CancellingExecutor() {
            super(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        }

        public RunnableFuture newTaskFor(Callable callable) {
            if (callable instanceof CancellableTask) {
                return ((CancellableTask) callable).newTask();
            } else {
                return super.newTaskFor(callable);
            }
        }
    }
}

interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
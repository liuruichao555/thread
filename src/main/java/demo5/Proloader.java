package demo5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Proloader
 *
 * @author liuruichao
 * @date 15/7/17 下午2:14
 */
public class Proloader {
    private final FutureTask<String> future
            = new FutureTask<String>(() -> "liuruichao");
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public String get() throws ExecutionException, InterruptedException {
        try {
            return future.get();
        } catch (Exception e) {
            throw e;
        }
    }
}

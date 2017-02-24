package demo5.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FutureTest3
 *
 * @author liuruichao
 * @date 15/7/28 上午9:21
 */
public class FutureTest3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(() -> {
            Thread.sleep(3000);
            System.out.println("new thread");
            return "liuruichao";
        });
        System.out.println("main");
        exec.execute(() -> {
            try {
                while (true) {
                    Thread.sleep(2000);
                    if (future.isDone()) {
                        System.out.println("result : " + future.get());
                        exec.shutdown();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

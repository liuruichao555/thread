package demo5.test;

import org.apache.log4j.Logger;

import java.util.concurrent.*;

/**
 * FutureTest1
 *
 * @author liuruichao
 * @date 15/7/21 下午5:15
 */
public class FutureTest1 {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(FutureTest1.class);
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future = exec.submit(() -> {
            Thread.sleep(3000);
            return "liuruichao";
        });
        new Thread(() -> {
            try {
                while (!future.isDone()) {
                    Thread.sleep(500);
                    logger.info("isDone : " + future.isDone());
                }
                logger.info("future result : " + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }).start();
        logger.info("main thread");
    }
}

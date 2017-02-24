package test;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * SimulatedCAS
 *
 * @author liuruichao
 * @date 15/7/16 下午3:36
 */
public class Test1 {
    private static final Logger logger = Logger.getLogger(Test1.class);
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        while (true) {
            try {
                Thread.sleep(1000);
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                logger.info("add thread to Executor. " +
                        "current thread size : " + ((ThreadPoolExecutor)exec).getActiveCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

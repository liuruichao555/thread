package demo5.test;

import org.apache.log4j.Logger;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTest2
 *
 * @author liuruichao
 * @date 15/7/21 下午5:32
 */
public class FutureTest2 {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(FutureTest2.class);
        Future<String> future = new FutureTask<String>(() -> {
            return "liuruichao";
        });
        future.get();
        System.out.println("main thread");
    }
}

package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTaskTest
 *
 * @author liuruichao
 * @date 15/7/17 下午2:21
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<String>(() -> {
            System.out.println("liuruichao");
            return "liuruichao";
        });
        new Thread(future).start();
        System.out.println("result : " + future.get());
    }
}

package test;

import java.util.concurrent.*;

/**
 * Test3
 *
 * @author liuruichao
 * @date 15/7/16 下午5:04
 */
public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Boolean> future = exec.submit(() -> {
            Thread.sleep(3000);
            System.out.println("exec");
            return true;
        });
//        future.cancel(true);
        System.out.println("isDone:" + future.isDone());
        System.out.println("isCancel:" + future.isCancelled());
        if(!future.isCancelled()) {
            System.out.println("result:" + future.get());
        }
        exec.shutdown();
    }
}

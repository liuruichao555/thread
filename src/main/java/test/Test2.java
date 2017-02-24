package test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Test2
 *
 * @author liuruichao
 * @date 15/7/16 下午4:59
 */
public class Test2 {
    public static void main(String[] args) {
        Executor exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 50; i++) {
            exec.execute(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println("liuruichao");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

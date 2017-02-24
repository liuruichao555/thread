package demo16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicIntegerTest
 *
 * @author liuruichao
 * @date 15/8/24 下午3:21
 */
public class AtomicIntegerTest {
    //static int num = 0;
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 9; i++) {
            exec.execute(() -> {
                while (true) {
                    try {
                        //System.out.println(num++);
                        System.out.println(Thread.currentThread().getName() + " : " + num.incrementAndGet());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

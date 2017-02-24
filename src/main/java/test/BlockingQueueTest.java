package test;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * BlockingQueueTest
 *
 * @author liuruichao
 * @date 15/7/16 下午5:39
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        final Executor exec = Executors.newCachedThreadPool();
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        exec.execute(() -> {
            try {
                Thread.sleep(5000);
                String name = queue.take();
                System.out.println(System.currentTimeMillis() + " take name : " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 11; i++) {
            queue.put("liuruichao" + i);
            System.out.println(System.currentTimeMillis() + " queue put " + i);
        }
        System.out.println(System.currentTimeMillis() + " done");
    }
}

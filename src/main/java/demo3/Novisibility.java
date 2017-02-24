package demo3;

import org.apache.http.annotation.NotThreadSafe;

/**
 * 可能会持续循环下去（重排序）
 * 读线程看到的顺序可能与写入的顺序完全相反，例如：ready = true, number = 0
 *
 * @author liuruichao
 * @date 15/6/9 下午3:48
 */
@NotThreadSafe
public class Novisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}

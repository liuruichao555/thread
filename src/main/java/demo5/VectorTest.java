package demo5;

import org.apache.log4j.Logger;

import java.util.Vector;

/**
 * VectorTest
 *
 * @author liuruichao
 * @date 15/6/19 下午2:58
 */
public class VectorTest {
    private static Logger logger = Logger.getLogger(VectorTest.class);
    public static void main(String[] args) {
        final Vector<Object> list = new Vector<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getLast(list);
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deleteLast(list);
            }).start();
        }
    }

    public static Object getLast(Vector<Object> list) {
        int lastIndex = list.size() - 1;
        logger.info("get last index : " + lastIndex);
        return list.get(lastIndex);
    }

    public static Object deleteLast(Vector<Object> list) {
        int lastIndex = list.size() - 1;
        logger.info("delete last index : " + lastIndex);
        return list.remove(lastIndex);
    }
}

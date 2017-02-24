package demo4;

import java.util.Vector;

/**
 * 没有则添加
 *
 * @author liuruichao
 * @date 15/6/15 下午3:14
 */
public class BetterVector extends Vector {
    public synchronized boolean putIfAbsent(Object obj) {
        boolean absent = !contains(obj);
        if (absent) {
            add(obj);
        }
        return absent;
    }
}

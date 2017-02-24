package demo5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 比1好点，但是还是存在计算两次的问题
 *
 * @author liuruichao
 * @date 15/7/17 下午3:20
 */
public class Menoizer2<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Menoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);

        }
        return result;
    }
}
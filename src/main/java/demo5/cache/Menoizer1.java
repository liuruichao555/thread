package demo5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * 最简单的一种缓存，有很多优化、改进的空间
 *
 * @author liuruichao
 * @date 15/7/17 下午3:20
 */
public class Menoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Menoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);

        }
        return result;
    }
}
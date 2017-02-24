package demo5.cache;

import org.apache.http.annotation.GuardedBy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 比2好多了，但是还是存在计算两次的问题
 *
 * @author liuruichao
 * @date 15/7/17 下午3:20
 */
public class Menoizer3<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Menoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            FutureTask<V> ft = new FutureTask<V>(() -> c.compute(arg));
            f = ft;
            cache.put(arg, ft);
            // 这里需要同步执行，而不是异步
            ft.run();
        }
        try {
            return f.get();
        } catch (Exception e) {
            // 需要向上层代码报错
            e.printStackTrace();
            throw new InterruptedException();
        }
    }
}
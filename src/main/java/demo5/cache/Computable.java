package demo5.cache;

/**
 * Computable
 *
 * @author liuruichao
 * @date 15/7/17 下午3:24
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
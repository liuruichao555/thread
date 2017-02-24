package demo15;

/**
 * CasCounter
 *
 * @author liuruichao
 * @date 15/8/24 上午10:04
 */
public class CasCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}

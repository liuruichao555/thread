package demo4;

import demo2.Widget;
import org.apache.http.annotation.GuardedBy;

/**
 * PrivateLock
 *
 * @author liuruichao
 * @date 15/6/10 下午2:25
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // 访问或修改Widget的状态
        }
    }
}

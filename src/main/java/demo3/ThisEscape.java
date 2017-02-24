package demo3;


import java.awt.*;
import java.util.EventListener;

/**
 * ThisEscape
 *
 * @author liuruichao
 * @date 15/6/9 下午5:08
 */
public class ThisEscape {

    // 隐式地使this引用逸出
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    public void doSomething(Event event) {
        // 空实现
    }

}
class EventSource {
    public void registerListener(EventListener listener) {
        // 空实现
    }
}
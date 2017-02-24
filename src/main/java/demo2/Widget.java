package demo2;

/**
 * 锁的操作粒度是“线程”，而不是“调用”
 *
 * @author liuruichao
 * @date 15/6/9 下午3:40
 */
public class Widget {
    public synchronized void doSomething() {
        System.out.println("Widget");
    }
}

class LogginWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        // !!! 如果内置锁不是可重入的，那么这段代码将发生死锁 !!!
        super.doSomething();
    }
}

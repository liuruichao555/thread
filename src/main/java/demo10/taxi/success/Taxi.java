package demo10.taxi.success;

import org.apache.http.annotation.ThreadSafe;

/**
 * Taxi
 *
 * @author liuruichao
 * @date 15/8/8 下午2:47
 */
@ThreadSafe
public class Taxi {
    private Point location, destination; // 目的地
    private final Dispatcher dispatcher;

    public Taxi(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        boolean readchedDestination;
        // 同步代码块尽量小
        synchronized (this) {
            this.location = location;
            readchedDestination = location.equals(destination);
        }
        if (readchedDestination) {
            dispatcher.notifyAvailable(this);
        }
    }
}

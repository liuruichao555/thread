package demo10.taxi.fail;

import org.apache.http.annotation.GuardedBy;

import java.util.HashSet;
import java.util.Set;

/**
 * Dispatcher
 *
 * @author liuruichao
 * @date 15/8/8 下午2:49
 */
public class Dispatcher {
    @GuardedBy("this")
    private final Set<Taxi> taxis;
    @GuardedBy("this")
    private final Set<Taxi> availableTaxis;

    public Dispatcher() {
        taxis = new HashSet<>();
        availableTaxis = new HashSet<>();
    }

    public synchronized void notifyAvailable(Taxi taxi) {
        availableTaxis.add(taxi);
    }

    public synchronized Image getImage() {
        Image image = new Image();
        for (Taxi t : taxis) {
            image.drawMarker(t.getLocation());
        }
        return image;
    }
}

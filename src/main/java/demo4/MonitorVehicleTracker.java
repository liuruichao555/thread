package demo4;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MonitorVehicleTracker
 *
 * @author liuruichao
 * @date 15/6/10 下午3:07
 */
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = locations;
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return locations;
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> mutablePointMap) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : mutablePointMap.keySet()) {
            result.put(id, new MutablePoint(mutablePointMap.get(id)));
        }
        // 不能修改map
        return Collections.unmodifiableMap(result);
    }
}

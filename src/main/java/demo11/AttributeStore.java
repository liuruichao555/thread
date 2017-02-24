package demo11;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 锁的持有时间过长
 *
 * @author liuruichao
 * @date 15/8/9 下午9:45
 */
@ThreadSafe
public class AttributeStore {
    @GuardedBy("this")
    private final Map<String, String> attributes = new HashMap<>();

    public synchronized boolean userLocationMatches(String name, String regexp) {
        String key = "user." + name + ".location";
        String location = attributes.get(key);
        if (location == null) {
            return false;
        } else {
            return Pattern.matches(regexp, location);
        }
    }
}

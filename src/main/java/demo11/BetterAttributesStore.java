package demo11;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 锁的持有时间变短了
 *
 * @author liuruichao
 * @date 15/8/9 下午9:47
 */
@ThreadSafe
public class BetterAttributesStore {
    @GuardedBy("this")
    private final Map<String, String> attributes = new HashMap<>();

    public boolean userLocationMatches(String name, String regexp) {
        String key = "user." + name + ".location";
        String location;
        synchronized (this) {
            location = attributes.get(key);
        }
        if (location == null) {
            return false;
        } else {
            return Pattern.matches(regexp, location);
        }
    }
}

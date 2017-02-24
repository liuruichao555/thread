package demo4;

import org.apache.http.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ListHelper
 *
 * @author liuruichao
 * @date 15/6/15 下午3:25
 */
@NotThreadSafe
public class ListHelper {
    public List<String> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(String str) {
        boolean absent = !list.contains(str);
        if (absent) {
            list.add(str);
        }
        return absent;
    }
}

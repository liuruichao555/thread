package demo3;

import org.apache.http.annotation.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * ThreeStooges
 *
 * @author liuruichao
 * @date 15/6/9 下午5:18
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooges() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }
}

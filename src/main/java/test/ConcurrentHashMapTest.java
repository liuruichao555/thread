package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMapTest
 *
 * @author liuruichao
 * @date 15/7/17 下午3:42
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        System.out.println(map.putIfAbsent("liuruichao", 1));
        System.out.println(map.putIfAbsent("liuruichao", 1));
    }
}

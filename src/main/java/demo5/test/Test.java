package demo5.test;

import java.util.HashMap;
import java.util.Map;

/**
 * PrimeGenerator
 *
 * @author liuruichao
 * @date 15/7/21 下午5:04
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String name = "liuruichao";
        System.out.println(map.put("liuruichao", name));
        System.out.println(map.put("liuruichao", name));
    }
}

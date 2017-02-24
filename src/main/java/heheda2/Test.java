package heheda2;

import java.util.HashMap;
import java.util.Map;

/**
 * Test
 *
 * @author liuruichao
 * @date 15/11/27 下午1:25
 */
public class Test {
    private static String name = "liuruichao";

    public static void main(String[] args) {
        //String temp = getName();
        //temp = "buzhidao";
        //System.out.println(getName());

//        final List<String> list = new ArrayList<>();
//        for (int i = 0; i < 100000; i++) {
//            list.add("liuruichao");
//        }
//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> {
//                Iterator<String> iterator = list.iterator();
//                while (iterator.hasNext()) {
//                    iterator.next();
//                    iterator.remove();
//                }
//            }).start();
//        }
        Map<String, String> map = new HashMap<>();
        map.put("name", "liuruichao");
        map.remove("name");
        System.out.println(map.size());
    }

    public static String getName() {
        return name;
    }
}

package demo12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DCLTest
 *
 * @author liuruichao
 * @date 15/9/1 下午4:03
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("liuruichao");
        list.add("liuruichao");
        list.add("liuruichao");
        list.add("liuruichao");
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        System.out.println(list.size());
    }
}

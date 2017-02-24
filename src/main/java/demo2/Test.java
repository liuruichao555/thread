package demo2;

import java.util.Vector;

/**
 * 如果要把多个操作合并为一个复合操作，还是需要额外的加锁机制
 *
 * @author liuruichao
 * @date 15/6/9 下午3:44
 */
public class Test {
    public static void main(String[] args) {
        Integer element = 1;
        Vector<Integer> vector = new Vector<Integer>();
        // 存在竞态条件，需要额外的加锁机制
        if (!vector.contains(element)) {
            vector.add(element);
        }
    }
}

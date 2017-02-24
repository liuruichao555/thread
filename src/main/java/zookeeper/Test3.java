package zookeeper;

/**
 * Test3
 * 
 * @author liuruichao
 * Created on 2016-01-11 10:08
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            test();
        } finally {
            System.out.println("finally");
        }
    }

    private static void test() {
        int a = 1 / 0;
        System.out.println("heheda");
    }
}

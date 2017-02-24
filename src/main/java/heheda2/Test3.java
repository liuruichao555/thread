package heheda2;

import java.util.HashMap;

/**
 * Test3
 * 
 * @author liuruichao
 * Created on 2016-01-14 15:53
 */
public class Test3 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.getClass().getClassLoader());
        String str = "liuruichao";
        System.out.println(str.getClass().getClassLoader());
        MyClass myClass = new MyClass();
        System.out.println(myClass.getClass().getClassLoader());
    }

    private static class MyClass {
    }
}

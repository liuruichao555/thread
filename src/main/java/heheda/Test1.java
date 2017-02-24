package heheda;

/**
 * Test1
 * 
 * @author liuruichao
 * Created on 2016-01-12 14:19
 */
public class Test1 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
    }

    private static class MyClass {
        MyClass() {
            show();
            System.out.println("MyClass init.");
        }

        public void show() {
            System.out.println("show method.");
        }
    }
}

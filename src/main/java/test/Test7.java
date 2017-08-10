package test;

/**
 * 锁重入
 *
 * @author liuruichao
 * Created on 2017/8/10 15:01
 */
public class Test7 {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();
    }

    private static class Person {
        private synchronized void show() {
            print();
            System.out.println("show");
        }

        private synchronized void print() {
            System.out.println("print");
        }
    }
}

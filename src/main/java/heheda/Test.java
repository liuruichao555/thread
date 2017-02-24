package heheda;

/**
 * Test
 * 
 * @author liuruichao
 * Created on 2016-01-13 13:55
 */
public class Test {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        MyClass1 myClass1 = new MyClass1();
        MyClass2 myClass2 = new MyClass2();
        myClass1.start();
        myClass2.start();
    }

    private static class MyClass1 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }
    }

    private static class MyClass2 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}

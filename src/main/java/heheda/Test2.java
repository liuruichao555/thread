package heheda;

/**
 * 执行结果:
   Thread-0 before : null
   赋值操作.
   Thread-0 after : liuruichao
   Thread-1 before : null
   Thread-1 after : liuruichao
   Thread-0 before : liuruichao
   Thread-1 before : liuruichao
 * @author liuruichao
 * Created on 2016-01-13 13:34
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyClass myClass = new MyClass();
        Thread t1 = new Thread(myClass);
        Thread t2 = new Thread(myClass);
        t1.start();
        t2.start();
    }

    private static class MyClass implements Runnable {
        private String str = null;

        @Override
        public void run() {
            /*synchronized (this) {
                System.out.println(Thread.holdsLock(this));
            }
            System.out.println(Thread.holdsLock(this));*/
            while (true) {
                try {
                    System.out.println(String.format("%s before : %s", Thread.currentThread().getName(), str));
                    if (str == null) {
                        str = "liuruichao";
                        System.out.println("赋值操作.");
                    }
                    System.out.println(String.format("%s after : %s", Thread.currentThread().getName(), str));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

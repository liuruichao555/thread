package test;

/**
 * Test4
 * 
 * @author liuruichao
 * Created on 2016-02-18 16:25
 */
public class Test4 {
    public static void main(String[] args) {
        StringBuffer sbu = new StringBuffer();
        MyThread myThread = new MyThread(sbu);
        for (int i = 0; i < 3; i++) {
            new Thread(myThread).start();
        }
    }

    private static class MyThread implements Runnable {
        private StringBuffer sbu;

        public MyThread(StringBuffer sbu) {
            this.sbu = sbu;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                sbu.append(i);
                if (sbu.length() > 100000) {
                    break;
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("thread %s time %s.", Thread.currentThread().getName(), (endTime - startTime)));
        }
    }
}

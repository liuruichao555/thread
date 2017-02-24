package com.liuruichao.wait;

/**
 * result : state : WAITING
            state : WAITING
            state : BLOCKED
            state : RUNNABLE
            obj ~~~
            state : RUNNABLE
 *
 * @author liuruichao
 * @date 15/8/20 下午2:44
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Object obj = new Object();
        MyThread t1 = new MyThread(obj);
        t1.start();
        System.out.println("state : " + t1.getState().name());
        Thread.sleep(1000);
        System.out.println("state : " + t1.getState().name());
        synchronized (obj) {
            obj.notify();
        }
        System.out.println("state : " + t1.getState().name());
    }

    private static class MyThread extends Thread{
        private Object obj;

        public MyThread(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            try {
                synchronized (obj) {
                    obj.wait();
                    System.out.println("state : " + getState().name());
                    Thread.sleep(5000);
                    System.out.println("obj ~~~");
                }
                System.out.println("state : " + getState().name());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

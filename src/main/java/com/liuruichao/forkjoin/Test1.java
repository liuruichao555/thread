package com.liuruichao.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Test1
 * 
 * @author liuruichao
 * Created on 2016-04-12 10:33
 */
public class Test1 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask<String> task = new MyForkJoinTask<>("liuruichao1");
        String invokeResult = forkJoinPool.invoke(task);
        System.out.println(invokeResult);
    }

    private static class MyForkJoinTask<V> extends ForkJoinTask<V> {
        private V value;
        private boolean success = false;

        public MyForkJoinTask(V value) {
            this.value = value;
        }

        @Override
        public V getRawResult() {
            return value;
        }

        @Override
        protected void setRawResult(V value) {
            this.value = value;
        }

        @Override
        protected boolean exec() {
            System.out.println("exec");
            return true;
        }
    }
}
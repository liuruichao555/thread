package com.liuruichao.singleton;

/**
 * 提前初始化
 *
 * @author liuruichao
 * @date 15/9/7 下午12:54
 */
public class Test2 {
    private static class MyClass {
        private static MyClass instance = new MyClass();

        private MyClass() {
            System.out.println("init");
        }

        public static MyClass getInstance() {
            return instance;
        }
    }
}

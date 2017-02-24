package com.liuruichao.singleton;

/**
 * 延长初始化占位符模式
 *
 * @author liuruichao
 * @date 15/9/7 下午12:49
 */
public class Test1 {
    private static class MyClassFactory {
        private static class MyClassHolder {
            public static MyClass instance = new MyClass();
        }

        public static MyClass getMyClass() {
            return MyClassHolder.instance;
        }
    }

    private static class MyClass {
        private MyClass() {
        }
    }
}

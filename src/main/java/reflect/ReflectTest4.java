package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectTest4
 *
 * @author liuruichao
 * Created on 2017/4/3 22:14
 */
public class ReflectTest4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Person.class;
        Method method = clazz.getMethod("print", String.class, int.class);
        method.invoke(new Person(), "liuruichao", 2);

        method = clazz.getMethod("print");
        method.invoke(new Person());
    }

    private static class Person {
        public void print(String name, int age) {
            System.out.println(String.format("name: %s, age: %s.", name, age));
        }

        public static void print() {
            System.out.println("静态方法！");
        }
    }
}

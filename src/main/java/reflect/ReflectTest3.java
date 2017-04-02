package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectTest3
 *
 * @author liuruichao
 * Created on 2017/4/2 22:13
 */
public class ReflectTest3 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Dog dog = new Dog("xiaohei", 2);
        Class<Dog> clazz = Dog.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("print")) {
                method.invoke(dog);
            }
        }
    }

    private static class Dog {
        private String name;

        private int age;

        Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void print() {
            System.out.println(String.format("name: %s, age: %s.", name, age));
        }
    }
}

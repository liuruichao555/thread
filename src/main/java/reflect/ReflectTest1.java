package reflect;

import java.lang.reflect.Field;

/**
 * ReflectTest1
 *
 * @author liuruichao
 * Created on 2017/3/14 17:28
 */
public class ReflectTest1 {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person(1, "liuruichao", 20);
        Class<?> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 抑制Java对修饰符的检查
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
    }

    private static class Person {
        private int id;

        private String name;

        private int age;

        Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }
}

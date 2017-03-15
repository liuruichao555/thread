package reflect;

/**
 * ReflectTest2
 *
 * Class.forName(className)方法，内部实际调用的方法是  Class.forName(className,true,classloader);

 第2个boolean参数表示类是否需要初始化，  Class.forName(className)默认是需要初始化。

 一旦初始化，就会触发目标对象的 static块代码执行，static参数也也会被再次初始化。



 ClassLoader.loadClass(className)方法，内部实际调用的方法是  ClassLoader.loadClass(className,false);

 第2个 boolean参数，表示目标对象是否进行链接，false表示不进行链接，由上面介绍可以，

 不进行链接意味着不进行包括初始化等一些列步骤，那么静态块和静态对象就不会得到执行
 *
 * @author liuruichao
 * Created on 2017/3/15 17:47
 */
public class ReflectTest2 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = Person.class;
        // 创建一个实例
        Person person = (Person) clazz.newInstance();
        System.out.println(person);
    }

    private static class Person {
        private int id;

        private String name;

        private int age;

        public Person() {
        }

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

package reflect;

/**
 * ReflectTest1
 *
 * @author liuruichao
 * Created on 2017/3/14 17:28
 */
public class ReflectTest1 {
    public static void main(String[] args) {
        System.out.println(Person.getInstance());
    }

    private static class Person {
        private String name;

        private int age;

        private Person () {
            System.out.println("person");
        }

        private static class PersonHolder {
            private static final Person person = new Person();
        }

        public static Person getInstance() {
            return PersonHolder.person;
        }
    }
}

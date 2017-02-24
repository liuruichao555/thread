package test;

import java.util.ArrayList;
import java.util.List;

/**
 * ListTest
 *
 * @author liuruichao
 * @date 15/7/29 下午1:06
 */
public class ListTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Person(i, "liuruichao" + i, 20 + i));
        }
        Person person = list.stream().max((p1, p2) -> {
            return p1.getAge() - p2.getAge();
        }).get();
        System.out.println(person);
    }
}
class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
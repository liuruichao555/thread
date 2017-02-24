package cyclicBarrier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Test1
 *
 * @author liuruichao
 * Created on 2016-04-01 10:49
 */
public class Test1 {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogs.add(new Dog("buzhidao" + i, i));
        }
        Iterator<Dog> iterator = dogs.stream().filter(dog -> dog.getAge() > 5).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        List<Dog> result = dogs.stream().filter(dog -> dog.getAge() > 5).collect(Collectors.toList());
        result.add(new Dog("heheda", 1));
        System.out.println(result.size());

        /*Scanner in = new Scanner(System.in);
        System.out.print("请输入姓名简写:");
        String simpleName = in.next();
        switch (simpleName) {
            case "lrc":
                System.out.println("刘瑞超");
                break;
            case "bzd":
                System.out.println("不知道");
                break;
            default:
                System.out.println("我也不知道你叫什么");
                break;
        }*/
    }

    private static class Dog {
        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
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
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

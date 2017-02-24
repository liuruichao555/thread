package com.liuruichao.safepublish;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Test2
 * 
 * @author liuruichao
 * Created on 2016-04-12 15:04
 */
public class Test2 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            list.add(new Person(i, "liuruichao" + i, 20));
        }
        List<Person> list2 = list.stream().filter(person -> person.getId() > 5).collect(Collectors.toList());
        System.out.println(list2.getClass());
        list2.forEach(System.out::println);
    }

    private static class Person {
        private Integer id;
        private String name;
        private Integer age;

        Person(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
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

package joda;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Test1
 *
 * @author liuruichao
 *         Created on 2016-03-28 16:39
 */
public class JodaTest1 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            DateTime time = test1();
            System.out.println(time);
            list.add(new Person());
        }
    }

    private static DateTime test1() {
        DateTime time = new DateTime();
        time = time.plusDays(7).plusSeconds(30);
        return time;
        //System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));
    }

    private static class Person {
        private long age1;
        private long age2;
        private long age3;
        private long age4;

        public long getAge1() {
            return age1;
        }

        public void setAge1(long age1) {
            this.age1 = age1;
        }

        public long getAge2() {
            return age2;
        }

        public void setAge2(long age2) {
            this.age2 = age2;
        }

        public long getAge3() {
            return age3;
        }

        public void setAge3(long age3) {
            this.age3 = age3;
        }

        public long getAge4() {
            return age4;
        }

        public void setAge4(long age4) {
            this.age4 = age4;
        }
    }
}

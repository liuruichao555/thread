package com.liuruichao.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Test8
 *
 * @author liuruichao
 * @date 15/8/20 下午3:48
 */
public class Test8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("liuruichao1");
        list.add("liuruichao2");
        list.add("liuruichao3");
        list.add("liuruichao4");
        list.add("liuruichao5");
    }

    private static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

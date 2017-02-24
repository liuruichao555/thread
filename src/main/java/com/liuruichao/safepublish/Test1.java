package com.liuruichao.safepublish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AtomicIntegerTest
 *
 * @author liuruichao
 * @date 15/8/24 上午10:12
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("liuruichao1");
        list1.add("liuruichao2");
        list1.add("liuruichao3");
        List<String> list2 = new ArrayList<>(list1);
        list2.clear();
        System.out.println(list2.size());
        System.out.println(list1.size());
    }
}

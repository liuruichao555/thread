package com.liuruichao.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Test1
 *
 * @author liuruichao
 * Created on 2015-12-28 10:29
 */
public class StringTest {
    public static void main(String[] args) {
        final String numberList = "One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten";
        //String[] tokens1 = StringUtils.split(numberList, ',');
        //for (String str : tokens1) {
        //    System.out.println(str);
        //}

        //Iterable<String> tokens2 = Splitter.on(",").split(numberList);
        //for (String s : tokens2) {
        //    System.out.println(s);
        //}

        //String name = "";
        //System.out.println(Strings.isNullOrEmpty(name));

        /*String a = "com.liuruichao.heheda";
        String b = "com.liuruichao.nicai";
        String commonPrefix = Strings.commonPrefix(a, b);
        System.out.println(commonPrefix);

        String c = "com.laasdfsa.liuruichao";
        String d = "asdfa.liuruichao";
        String commonSuffix = Strings.commonSuffix(c, d);
        System.out.println(commonSuffix);*/

        /*int minLen = 4;
        String padEndResult = Strings.padEnd("123", minLen, '0');
        System.out.println(padEndResult); // 1230

        String padStartResult = Strings.padStart("123", minLen, '0');
        System.out.println(padStartResult); // 0123*/

        /*String splitString = "a=1,b=2,c=3";
        Map<String, String> kvs = Splitter.on(",").withKeyValueSeparator('=').split(splitString);
        for (Map.Entry<String, String> entry : kvs.entrySet()) {
            System.out.println(String.format("key : %s, value : %s .", entry.getKey(), entry.getValue()));
        }*/

        /*String joinResult = Joiner.on(" ").join(new String[]{"liuruichao1", "liuruichoa2", "liuruichao3"});
        System.out.println(joinResult);*/

        Map<String, String> map = new HashMap<>();
        map.put("name", "liuruichao");
        map.put("age", "20");
        String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(result);
    }
}

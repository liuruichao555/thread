package com.liuruichao.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Test4
 *
 * @author liuruichao
 * @date 15/7/29 上午9:40
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("请输入：");
        String str = reader.readLine();
        // JVM 需要设置开启
        assert str == null : "null";

        reader.close();
    }
}

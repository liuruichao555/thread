package com.liuruichao.kanwokanwo;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Test1
 * 
 * @author liuruichao
 * Created on 2016-04-10 10:21
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        URL uri = new URL("https://www.kanwokanwo.com");
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Cookie", "94F147DDB8E4B391A89A7BEC205D85C9-n1");
        if (conn.getResponseCode() == 200) {
            System.out.println("heheda");
        } else {
            System.out.println("访问失败!");
        }
    }
}

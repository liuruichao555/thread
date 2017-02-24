package com.liuruichao.languagetool;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * SimulatedCAS
 *
 * @author liuruichao
 * @date 15/8/20 下午3:26
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        String text = "how are you";
        String url = "http://localhost:8081/?language=en&text=" + text;
        URL uri = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            String str = null;
            int len = -1;
            byte[] buffer = new byte[1024];
            InputStream in = conn.getInputStream();
            while ((len = in.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } else {
            System.out.println("error");
        }
    }
}

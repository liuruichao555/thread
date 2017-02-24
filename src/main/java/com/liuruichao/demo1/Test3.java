package com.liuruichao.demo1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Test3
 *
 * @author liuruichao
 * @date 15/6/11 下午3:12
 */
public class Test3 {
    private static Logger logger = Logger.getLogger(Test3.class);
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse response = client.execute(httpGet);
        byte[] b = new byte[1024];
        int len = -1;
        StringBuffer sbu = new StringBuffer();
        InputStream in = response.getEntity().getContent();
        while ((len = in.read(b)) != -1) {
            sbu.append(new String(b, 0, len));
        }
        System.out.println(sbu.toString());
        logger.info("job done.");
    }
}

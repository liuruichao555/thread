package com.liuruichao.b1;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 单线程访问结果：
 *     3637
 *     2945
 *     2970
 *     2923
 *     3274
 *     2956
 *     2910
 *     3055
 *     3493
 *     3576
 * 多线程访问结果：
 *     2490
 *     2243
 *     3147
 *     2213
 *     2026
 *     2661
 *     2441
 *     1864
 *     1924
 *     1863
 *
 * @author liuruichao
 * Created on 2018/4/18 10:25
 */
public class Test1 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
    public static void main(String[] args) throws Exception {
        String url1 = "https://api.b1.run/markets";
        String url2 = "https://api.b1.run/markets/FAIR-BTC";

        //test1(url1, url2);
        test2(url1, url2);
        executor.shutdown();
    }

    public static void test2(String url1, String url2) throws IOException, InterruptedException, ExecutionException {
        List<Long> list = new ArrayList<>(10);
        for (int i = 0;i < 10;i ++) {
            long startTime = System.currentTimeMillis();

            completionService.submit(() -> GET(url1));
            completionService.submit(() -> GET(url2));

            for (int j = 0; j < 2; j++) {
                Future<String> future = completionService.take();
                System.out.println(future.get());
            }

            long endTime = System.currentTimeMillis();
            list.add(endTime - startTime);
        }
        list.forEach(System.out::println);
    }

    public static void test1(String url1, String url2) throws IOException {
        List<Long> list = new ArrayList<>(10);
        for (int i = 0;i < 10;i ++) {
            long startTime = System.currentTimeMillis();
            String result1 = GET(url1);
            String result2 = GET(url2);
            long endTime = System.currentTimeMillis();
            list.add(endTime - startTime);
        }
        list.forEach(System.out::println);
    }

    public static String GET(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, "utf-8");
        }
        System.out.println("status code: " + response.getStatusLine().getStatusCode());
        return null;
    }
}

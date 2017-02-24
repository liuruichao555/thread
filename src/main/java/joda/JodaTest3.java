package joda;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

/**
 * JodaTest3
 * 
 * @author liuruichao
 * Created on 2016-05-11 13:21
 */
public class JodaTest3 {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>(3);
        //for (int i = 0; i < 10; i++) {
        //    list.add("liuruichao" + i);
        //}
        //Spliterator<String> spliterator = list.spliterator();
        //Spliterator<String> spliterator1 = spliterator.trySplit();
        //spliterator1.forEachRemaining(System.out::println);

        //DateTime time = new DateTime();
        //DateTime oldTime = time;
        //time = time.plusMinutes(5);
        //System.out.println(time == oldTime);
        //System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));

        //DateTime time = new DateTime(1970, 12, 2, 14, 50);
        //System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));

        Scanner in = new Scanner(System.in);
        System.out.print("请输入简写名称:");
        String simpleName = in.next();
        switch (simpleName) {
            case "lrc":
                System.out.println("刘瑞超");
                break;
            case "bzd":
                System.out.println("不知道");
                break;
            case "hhd":
                System.out.println("呵呵哒");
                break;
            default:
                System.out.println("你说的什么?");
        }
    }
}

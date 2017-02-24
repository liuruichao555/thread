package com.liuruichao.guava;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * JodaTimeTest
 * 
 * @author liuruichao
 * Created on 2015-12-28 11:19
 */
public class JodaTimeTest {
    public static void main(String[] args) {
        /*DateTime time = new DateTime();
        System.out.println(time.plusDays(5).toString("yyyy-MM-dd HH:mm:ss"));*/

        // 45天之后的某一天 在下个月当前周的最后一天
        /*DateTime time = new DateTime();
        System.out.println(time.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss"));*/
        // 本周的最后一天
        //System.out.println(time.dY2KayOfWeek().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss"));

        Date date = new Date(1832, 1, 1, 0, 0, 0);
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));

        DateTime time = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
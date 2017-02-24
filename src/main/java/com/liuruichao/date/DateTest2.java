package com.liuruichao.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java.time
 *
 * @author liuruichao
 * @date 15/8/3 上午9:56
 */
public class DateTest2 {
    public static void main(String[] args) {
        // 时间格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        LocalDate date = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        String str = time.format(formatter);
        System.out.println("date : " + date);
        System.out.println("date time : " + str);
    }
}

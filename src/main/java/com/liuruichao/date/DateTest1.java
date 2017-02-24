package com.liuruichao.date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * DateTest1
 *
 * @author liuruichao
 * @date 15/7/29 下午2:26
 */
public class DateTest1 {
    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        System.out.println(DigestUtils.md5Hex("123456"));
        System.out.println("Hello World!");
    }
}

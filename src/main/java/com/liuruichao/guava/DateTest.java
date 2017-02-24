package com.liuruichao.guava;

import com.google.common.escape.Escaper;
import com.google.common.html.HtmlEscapers;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * 貌似guava没有处理时间的就只能用apache了
 * 还有一个joda
 * 
 * @author liuruichao
 * Created on 2015-12-28 10:52
 */
public class DateTest {
    public static void main(String[] args) {
        /*Escaper escaper = HtmlEscapers.htmlEscaper();
        System.out.println(escaper.escape("<script>console.log('liuruichao')</script>"));*/
        Date curDate = new Date();
        System.out.println(DateFormatUtils.format(curDate, "yyyy-MM-dd HH:mm:ss"));
    }
}

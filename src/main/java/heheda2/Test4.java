package heheda2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Test4
 * 
 * @author liuruichao
 * Created on 2016-02-29 14:20
 */
public class Test4 {
    public static void main(String[] args) {
        String str = "<a href='http://www.baidu.com'>百度</a>" +
                "<a href='http://www.sina.com.cn'>新浪</a><a href='http://www.qq.com'>腾讯</a>liurui";
        Pattern pattern = Pattern.compile("<a href='(.*?)'>(.*?)</a>");
        Matcher matcher = pattern.matcher(str);
        // 部分匹配,可以用while循环,匹配成功会从下个子串开始匹配
        while (matcher.find()) {
            System.out.println("count: " + matcher.groupCount());
            System.out.println("group 1:" + matcher.group(1));
            System.out.println("group 2:" + matcher.group(2));
            System.out.println("group: " + matcher.group());
        }
        // 全部匹配,只有在整个字符串全部匹配的情况下才会为true,相当于在正则表达式前面后面加上^$
        if (matcher.matches()) {
            System.out.println("count: " + matcher.groupCount());
            System.out.println("group 1:" + matcher.group(1));
            System.out.println("group 2:" + matcher.group(2));
            System.out.println("group: " + matcher.group());
        }
    }
}

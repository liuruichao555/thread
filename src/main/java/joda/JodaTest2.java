package joda;

import org.joda.time.DateTime;

import java.util.Properties;
import java.util.Set;

/**
 * JodaTest2
 *
 * @author liuruichao
 *         Created on 2016-03-31 16:12
 */
public class JodaTest2 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.timezone"));
        DateTime time = new DateTime(1998, 1, 1, 1, 1);
        //System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));
        //time = time.plusSeconds(-10);
        //System.out.println(time.toString("yyyy-MM-dd HH:mm:ss"));
        Properties properties = System.getProperties();
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.out.println(String.format("key: %s, value: %s.", key, properties.get(key)));
        }
    }
}

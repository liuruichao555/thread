package demo7;

import java.io.IOException;

/**
 * 统一的异常处理器
 *
 * @author liuruichao
 * @date 15/8/4 下午1:53
 */
public class UEHLogger implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " " + e);
    }
}

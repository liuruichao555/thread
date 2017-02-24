package demo7;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 只执行一次的服务
 *
 * @author liuruichao
 * @date 15/8/4 上午10:28
 */
public class OnlyExecut {
    boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);
        try {
            for (final String host : hosts) {
                exec.execute(() -> {
                    if (checkMail(host)) {
                        hasNewMail.set(true);
                    }
                });
            }
        } finally {
            exec.shutdown();
            exec.awaitTermination(timeout, unit);
        }
        return hasNewMail.get();
    }

    boolean checkMail(String host) {
        return true;
    }
}

package demo8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ThreadDeadlock
 *
 * @author liuruichao
 * @date 15/8/4 下午2:36
 */
public class ThreadDeadlock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    private class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<?> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderBody();
            // 将发生死锁   由于任务在等待子任务的结果,并且线程池是单线程的，如果线程池里面有少量的线程也会有这个问题
            return header.get() + page + footer.get();
        }

        private String renderBody() {
            return "";
        }
    }

    private class LoadFileTask implements Runnable {
        private String url;

        public LoadFileTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            // 从网络获取html文件
        }
    }
}

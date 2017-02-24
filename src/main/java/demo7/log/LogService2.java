package demo7.log;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.*;

/**
 * 使用线程池进行操作（无需关心一些底层问题）
 *
 * @author liuruichao
 * @date 15/8/3 下午10:11
 */
public class LogService2 {
    private final ExecutorService exec;
    private final PrintWriter writer;

    public LogService2(PrintWriter writer) {
        this.exec = Executors.newCachedThreadPool();
        this.writer = writer;
    }

    public void stop() throws InterruptedException {
        exec.shutdown();
        exec.awaitTermination(5, TimeUnit.SECONDS);
    }

    public void log(String msg) throws InterruptedException {
        // 改用ExecutorService
        exec.execute(new WriteTask(msg));
    }

    private class WriteTask implements Runnable {
        private final String msg;

        public WriteTask(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            writer.println(msg);
        }
    }
}

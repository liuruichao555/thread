package demo7.log;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LogService
 *
 * @author liuruichao
 * @date 15/8/3 下午10:11
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread logger;
    private boolean isShutdown = false;
    private int reservations = 0;

    public LogService(Writer writer) {
        this.queue = new LinkedBlockingQueue<>();
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void stop() {
        // 解决静态条件问题
        synchronized (this) {
            isShutdown = true;
        }
        logger.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        // 需要检测log服务是否已经关闭(需要原子操作)
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException("logger is shut down");
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(Writer writer) {
            this.writer = (PrintWriter) writer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }
                        synchronized (LogService.this) {
                            // 处理一个日志减少待办任务，待办任务到0的时候就可以正常退出了
                            --reservations;
                        }
                        String msg = queue.take();
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // retry
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}

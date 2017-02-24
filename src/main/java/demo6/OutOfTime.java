package demo6;

import java.util.Timer;
import java.util.TimerTask;

/**
 * OutOfTime
 *
 * @author liuruichao
 * @date 15/7/28 下午12:55
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(1000);
        timer.schedule(new ThrowTask(), 1);
        Thread.sleep(1000);
    }
    static class ThrowTask extends TimerTask {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}

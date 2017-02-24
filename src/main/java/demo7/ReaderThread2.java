package demo7;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ReaderThread2
 *
 * @author liuruichao
 * @date 15/8/3 下午4:04
 */
public class ReaderThread2 extends Thread {
    private final InputStream in;

    public ReaderThread2(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interrupt() {
        try {
            // 先关闭，再打断
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }

    public static void main(String[] args) throws Exception {
        URL uri = new URL("http://www.baidu.com");
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        ReaderThread2 reader = new ReaderThread2(conn.getInputStream());
        reader.start();
        reader.interrupt();
    }
}

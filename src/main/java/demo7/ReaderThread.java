package demo7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * ReaderThread
 *
 * @author liuruichao
 * @date 15/8/3 下午3:28
 */
public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream in;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void run() {
        try {
            byte[] buf = new byte[1024];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else if (count > 0) {
                    // 操作
                }
            }
        } catch (IOException e) {
            // 线程退出
        }
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {

        } finally {
            super.interrupt();
        }
    }
}

package demo7;

/**
 * 关闭钩子
 *
 * @author liuruichao
 * @date 15/8/3 下午4:10
 */
public class ReaderThread3 {
    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("shutdown");
                super.run();
            }
        });
    }
}

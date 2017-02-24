package demo10;

/**
 * LeftRightDeadlock
 *
 * @author liuruichao
 * @date 15/8/7 下午3:58
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                System.out.println("leftRight");
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                System.out.println("rightLeft");
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadlock leftRightDeadlock = new LeftRightDeadlock();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                leftRightDeadlock.leftRight();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                leftRightDeadlock.rightLeft();
            }
        }).start();
    }
}

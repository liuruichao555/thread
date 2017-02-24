package demo5;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CellularAutomata
 *
 * @author liuruichao
 * @date 15/7/17 下午3:05
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, () -> mainBoard.commitNewValues());
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(new Board());
        }
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, computerValue(x, y));
                    }
                }
                try {
                    // 等待其他线程执行完毕！！！
                    barrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }

        private int computerValue(int x, int y) {
            return 0;
        }
    }
    private class Board {
        private int x, y;

        public boolean hasConverged() {
            return false;
        }

        public int getMaxX() {
            return 10;
        }

        public int getMaxY() {
            return 10;
        }

        public void setNewValue(int x, int y, int newValue) {
            this.x = x;
            this.y = y;
        }

        public void commitNewValues() {
            System.out.println("commit new values.");
        }
    }
}

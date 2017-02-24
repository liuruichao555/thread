package demo8.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * PuzzleSolver
 *
 * @author liuruichao
 * @date 15/8/6 下午9:21
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {
    private final AtomicInteger taskCount = new AtomicInteger(0);

    public PuzzleSolver(Puzzle<P, M> puzzle) {
        super(puzzle);
    }

    protected Runnable newTask(P p, M m, Node<P, M> node) {
        return new CountingSolverTask(p, m, node);
    }

    class CountingSolverTask extends SolverTask {
        public CountingSolverTask(P pos, M move, Node<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        @Override
        public void run() {
            try {
                super.run();
            } finally {
                // 所有任务都执行完成，则置为null(solution有判断，不影响结果)
                if (taskCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }
}

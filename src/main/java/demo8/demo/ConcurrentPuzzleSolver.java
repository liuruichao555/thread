package demo8.demo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发的谜题解答器
 *
 * @author liuruichao
 * @date 15/8/6 下午9:04
 */
public class ConcurrentPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentMap<P, Boolean> seen;
    final ValueLatch<Node<P, M>> solution;

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
        this.exec = Executors.newCachedThreadPool();
        this.seen = new ConcurrentHashMap<>();
        this.solution = new ValueLatch<>();
    }

    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p, null, null));
            // 阻塞直到找到解答
            Node<P, M> solnNode = solution.getValue();
            return (solnNode == null) ? null : solnNode.asMoveList();
        } finally {
            // 关闭线程池
            exec.shutdown();
        }
    }

    protected Runnable newTask(P p, M m, Node<P, M> n) {
        return new SolverTask(p, m, n);
    }

    class SolverTask extends Node<P, M> implements Runnable {
        public SolverTask(P p, M m, Node<P, M> n) {
            super(p, m, n);
        }

        @Override
        public void run() {
            if (solution.isSet() || seen.putIfAbsent(pos, true) != null) {
                // 已经找到了解答或者已经遍历了这个位置
                return;
            }
            if (puzzle.isGoal(pos)) {
                // 找到了解答
                solution.setValue(this);
            } else {
                for (M m : puzzle.legalMoves(pos)) {
                    exec.execute(newTask(pos, m, prev));
                }
            }
        }
    }
}

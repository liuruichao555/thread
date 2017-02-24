package demo8.demo;

import java.util.Set;

/**
 * Puzzle
 *
 * @author liuruichao
 * @date 15/8/6 下午8:54
 */
public interface Puzzle<P, M> {
    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMoves(P position);
    P move(P position, M move);
}

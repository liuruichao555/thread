package demo8.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * 谜题解决框架的链表节点
 *
 * @author liuruichao
 * @date 15/8/6 下午8:56
 */
public class Node<P, M> {
    final P pos;
    final M move;
    final Node<P, M> prev;

    public Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    List<M> asMoveList() {
        List<M> solution = new LinkedList<>();
        for (Node<P, M> n = this; n.move != null; n = n.prev) {
            solution.add(0, n.move);
        }
        return solution;
    }
}

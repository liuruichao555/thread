package akka.mydemo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.mydemo1.event.Dead;
import akka.mydemo1.handler.DeadHandler;

/**
 * App
 *
 * @author liuruichao
 * @date 15/8/24 下午3:48
 */
public class App {
    public static void main(String[] args) {
        ActorSystem rootSystem = ActorSystem.create("rootSystem");
        ActorRef deadHandler1 = rootSystem.actorOf(Props.create(DeadHandler.class));
        ActorRef deadHandler2 = rootSystem.actorOf(Props.create(DeadHandler.class));
        rootSystem.eventStream().subscribe(deadHandler1, Dead.class);
        rootSystem.eventStream().subscribe(deadHandler2, Dead.class);

        // 发布dead事件
        rootSystem.eventStream().publish(new Dead(1));
        rootSystem.shutdown();
    }
}

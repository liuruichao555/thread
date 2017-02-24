package akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.liuruichao.akka.demo1.*;

/**
 * Main
 *
 * @author liuruichao
 * @date 15/8/12 下午3:55
 */
public class Main {

    public static void main(String[] args) {
        ActorSystem rootSystem = ActorSystem.create("rootSystem");
        ActorSystem rootSystem2 = ActorSystem.create("rootSystem");
        ActorRef ref1 = rootSystem.actorOf(Props.create(MyActor2.class));
        ActorRef ref2 = rootSystem.actorOf(Props.create(MyActor2.class));
        ActorRef ref3 = rootSystem.actorOf(Props.create(MyActor2.class));
        ActorRef ref4 = rootSystem.actorOf(Props.create(MyActor2.class));
        rootSystem.eventStream().subscribe(ref1, String.class);
        rootSystem.eventStream().subscribe(ref2, String.class);
        rootSystem.eventStream().subscribe(ref3, String.class);
        rootSystem.eventStream().subscribe(ref4, String.class);

        rootSystem.eventStream().publish(new String("liuruichao"));

        rootSystem.shutdown();
    }
}

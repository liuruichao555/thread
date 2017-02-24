package akka.demo1;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * FirstActor
 *
 * @author liuruichao
 * @date 15/8/7 下午11:47
 */
public class FirstActor extends AbstractActor {
//    final ActorSystem system = ActorSystem.create("MySystem", config);
//    final ActorRef myActor = system.actorOf(Props.create(MyActor.class), "myactor");
    final ActorRef child = context().actorOf(Props.create(MyActor.class), "myChild");
}

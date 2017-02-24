package akka.demo2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.demo2.actor.EmitterActor;
import akka.demo3.actor.Handler;

/**
 * Main
 *
 * @author liuruichao
 * @date 15/8/12 下午2:15
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem rootSystem = ActorSystem.create("rootSystem");
        ActorRef emitter = rootSystem.actorOf(Props.create(EmitterActor.class));
        ActorRef handler = rootSystem.actorOf(Props.create(Handler.class));
        // 设置监听者
        rootSystem.eventStream().subscribe(handler, Event.class);

        emitter.tell("liuruichao1", null);
        emitter.tell(new Dog("liuchangqing", 5), null);

        rootSystem.shutdown();
    }
}

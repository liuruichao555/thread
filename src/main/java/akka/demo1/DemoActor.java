package akka.demo1;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.Creator;

/**
 * 官网上demo(然并卵)
 *
 * @author liuruichao
 * @date 15/8/7 下午11:33
 */
public class DemoActor extends AbstractActor {
    private final Integer magicNumber;

    public DemoActor(Integer magicNumber) {
        this.magicNumber = magicNumber;
    }

    static Props props(Integer magicNumber) {
        return Props.create(DemoActor.class, () -> {
            return new DemoActor(magicNumber);
        });
    }

    private class SomeOtherActor extends AbstractActor {
        ActorRef demoActor = context().actorOf(DemoActor.props(42), "demo");
    }
}

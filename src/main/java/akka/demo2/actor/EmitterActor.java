package akka.demo2.actor;

import akka.actor.UntypedActor;
import akka.demo2.Dog;
import akka.demo2.Event;

/**
 * EmitterActor
 *
 * @author liuruichao
 * @date 15/8/12 下午2:16
 */
public class EmitterActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof Dog) {
            Event e = new Event();
            e.name = ((Dog) o).getName();
            getContext().system().eventStream().publish(e);
        } else {
            System.out.println("str : " + o);
        }
    }
}

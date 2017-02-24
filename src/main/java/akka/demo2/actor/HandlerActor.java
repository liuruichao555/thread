package akka.demo2.actor;

import akka.actor.UntypedActor;

/**
 * HandlerActor
 *
 * @author liuruichao
 * @date 15/8/12 下午2:15
 */
public class HandlerActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        System.out.println(o);
    }
}

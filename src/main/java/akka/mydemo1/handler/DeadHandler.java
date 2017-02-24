package akka.mydemo1.handler;

import akka.actor.UntypedActor;
import akka.mydemo1.event.Dead;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * DeadHandler
 *
 * @author liuruichao
 * @date 15/8/24 下午3:45
 */
public class DeadHandler extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof Dead) {
            Dead dead = (Dead) o;
            System.out.println("personId : " + dead.getPersonId()
                    + ", date : " + DateFormatUtils.format(dead.getDate(), "yyyy-MM-dd HH:mm:ss"));
        }
    }
}

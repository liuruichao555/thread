package akka.demo1;

import akka.actor.UntypedActor;

/**
 * MyActor2
 *
 * @author liuruichao
 * @date 15/8/12 下午3:56
 */
public class MyActor2 extends UntypedActor {

    public MyActor2() {
        System.out.println("1");
    }

    @Override
    public void onReceive(Object o) throws Exception {
        System.out.println(o);
    }
}

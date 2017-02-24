package akka.demo1;

import akka.actor.AbstractActor;
import akka.japi.pf.FI;
import akka.japi.pf.ReceiveBuilder;

/**
 * MyActor
 *
 * @author liuruichao
 * @date 15/8/7 下午11:21
 */
public class MyActor extends AbstractActor {
    public MyActor() {
        // lambda版本
        receive(ReceiveBuilder
                .match(String.class, s -> {
                    System.out.println("Received String message: " + s);
                }).matchAny(o -> System.out.println("received unknown message")).build()
        );

        // 传统写法
//        receive(ReceiveBuilder.match(String.class, new FI.UnitApply<String>() {
//            @Override
//            public void apply(String s) throws Exception {
//                System.out.println("Received String message: " + s);
//            }
//        }).matchAny(new FI.UnitApply<Object>() {
//            @Override
//            public void apply(Object o) throws Exception {
//                System.out.println("received unknown message");
//            }
//        }).build());
    }
}

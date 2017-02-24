package com.liuruichao.akka.demo1;

import akka.actor.UntypedActor;
import scala.Option;

/**
 * MyActor2
 *
 * @author liuruichao
 * @date 15/8/11 上午12:30
 */
public class MyActor2 extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        System.out.println("MyActor2 : " + o);
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("preStart");
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        System.out.println("preRestart");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("postStop");
    }
}

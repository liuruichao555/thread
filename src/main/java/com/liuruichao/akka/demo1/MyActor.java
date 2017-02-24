package com.liuruichao.akka.demo1;

import akka.actor.UntypedActor;
import scala.Option;

/**
 * MyActor
 *
 * @author liuruichao
 * @date 15/8/11 上午12:26
 */
public class MyActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        System.out.println(o);
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        System.out.println("preRestart");
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("preStart");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("postStop");
    }
}

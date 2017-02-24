package com.liuruichao.akka.demo2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Main
 *
 * @author liuruichao
 * @date 15/8/11 下午1:33
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem rootSystem = ActorSystem.create("rootSystem");
        ActorSystem rootSystem2 = ActorSystem.create("rootSystem");
        ActorRef myActor = rootSystem.actorOf(Props.create(MyActor.class), "myactor1");
        ActorRef myActor2 = rootSystem2.actorOf(Props.create(MyActor.class), "myactor2");

        System.out.println(myActor);
        System.out.println(myActor2);
        System.out.println(rootSystem);
        System.out.println(rootSystem2);

        rootSystem.shutdown();
        rootSystem2.shutdown();
    }
}

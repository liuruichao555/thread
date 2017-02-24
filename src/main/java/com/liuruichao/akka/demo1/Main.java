package com.liuruichao.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Main
 *
 * @author liuruichao
 * @date 15/8/11 上午12:26
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem rootSystem = ActorSystem.create("rootSystem");
        ActorRef actorRef = rootSystem.actorOf(Props.create(MyActor.class));
        // 第二个参数是向谁reply
        actorRef.tell("liuruichao", null);

        // 杀死一个角色(什么情况)
//        actorRef.tell(akka.handler.Kill.getInstance(), ActorRef.noSender());

        rootSystem.shutdown();
    }
}

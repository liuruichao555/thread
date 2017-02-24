package com.liuruichao.akka.demo2;

import akka.actor.UntypedActor;

/**
 * MyActor
 *
 * @author liuruichao
 * @date 15/8/11 下午1:33
 */
public class MyActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        System.out.println(o);
    }
}

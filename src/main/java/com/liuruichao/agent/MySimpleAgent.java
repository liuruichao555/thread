package com.liuruichao.agent;

import java.lang.instrument.Instrumentation;

/**
 * MySimpleAgent
 *
 * @author liuruichao
 * @date 15/9/17 下午1:45
 */
public class MySimpleAgent {
    public static void premain(String agentArgs,Instrumentation inst) {
        inst.addTransformer(new MySimpleTransformer());
    }
}

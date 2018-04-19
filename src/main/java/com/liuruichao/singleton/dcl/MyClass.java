package com.liuruichao.singleton.dcl;

/**
 * MyClass
 *
 * @author liuruichao
 * Created on 2018/4/19 14:02
 */
public class MyClass {
    private User user;

    public void sendUser() {
        if (user == null) {
            synchronized (MyClass.class) {
                if (user == null) {
                    user = new User();
                }
            }
        }
    }
}

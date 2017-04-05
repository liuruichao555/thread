package jdeferred;

import org.jdeferred.*;
import org.jdeferred.impl.DeferredObject;

/**
 * Test1
 *
 * @author liuruichao
 * Created on 2017/4/5 13:36
 */
public class Test1 {
    public static void main(String[] args) {
        Deferred deferred = new DeferredObject();
        Promise promise = deferred.promise();
        promise.done(result -> System.out.println("onDone"))
                .fail(result -> System.out.println("fail"))
                .progress(progress -> System.out.println("progress"))
                .always((state, resolved, rejected) -> System.out.println("always"));

        deferred.resolve("done");
        deferred.reject("oops");
        deferred.notify("100%");
    }
}

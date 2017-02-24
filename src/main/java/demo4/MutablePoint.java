package demo4;

import java.io.Serializable;

/**
 * MutablePoint
 *
 * @author liuruichao
 * @date 15/6/10 下午3:08
 */
public class MutablePoint implements Serializable {
    public Integer x;
    public Integer y;


    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint loc) {
        x = loc.x;
        y = loc.y;
    }
}

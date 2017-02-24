package akka.mydemo1.event;

import java.util.Date;

/**
 * 死亡事件
 *
 * @author liuruichao
 * @date 15/8/24 下午3:40
 */
public class Dead {
    private int personId;
    private Date date = new Date();

    public Dead() {
    }

    public Dead(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

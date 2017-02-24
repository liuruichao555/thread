package demo11;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.Set;

/**
 * 将锁分成了两个，一个是users一个是queries
 *
 * @author liuruichao
 * @date 15/8/9 下午9:56
 */
@ThreadSafe
public class BetterServerStatus {
    @GuardedBy("users")
    public final Set<String> users;
    @GuardedBy("queries")
    public final Set<String> queries;

    public BetterServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }

    public void removeUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void removeQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }
}

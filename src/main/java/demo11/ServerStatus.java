package demo11;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.Set;

/**
 * 都是使用了this这个相同的锁
 *
 * @author liuruichao
 * @date 15/8/9 下午9:53
 */
@ThreadSafe
public class ServerStatus {
    @GuardedBy("this")
    public final Set<String> users;
    @GuardedBy("this")
    public final Set<String> queries;

    public ServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public synchronized void addUser(String u) {
        users.add(u);
    }

    public synchronized void addQuery(String q) {
        queries.add(q);
    }

    public synchronized void removeUser(String u) {
        users.add(u);
    }

    public synchronized void removeQuery(String q) {
        queries.add(q);
    }
}

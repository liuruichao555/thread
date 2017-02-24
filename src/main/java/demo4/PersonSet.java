package demo4;

import java.util.HashSet;
import java.util.Set;

/**
 * PersonSet
 *
 * @author liuruichao
 * @date 15/6/10 下午2:15
 */
public class PersonSet {
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containsPerson(Person person) {
        return mySet.contains(person);
    }
}

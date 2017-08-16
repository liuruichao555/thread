package test;

import org.jboss.netty.util.internal.NonReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁重入
 *
 * @author liuruichao
 * Created on 2017/8/10 15:01
 */
public class Test7 {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        Dog dog = new Dog();
        dog.show();
    }

    private static class Person {
        private synchronized void show() {
            print();
            System.out.println("person show");
        }

        private synchronized void print() {
            System.out.println("person print");
        }
    }

    private static class Dog {
        //private ReentrantLock lock = new ReentrantLock();
        private Lock lock = new NonReentrantLock(); // 不可重入锁

        private void show() {
            lock.lock();
            print();
            System.out.println("dog show");
            lock.unlock();
        }

        private void print() {
            lock.lock();
            System.out.println("dog print");
            lock.unlock();
        }
    }
}

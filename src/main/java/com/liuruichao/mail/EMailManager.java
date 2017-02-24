package com.liuruichao.mail;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EMailManager
 *
 * @author liuruichao
 * @date 15/8/24 下午2:29
 */
public class EMailManager {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newFixedThreadPool(2);
        final BlockingQueue<Mail> queue = new ArrayBlockingQueue<Mail>(10);
        final MailConsumer consumer = new MailConsumer(queue);
        final MailProducer producer = new MailProducer(queue);
        for (int i = 0; i < 5; i++) {
            exec.execute(() -> {
                while (true) {
                    try {
                        consumer.sendMail();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            exec.execute(() -> {
                for (int j = 0; j < 15; j++) {
                    try {
                        producer.sendMail(new Mail());
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(500);
        exec.shutdown();
        System.out.println("main done.");
    }
}

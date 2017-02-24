package com.liuruichao.mail;

import java.util.concurrent.BlockingQueue;

/**
 * MailProducer
 *
 * @author liuruichao
 * @date 15/8/24 下午2:14
 */
public class MailProducer {
    private BlockingQueue<Mail> queue;

    public MailProducer(BlockingQueue<Mail> queue) {
        this.queue = queue;
    }

    public void sendMail(Mail mail) throws InterruptedException {
        System.out.println("producer send mail");
        queue.put(mail);
    }
}

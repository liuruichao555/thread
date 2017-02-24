package com.liuruichao.mail;

import java.util.concurrent.BlockingQueue;

/**
 * MailConsumer
 *
 * @author liuruichao
 * @date 15/8/24 下午2:15
 */
public class MailConsumer {
    private final BlockingQueue<Mail> queue;

    public MailConsumer(BlockingQueue<Mail> queue) {
        this.queue = queue;
    }

    public void sendMail() throws InterruptedException {
        Mail mail = queue.take();
        try {
            // 发送email
            if (mail.getErrorNum() > 5) {
                // 发送错误5次则不在发送
                return;
            }
            System.out.println(mail);
        } catch (Exception e) {
            // 失败操作
            mail.plusErroNum();
            queue.put(mail);
        }
    }
}

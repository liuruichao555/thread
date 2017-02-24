package com.liuruichao.mail;

import javax.mail.internet.InternetAddress;
import java.util.Arrays;

/**
 * Mail
 *
 * @author liuruichao
 * @date 15/7/28 上午9:50
 */
public class Mail {
    private String subject;
    private String content;
    private InternetAddress[] toMails; // 接收人
    private int errorNum = 0; // 发送错误次数

    public Mail() {
    }

    public Mail(String subject, String content, InternetAddress[] toMails, int errorNum) {
        this.subject = subject;
        this.content = content;
        this.toMails = toMails;
        this.errorNum = errorNum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public InternetAddress[] getToMails() {
        return toMails;
    }

    public void setToMails(InternetAddress[] toMails) {
        this.toMails = toMails;
    }

    public int getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(int errorNum) {
        this.errorNum = errorNum;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", toMails=" + Arrays.toString(toMails) +
                ", errorNum=" + errorNum +
                '}';
    }

    /**
     * 增加发送错误次数
     */
    public void plusErroNum() {
        errorNum++;
    }
}

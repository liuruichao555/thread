package demo9;

import javax.swing.*;

/**
 * DCLTest
 *
 * @author liuruichao
 * @date 15/9/4 下午2:55
 */
public class Test1 extends JFrame {
    JButton button1;

    public static void main(String[] args) {
        new Test1();
    }

    public Test1() {
        button1 = new JButton();
        button1.setText("button1");
        button1.addActionListener((e) -> {
            System.out.println(Thread.currentThread().getName());
            new Thread(() -> {
                try {
                    System.out.println("点击事件");
                    Thread.sleep(1000);
                    button1.setText("123456");
                    repaint();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }).start();
        });
        add(button1);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

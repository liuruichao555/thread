package com.liuruichao.threadlocal;

import scala.runtime.StringFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * ConnectionTest
 *
 * @author liuruichao
 *         Created on 2016-03-22 16:18
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/liuruichao", "root", "root");
        new MyThread(conn).start();
        new MyThread(conn).start();
        new MyThread(conn).start();
    }

    private static class MyThread extends Thread {
        private Connection conn;

        public MyThread(Connection conn) {
            this.conn = conn;
        }

        @Override
        public void run() {
            try {
                PreparedStatement addPstate = conn.prepareStatement("insert into test1 values(null, ?, ?)");
                PreparedStatement updatePstate = conn.prepareStatement("update test1 set money=1");
                PreparedStatement delPstate = conn.prepareStatement("delete from test1");
                Random random = new Random(System.nanoTime());
                int num = random.nextInt(10);
                for (int i = 0; i < 10000; i++) {
                    System.out.println(String.format("thread: %s, curIndex: %s.", Thread.currentThread().getName(), i));
                    if (num < 3) {
                        delPstate.execute();
                    } else if (num > 3 && num < 8) {
                            updatePstate.execute();
                    } else {
                        addPstate.setString(1, "liuruichao" + i);
                        addPstate.setDouble(2, random.nextInt(5000));
                        addPstate.execute();
                    }
                }
                System.out.println("job done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

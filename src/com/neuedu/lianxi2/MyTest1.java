package com.neuedu.lianxi2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 超先生 on 2020/2/18.
 */
public class MyTest1 {
    public static void main(String[] args) {
        String url="jdbc:mysql://192.168.32.151:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username="root";
        String password="123456";
        Connection con = null;
        PreparedStatement pstmt =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            pstmt = con.prepareStatement("insert into Dog(name,age,gender) values('藏獒',5,0)");
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstmt!=null)
                    pstmt.close();
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

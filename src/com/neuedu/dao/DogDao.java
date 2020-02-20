package com.neuedu.dao;

import com.neuedu.pojo.Dog;
import com.neuedu.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class DogDao implements IdogDao {
    String url = "jdbc:mysql://192.168.32.151:3306/db1?useUnicode=true&characterEncoding=utf8";
    String username = "root";
    String password = "123456";

    @Override
    public List<Dog> query() {
        List<Dog> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement("select id,name,age,gender from Dog");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Dog dog = new Dog();
                dog.setId(rs.getInt("id"));
                dog.setName(rs.getString("name"));
                dog.setAge(rs.getInt("age"));
                dog.setGender(rs.getInt("gender"));
                list.add(dog);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int add(Dog dog) {
        /*int i = 0;*/
        Object[] params ={dog.getName(),dog.getAge(),dog.getGender()};
        int i = JdbcUtil.executeUpdate("insert into Dog(name,age,gender) values(?,?,?)",params);
       /* Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement("insert into og(name,Dage,gender) values(?,?,?)");
            pstmt.setString(1, dog.getName());
            pstmt.setInt(2, dog.getAge());
            pstmt.setInt(3, dog.getGender());
            i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return i;
    }

    @Override
    public int update(Dog dog) {
        /*int i = 0;*/
        Object[]params = {dog.getName(),dog.getAge(),dog.getGender(),dog.getId()};
        int i = JdbcUtil.executeUpdate("update Dog set name=?,age=?,gender=? where id=?",params);
       /* Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement("update Dog set name=?,age=?,gender=? where id=?");
            pstmt.setString(1, dog.getName());
            pstmt.setInt(2, dog.getAge());
            pstmt.setInt(3, dog.getGender());
            i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return i;
    }

    @Override
    public int del(int id) {
        /*int i = 0;*/
        Object[] params = {id};
        int i =JdbcUtil.executeUpdate("delete from Dog where id=?",params);
       /* Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement("delete from Dog where id=?");
            pstmt.setInt(1,id);
            i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
            return i;
        }

        @Override
        public Dog queryOne ( int id){
            return null;
        }
    }

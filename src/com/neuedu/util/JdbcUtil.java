package com.neuedu.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class JdbcUtil {
    private static final String URL="jdbc:mysql://192.168.32.151:3306/db1?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    static{
        try {
            Class.forName( "com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static int executeUpdate(String sql,Object[] params){
        int result = 0;
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            if(params != null){
                for(int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(con,pstmt);
        }
        return result;
    }
    public static<T> List<T> executeQuery(String sql,Class<T>clz,Object...params){
        List<T> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        try {
            pstmt = con.prepareStatement(sql);
            if(params != null){
                for(int i = 0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                T t = clz.newInstance();
                Field[] fields = clz.getDeclaredFields();
               /* rs.getInt("deptno");
                rs.getString("dename");
                rs.getString("loc");*/
                for(Field f : fields){
                   Object value = rs.getObject(f.getName());
                   f.setAccessible(true);
                   f.set(t,value);
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally{
            close(con,pstmt,rs);
        }
        return list;
    }
    static void close(Connection con,PreparedStatement pstmt){
        try {
            if(pstmt !=null)
                pstmt.close();
            if(con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs !=null)
                rs.close();
            close(con,pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

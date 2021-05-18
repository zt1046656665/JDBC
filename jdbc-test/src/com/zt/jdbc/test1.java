package com.zt.jdbc;
import java.sql.*;
import java.util.Map;

public class test1 {
    public static void main(String[] args){
        Connection conn =null;
        Statement stmt =null;

        try{
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

            String url ="jdbc:mysql://127.0.0.1:3306/bj";
            String user ="root";
            String password ="123456";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库链接对象是"+ conn);

            stmt=conn.createStatement();

            int count=stmt.executeUpdate("insert into dept(deptno,dname,loc) value(60,'人事部6','武汉')");
            System.out.println(count==1 ? "删除成功" : "删除失败");


        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(conn!= null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
}

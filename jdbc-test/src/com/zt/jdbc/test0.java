package com.zt.jdbc;
import java.sql.*;


public class test0 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1、注册驱动
            Driver driver = new com.mysql.jdbc.Driver();	//多态，父类型引用指向子类型对象
            DriverManager.registerDriver(driver);

            // 2、获取连接
			/*
				url包括哪几部分:
					协议
					IP
					Port
					资源名

				eg：http://180.101.49.11:80/index.html
					http:// 通信协议
					180.101.49.11 IP地址
					80 端口号
					index.html 资源名
			*/
            // static Connection getConnection(String url, String user, String password)
            String url = "jdbc:mysql://127.0.0.1:3306/bj";
            String user = "root";
            String password = "146";
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象" + conn);	//数据库连接对象com.mysql.jdbc.JDBC4Connection@1ae369b7

            // 3、获取数据库操作对象
            // Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
            stmt = conn.createStatement();

            // 4、执行sql语句
            // int executeUpdate(String sql)
            // 专门执行DML语句
            // 返回值是“影响数据库中的记录条数”
            int count = stmt.executeUpdate("update dept set dname = '销售部',loc = '合肥' where deptno = 20;");
            System.out.println(count == 1 ? "保存成功":"保存失败");

            // 5、处理查询结果集

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            // 从小到大依次关闭
            if(stmt != null) {
                try	{
                    stmt.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try	{
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package day03_JDBC_demo.itcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:36 2019/6/18
 * @Version: $
 * executeUpdate（） 可以执行DDL 、DML语句
 */
public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?serverTimezone=UTC", "root", "root");
            statement = conn.createStatement();
            String sql="create table student(id int,name varchar(20))";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

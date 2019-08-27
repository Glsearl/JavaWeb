package day03_JDBC_demo.itcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:06 2019/6/17
 * @Version: $
 * JDBC快速入门
 */
public class JDBC_Demo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=UTC", "root", "root");
        String sql="update emp set salary=500 where id =1001";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        connection.close();
    }
}

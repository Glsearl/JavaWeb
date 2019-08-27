package day03_JDBC_demo.itcast;

import day03_JDBC_demo.Utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:09 2019/6/19
 * @Version: $
 * LoginDemo改进版，使用PreparedStatement 防止SQL注入
 * PreparedStatement：执行sql的对象
 */
public class LoginDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        boolean flag = new LoginDemo().login(username, password);
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
    /**
     * 登录方法,使用PreparedStatement实现
     */
    public boolean login(String username, String password) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        if (username == null || password == null) {
            return false;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            String sql = "select * from where username= ? and password=?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            resultSet = pre.executeQuery();
//            if (resultSet.next()) {
//                return true;
//            } else {
//                return false;
//            }
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, con, pre);
        }
        return false;
    }

}

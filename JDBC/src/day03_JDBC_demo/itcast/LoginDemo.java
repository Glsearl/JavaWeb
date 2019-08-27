package day03_JDBC_demo.itcast;

import day03_JDBC_demo.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:51 2019/6/19
 * @Version: $
 * * 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 * 				* select * from user where username = "" and password = "";
 * 				* 如果这个sql有查询结果，则成功，反之，则失败
 */
public class LoginDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username= sc.next();
        System.out.println("请输入密码：");
        String password=sc.next();
      boolean flag=  new LoginDemo().login(username,password);
    if (flag){
        System.out.println("登录成功");
    }else {
        System.out.println("登录失败");
    }
    }
    public boolean login(String username,String password){
        Connection con=null;
        Statement stat=null;
        ResultSet resultSet=null;
        if (username==null || password==null){
            return false;
        }
        try {
            con= JDBCUtils.getConnection();
            stat = con.createStatement();
            String sql = "select * from user where username = '"+username+"' and password = '"+password+"' ";
            resultSet = stat.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,con,stat);
        }
      return  false;
    }
}

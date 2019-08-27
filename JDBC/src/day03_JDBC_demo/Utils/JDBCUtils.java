package day03_JDBC_demo.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:26 2019/6/19
 * @Version: $
 */
public class JDBCUtils {
   private static String url;
   private static String user;
   private static String password;
   private static String driver;
    static {
        Properties pro=new Properties();

        try {
            pro.load(new FileReader("./src/jdbc.properties"));
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void close(Connection con, Statement stat){
    if (con!=null){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (stat!=null){
        try {
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    public static void close(ResultSet rs,Connection con, Statement stat){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

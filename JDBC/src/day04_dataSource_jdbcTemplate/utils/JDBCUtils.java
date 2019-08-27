package day04_dataSource_jdbcTemplate.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:44 2019/7/1
 * @Version: $
 * 1. 定义一个类 JDBCUtils
 * 			2. 提供静态代码块加载配置文件，初始化连接池对象
 * 			3. 提供方法
 * 				1. 获取连接方法：通过数据库连接池获取连接
 * 				2. 释放资源
 * 				3. 获取连接池的方法
 */
public class JDBCUtils {
   private static DataSource ds=null;
    static {
        try {
            Properties pro=new Properties();
            pro.load(new FileReader(System.getProperty("user.dir")+"/src/druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Connection conn, Statement stat){
        if (conn!=null){
            try {
                conn.close();
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
    public static void close(Connection conn, Statement stat, ResultSet rs){
        if (conn!=null){
            try {
                conn.close();
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
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public  static DataSource getDataSource(){
        return ds;
    }
}

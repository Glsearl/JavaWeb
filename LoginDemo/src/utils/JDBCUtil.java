package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:55 2019/8/22
 * @Version: $
 */
public class JDBCUtil {
    private  static DataSource ds;
    static {
        try {
            Properties pro=new Properties();
            InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection  getConnection() throws SQLException {
      return ds.getConnection();
    }
    public static DataSource getDataSource(){
        return ds;
    }
}

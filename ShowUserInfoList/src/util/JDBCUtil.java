package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:22 2019/9/17
 * @Version: $
 */
public class JDBCUtil {
    private static DataSource  ds;
    static {
        try {
            Properties pro=new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  public static Connection getConnection() throws SQLException {
     return ds.getConnection();
  }
  public static  DataSource getDataSource(){
      return ds;
  }
}

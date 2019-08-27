package day04_dataSource_jdbcTemplate.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:39 2019/7/1
 * @Version: $
 */
public class DruidDemo {
    public static void main(String[] args) {
        Properties pro=new Properties();
        try {
//            pro.load(new FileReader(System.getProperty("user.dir")+"/src/druid.properties"));
          InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            DataSource ds= DruidDataSourceFactory.createDataSource(pro);
            Connection connection = ds.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

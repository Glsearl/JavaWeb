package day04_dataSource_jdbcTemplate.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:34 2019/7/1
 * @Version: $
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i <=10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
            if (i==5){
                conn.close();
            }
        }

    }

}

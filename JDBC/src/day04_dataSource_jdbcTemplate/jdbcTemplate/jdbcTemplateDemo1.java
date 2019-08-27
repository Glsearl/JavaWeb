package day04_dataSource_jdbcTemplate.jdbcTemplate;

import day04_dataSource_jdbcTemplate.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:06 2019/7/2
 * @Version: $
 */
public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        DataSource ds = JDBCUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "UPDATE account set balance = ? where id = ?";
        int count = template.update(sql, 500,3);
        System.out.println(count);

    }
}

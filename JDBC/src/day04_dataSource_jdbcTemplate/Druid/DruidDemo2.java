package day04_dataSource_jdbcTemplate.Druid;

import day04_dataSource_jdbcTemplate.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:59 2019/7/1
 * @Version: $
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        try {
            Connection con = JDBCUtils.getConnection();
            String sql="insert into account values (null ,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,"张三");
            statement.setDouble(2,3000);
            int i = statement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

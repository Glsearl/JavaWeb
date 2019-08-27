package day03_JDBC_demo.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:52 2019/6/19
 * @Version: $
 */
public class JDBCDemo {

    public static void main(String[] args) {
        Connection con=null;
        Statement stat=null;
        try {
        con= JDBCUtils.getConnection();
           stat = con.createStatement();
            String sql="update emp set salary=500 where id =1001";
            int i = stat.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,stat);
        }
    }

}

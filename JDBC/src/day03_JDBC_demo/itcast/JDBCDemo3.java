package day03_JDBC_demo.itcast;

import day03_JDBC_demo.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:06 2019/6/24
 * @Version: $
 * JDBC事务管理
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstat1 = null;
        PreparedStatement pstat2 = null;
        try {
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            String sql1 = "UPDATE account set balance=balance - ? where id=?";
            String sql2 = "UPDATE account set balance=balance + ? where id=?";
            pstat1 = con.prepareStatement(sql1);
            pstat1.setInt(1, 500);
            pstat1.setInt(2, 1);
            pstat2 = con.prepareStatement(sql2);
            pstat2.setInt(1, 500);
            pstat2.setInt(2, 2);
            pstat1.executeUpdate();
//            int i = 3 / 0;
            pstat2.executeUpdate();
            con.commit();
        } catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstat1);
            JDBCUtils.close(null, pstat2);
        }
    }
}

package dao.impl;

import dao.ManagerDao;
import domain.Manager;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:14 2019/9/17
 * @Version: $
 */
public class ManagerDaoImpl implements ManagerDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public Manager login(String username,String password) {
        try {
            String sql="select * from manager where username = ? and password = ?";
            Manager manager = template.queryForObject(sql, new BeanPropertyRowMapper <Manager>(Manager.class),username,password);
            return manager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

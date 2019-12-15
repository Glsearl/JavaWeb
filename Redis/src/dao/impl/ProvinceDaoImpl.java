package dao.impl;

import dao.ProvinceDao;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:49 2019/11/16
 * @Version: $
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private static JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有地址
     * @return
     */
    @Override
    public List<Province> findAll() {
        String sql=" select * from province ";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}

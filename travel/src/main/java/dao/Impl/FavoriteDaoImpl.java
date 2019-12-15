package dao.Impl;

import dao. FavoriteDao;
import domain.Favorite;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Date;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:25 2019/12/15
 * @Version: $
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findRidAndUid(int rid, int uid) {
        Favorite favorite =null;
        try {
            String sql="select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql="select count(*) from tab_favorite where rid = ? ";
        return template.queryForObject(sql,Integer.class,rid);
    }

    @Override
    public void add(int rid, int uid) {
        String sql="insert  into tab_favorite values (?,?,?)";
        template.update(sql,rid,new Date(),uid);
    }
}

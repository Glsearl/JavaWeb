package dao.Impl;

import dao.RouteDao;
import domain.Route;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:57 2019/12/13
 * @Version: $
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid, String rname) {
        String sql="select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        if (cid!=0){
            sb.append(" and cid = ? ");
           params.add(cid);
        }
        if (rname!=null && rname.length()>0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
         sql = sb.toString();
        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        String sql="select * from tab_route where 1 = 1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        if (cid!=0){
            sb.append(" and cid = ? ");
            params.add(cid);
        }
        if (rname!=null && rname.length()>0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ?,?");
        sql=sb.toString();
        params.add(start);
        params.add(pageSize);
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    @Override
    public Route findById(int rid) {
        String sql="select * from tab_route where rid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}

package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.text.resources.cldr.kw.FormatData_kw;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:32 2019/9/17
 * @Version: $
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
     String sql="select * from user;";
        List <User> users = template.query(sql, new BeanPropertyRowMapper <User>(User.class));
        return users;
    }

    @Override
    public void add(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?)";
       template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(int id) {
        String sql="select *from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper <User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql="update user set name = ?,gender = ?,age = ? , address = ? , qq = ? , email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map <String, String[]> map) {
        String sql="select count(*) from user where 1 = 1";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        Set <String> keySet = map.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = map.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
               params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        return template.queryForObject(sb.toString(), Integer.class,params.toArray());
    }

    @Override
    public List <User> findUserByPage(int start, int rows, Map <String, String[]> map) {
        String sql="select * from user  where 1 = 1";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        Set <String> keySet = map.keySet();
        for (String key : keySet) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = map.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
//        添加分页功能
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());
        List <User> users = template.query(sb.toString(), new BeanPropertyRowMapper <User>(User.class), params.toArray());
        return users;
    }
}

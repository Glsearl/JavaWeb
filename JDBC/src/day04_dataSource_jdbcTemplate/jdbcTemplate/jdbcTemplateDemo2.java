package day04_dataSource_jdbcTemplate.jdbcTemplate;

import day04_dataSource_jdbcTemplate.domain.Emp;
import day04_dataSource_jdbcTemplate.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:48 2019/7/2
 * @Version: $
 * 1. 修改1号数据的 salary 为 10000
 * 2. 添加一条记录
 * 3. 删除刚才添加的记录
 * 4. 查询id为1的记录，将其封装为Map集合
 * 5. 查询所有记录，将其封装为List
 * 6. 查询所有记录，将其封装为Emp对象的List集合
 * 7. 查询总记录数
 */
public class jdbcTemplateDemo2 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public void test1() {
        String sql = "insert into emp (id,ename,dept_id) values (?,?,?)";
        int count = template.update(sql, 1015, "麻瓜", 10);
        System.out.println(count);
    }


    public void test2() {
        String sql = "delete from emp where id=?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    public void test3() {
        String sql = "select * from emp where id=?";
        Map <String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }
    public void test4() {
        String sql = "select * from emp";
        List <Map <String, Object>> list = template.queryForList(sql);
        for (Map <String, Object> map : list) {
            System.out.println(map);
        }
    }

        public void test5 () {
            String sql = "select * from emp";
            List <Emp> query = template.query(sql, new BeanPropertyRowMapper <Emp>(Emp.class));
            for (Emp emp : query) {
                System.out.println(emp);
            }
        }
      public void test6(){
        String sql="select count(id)from emp";
            Long aLong = template.queryForObject(sql, Long.class);
            System.out.println(aLong);
        }
}

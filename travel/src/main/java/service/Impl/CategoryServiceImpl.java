package service.Impl;

import dao.CategoryDao;
import dao.Impl.CategoryDaoImpl;
import domain.Category;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import service.CategoryService;
import utils.JedisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:30 2019/12/12
 * @Version: $
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao=new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        Jedis jedis= JedisUtil.getJedis();
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs=null;
        if (categorys==null ||categorys.size()==0){
            System.out.println("从数据库中查询。。。");
           cs= dao.findAll();
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
            }
            //4.如果不为空,将set的数据存入list
        }else {
            System.out.println("从redis中查询。。。");
            cs=new ArrayList<>();
            for (Tuple tuple : categorys) {
                Category category =new Category();
                category.setCid((int) tuple.getScore())  ;
                category.setCname(tuple.getElement());
                cs.add(category);
            }
        }
       return cs;
    }
}

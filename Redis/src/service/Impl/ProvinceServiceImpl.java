package service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:56 2019/11/16
 * @Version: 1$
 */
public class ProvinceServiceImpl implements ProvinceService {
    private static ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if (province_json==null||province_json.length()==0){
            System.out.println("redis中没有数据，查询数据库...");
            List<Province> list = dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存...");
        }
        return province_json;
    }
}

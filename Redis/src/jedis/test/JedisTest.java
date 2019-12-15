package jedis.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:39 2019/11/12
 * @Version: $
 */
public class JedisTest {
    /**
     * jedis操作String类型
     */
    @Test
    public void test1(){
        Jedis jedis=new Jedis("localhost",6379);
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.del("username");
        jedis.close();
    }

    /**
     * jedis操作hash类型
     */
    @Test
    public void test2(){
        Jedis jedis=new Jedis("localhost",6379);
       jedis.hset("myhash","username","lisi");
       jedis.hset("myhash","password","1234");
        String username = jedis.hget("myhash", "username");
        System.out.println(username);
        Map<String, String> myhash = jedis.hgetAll("myhash");
        Set<Map.Entry<String, String>> entries = myhash.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        jedis.hdel("myhash","username");
        jedis.close();
    }

    /**
     * jedsis 操作list类型
     */
    @Test
    public void test3(){
        Jedis jedis=new Jedis("localhost",6379);
        jedis.lpush("list","a");
        jedis.lpush("list","b");
        jedis.lpush("list","c");
        jedis.rpush("list","c");
        jedis.rpush("list","b");
        jedis.rpush("list","a");
        List<String> list = jedis.lrange("list", 1, -1);
        System.out.println(list);
        String element = jedis.rpop("list");
        System.out.println(element);
        String element2 = jedis.lpop("list");
        System.out.println(element2);
        List<String> list2 = jedis.lrange("list", 0, -1);
        System.out.println(list2);
        jedis.close();
    }
    /**
     * jedis 操作set类型
     */
    @Test
    public void test4(){
        Jedis jedis=new Jedis("localhost",6379);
         jedis.sadd("myset","q");
         jedis.sadd("myset","1");
         jedis.sadd("myset","w");
         jedis.sadd("myset","2");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }
    /**
     * jedis 操作 sortedset
     */
    @Test
    public void test5() {
        Jedis jedis=new Jedis("localhost",6379);
        jedis.zadd("top",1000,"孙悟空");
        jedis.zadd("top",50,"亚瑟");
        jedis.zadd("top",100,"亚索");
        Set<String> top = jedis.zrange("top", 0, -1);
        System.out.println(top);
        jedis.close();
    }

    /**
     * jedis连接池
     * 1. 创建JedisPool连接池对象
     * 	2. 调用方法 getResource()方法获取Jedis连接
     */
    @Test
    public void test6(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        JedisPool jedisPool=new JedisPool(config,"localhost",6379);
        Jedis jedis = jedisPool.getResource();//获取连接
        jedis.set("hehe","haha");
        jedis.close();//关闭连接,归还到连接池中
    }
}

package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 14:07 2019/11/1
 * @Version: $
 */
public class JacksonTest {
    public void test1() throws Exception {
       /* 转换方法：
        writeValue(参数1，obj):
        参数1：
        File：将obj对象转换为JSON字符串，并保存到指定的文件中
        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
        writeValueAsString(obj):将对象转为json字符串*/

        Person p=new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
       // String json = mapper.writeValueAsString(p);
        //将数据写入到File文件中
      //  mapper.writeValue(new File("D://a.txt"),p);
//        System.out.println(json);
        //将数据关联到Writer中
        mapper.writeValue(new FileWriter("D://b.text"),p);
    }

    public void test2() throws Exception {
        Person p=new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

    }

    /**
     * 将List转成Json
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Person p = new Person();
        p.setName("张三");
        p.setAge(24);
        p.setGender("男");
        p.setBirthday(new Date());
        Person p1 = new Person();
        p1.setName("李四");
        p1.setAge(20);
        p1.setGender("女");
        p1.setBirthday(new Date());
        Person p2 = new Person();
        p2.setName("王五");
        p2.setAge(28);
        p2.setGender("男");
        p2.setBirthday(new Date());
        List<Person> list=new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
    }
    @Test
    public void test4() throws JsonProcessingException {
        Map<String,Object> map=new HashMap<>();
        map.put("name","张三");
        map.put("age",21);
        map.put("gender","女");
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    /**
     * Json 转对象
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        String json = "{\"gender\":\"女\",\"name\":\"张三\",\"age\":21}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}

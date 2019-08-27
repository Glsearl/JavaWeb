package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:29 2019/8/12
 * @Version: $
 * 1. selector:选择器
 * 				* 使用的方法：Elements	select​(String cssQuery)
 * 					* 语法：参考Selector类中定义的语法
 * 选择器查询
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析XML文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.查询name标签
        Elements name = document.select("name");
        System.out.println(name);
        System.out.println("-------------------");
        //4.查询id值为itcast的元素
        Elements itcast = document.select("[id='itcast']");
        System.out.println(itcast);
        System.out.println("-------------------");
        //5.获取student标签并且number属性值为heima_0001的age子标签
        Elements age = document.select("[number='heima_0001']>age");
        System.out.println(age);
        System.out.println("-------------------");

    }
}

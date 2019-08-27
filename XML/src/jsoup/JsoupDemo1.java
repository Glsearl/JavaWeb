package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:43 2019/8/12
 * @Version: $
 * Jsoup 快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析XML文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        Element element = elements.get(0);
        //获取数据
        String name = element.text();
        System.out.println(name);
    }
}

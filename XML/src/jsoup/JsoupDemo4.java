package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:16 2019/8/12
 * Version: 1$
 * 	4. Element：元素对象
 * 				1. 获取子元素对象
 * 					* getElementById​(String id)：根据id属性值获取唯一的element对象
 * 					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
 * 					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
 * 					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
 *	2. 获取属性值
 * 					* String attr(String key)：根据属性名称获取属性值
 * 				3. 获取文本内容
 * 					* String text():获取文本内容
 * 					* String html():获取标签体的所有内容(包括字标签的字符串内容)
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析XML文档
        Document document = Jsoup.parse(new File(path), "utf-8");
//        Element element = document.getElementById("itcast");
        /*
        //获取itcast的子元素xing的元素对象集合
        Elements xing = element.getElementsByTag("xing");
        String text = xing.text();
        String html = xing.html();
        System.out.println(text);//张
        System.out.println(html);//张
        */
        Elements elements = document.getElementsByTag("student");
        Element element = elements.get(0);
//        根据属性名称获取属性值
        String id = element.attr("number");
        System.out.println(id);

    }
}

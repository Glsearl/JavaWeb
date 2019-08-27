package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:04 2019/8/12
 * @Version: $
 * 2. Document：文档对象。代表内存中的dom树
 * 				* 获取Element对象
 * 					* getElementById​(String id)：根据id属性值获取唯一的element对象
 * 					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
 * 					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
 * 					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析XML文档
        Document document = Jsoup.parse(new File(path), "utf-8");

        Element element = document.getElementById("itcast");
        String text = element.text();
        System.out.println(text);
        System.out.println("-----------------------");
        Elements names = document.getElementsByTag("name");
        Element element1 = names.get(1);
        String name2 = element1.text();
        System.out.println(name2);
        System.out.println("-----------------------");
        Elements numbers = document.getElementsByAttribute("number");
        Element element2 = numbers.get(0);
        String text1 = element2.text();
        System.out.println(text1);
        System.out.println("-----------------------");
        Elements attributeValue = document.getElementsByAttributeValue("number", "heima_0002");
        Element element3 = attributeValue.get(0);
        String text2 = element3.text();
        System.out.println(text2);

    }
}

package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:57 2019/8/12
 * @Version: $
 * 1. Jsoup：工具类，可以解析html或xml文档，返回Document
 * 	* parse：解析html或xml文档，返回Document
 * 					* parse​(File in, String charsetName)：解析xml或html文件的。
 * 					* parse​(String html)：解析xml或html字符串
 * 					* parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
//        //解析XML文档
/*        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
         System.out.println("-------------------------");
        */
//        * parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        /*URL url=new URL("https://www.zhengtou.com");
        Document document = Jsoup.parse(url,3000);
        System.out.println(document);
        System.out.println("-------------------------");*/
        //* parse​(String html)：解析xml或html字符串
        Document document = Jsoup.parse("<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>");
        System.out.println(document);

    }
}

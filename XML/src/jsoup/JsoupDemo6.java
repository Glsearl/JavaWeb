package jsoup;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @ Author     ：gaols
 * @ Date       ：Created in 17:01 2019/8/12
 * @Version: $
 * Jsoup XPath查询
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //获取XML的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //解析XML文档
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument=new JXDocument(document);
        List <JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("-------------------------");
        //4.2查询所有student标签下的name标签
        List <JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode1 : jxNodes1) {
            System.out.println(jxNode1);
        }
        System.out.println("-------------------------");
        //4.3查询student标签下带有id属性的name标签
        List <JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode2 : jxNodes2) {
            System.out.println(jxNode2);
        }
        System.out.println("-------------------------");
        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
        List <JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='itcast']");
        for (JXNode jxNode3 : jxNodes3) {
            System.out.println(jxNode3);
        }
    }
}

package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:43 2019/8/27
 * @Version: $version$
 * response获取字符流
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：utf-8
//       response.setCharacterEncoding("utf-8");
//        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//       response.setHeader("Content-type","text/html;charset=utf-8");
//        简单方式设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
//        pw.write("你好啊啊啊，response.getWriter");
        pw.write("<h1>hello 啊</h1>");
    }
}

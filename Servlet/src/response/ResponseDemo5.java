package response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:42 2019/8/27
 * @Version: $version$
 * response获取字节流
 */
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好啊".getBytes());
    }
}

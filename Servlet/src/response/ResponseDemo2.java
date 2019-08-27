package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:50 2019/8/23
 * @Version: $version$
 */
@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo2........");
        //获取数据共享中的数据
        Object msg = request.getAttribute("msg");
       System.out.println(msg); // 数据是空的，应为重定向是两个请求，不能共享数据，消息转发可以获取到数据
    }
}

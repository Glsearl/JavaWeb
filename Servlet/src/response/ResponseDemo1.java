package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:22 2019/8/23
 * @Version: $version$
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("response.ResponseDemo1........");
        //重定向
   //    response.setStatus(302);
   //    response.setHeader("location","/responseDemo2");

        request.setAttribute("msg","response");
        //获取虚拟目录
        String contextPath = request.getContextPath();
      //简单重定向
        response.sendRedirect(contextPath+"/responseDemo2");
    }
}

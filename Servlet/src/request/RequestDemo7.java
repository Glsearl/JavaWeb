package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:20 2019/8/22
 * @Version: $version$
 * 	解决post获取参数中文乱码问题
 * 	request.setCharacterEncoding（）
 */
@WebServlet( "/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        System.out.println("--------------------");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}

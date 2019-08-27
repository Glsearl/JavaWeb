package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:10 2019/8/22
 * @Version: $version$
 */
@WebServlet("/requestDemo9")
public class RequestDemo9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取共享的数据
        Object name = request.getAttribute("name");
        System.out.println(name);
        //删除共享的数据
        request.removeAttribute("name");
        System.out.println(name);
        System.out.println("requestDemo9被访问了。。。。。。");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}

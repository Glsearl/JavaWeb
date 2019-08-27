package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:49 2019/8/20
 * @Version: $version$
 */
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("User-Agent");
        if (agent.contains("Firefox")){
            System.out.println("通过Firefox访问了服务。。。。");
        }else if (agent.contains("Chrome")){
            System.out.println("通过Chrome访问了服务。。。。");
        }
    }
}

package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:55 2019/8/20
 * @Version: $version$
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl!=null){
        if (requestUrl.contains("youku")){
            response.setContentType("text/html;charset=utf-8");
           response.getWriter().write("播放电影。。。");
        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("不能播放电影。。。");
        }
     }
    }
}

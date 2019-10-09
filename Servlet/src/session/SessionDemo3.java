package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:55 2019/9/4
 * @Version: $version$
 * 将Session存储到Cookie中，来实现持久化
 */
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie cookie=new Cookie("JSESESSIONID",session.getId());
        cookie.setMaxAge(60*3);
        response.addCookie(cookie);
    }
}

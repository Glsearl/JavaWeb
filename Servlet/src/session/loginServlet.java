package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:09 2019/9/5
 * @Version: $version$
 * 1. 访问带有验证码的登录页面login.jsp
 * 		2. 用户输入用户名，密码以及验证码。
 * 			* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
 * 			* 如果验证码输入有误，跳转登录页面，提示：验证码错误
 * 			* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (checkCode_session!=null&& checkCode_session.equalsIgnoreCase(checkcode)){
             if ("zhangsan".equals(username)&&"123".equals(password)){
                 session.setAttribute("user",username);
               response.sendRedirect(request.getContextPath()+"/success.jsp");
             }else {
                 request.setAttribute("login_error","用户名或密码错误");
                 request.getRequestDispatcher("/login.jsp").forward(request,response);
             }
        }else {
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

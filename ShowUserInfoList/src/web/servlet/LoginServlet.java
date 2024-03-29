package web.servlet;

import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import domain.Manager;
import org.apache.commons.beanutils.BeanUtils;
import service.ManagerService;
import service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:46 2019/9/17
 * @Version: $version$
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (!checkCode_session.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }
        Map <String, String[]> map = request.getParameterMap();
        Manager manager = new Manager();
        try {
            BeanUtils.populate(manager, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ManagerService service = new ManagerServiceImpl();
        System.out.println(manager);
        Manager loginManager = service.login(manager);
        System.out.println(loginManager);
            if (loginManager!= null) {
                session.setAttribute("manager",loginManager);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                request.setAttribute("login_msg", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

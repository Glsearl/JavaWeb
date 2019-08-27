package servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:18 2019/8/22
 * @Version: $version$
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User loginUser=new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        //使用BeanUtils封装对象
        Map <String, String[]> map = req.getParameterMap();
        User user =new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao dao=new UserDao();
        User user1 = dao.login(user);
        if (user1==null){
           req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            req.setAttribute("user",user1);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }
}

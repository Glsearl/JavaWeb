package servlet;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:37 2019/8/14
 * @Version: $
 */
@WebServlet("/demo")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("服务器初始化。。。。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务被访问了。。。。。");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("服务器要关闭了。。。。");
    }
}

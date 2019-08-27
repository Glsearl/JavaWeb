package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:09 2019/8/20
 * @Version: $
 * 	1. 获取请求方式 ：GET
 * 						* String getMethod()
 * 					2. (*)获取虚拟目录：/day14
 * 						* String getContextPath()
 * 					3. 获取Servlet路径: /demo1
 * 						* String getServletPath()
 * 					4. 获取get方式请求参数：name=zhangsan
 * 						* String getQueryString()
 * 					5. (*)获取请求URI：/day14/demo1
 * 						* String getRequestURI():		/day14/demo1
 * 						* StringBuffer getRequestURL()  :http://localhost/day14/demo1
 *
 * 						* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
 * 						* URI：统一资源标识符 : /day14/demo1					共和国
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法
        String method = req.getMethod();
        System.out.println(method);
        //获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //获取get请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //获取uri
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
//        获取URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:51 2019/8/28
 * @Version: $version$
 *  2. 域对象：共享数据
 *   3. 获取文件的真实(服务器)路径
 */
@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servletContext域对象共享的数据是全局的，在任何servlet中都可以获取到
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("msg","gggggggggg");
    }
}

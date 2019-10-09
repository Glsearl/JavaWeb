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
 * @ Date       ：Created in 15:11 2019/8/28
 * @Version: $version$
 * 3. 获取文件的真实(服务器)路径
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
//        String realPath = servletContext.getRealPath("/b.txt");//web路径下
//        String realPath = servletContext.getRealPath("/WEB-INF/c.txt"); //WEB-INF目录下
        String realPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");//src目录下文件
        System.out.println(realPath);
    }
}

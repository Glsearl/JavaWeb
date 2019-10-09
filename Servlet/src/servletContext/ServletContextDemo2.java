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
 * @ Date       ：Created in 14:46 2019/8/28
 * @Version: $version$
 * 1. 获取MIME类型：
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*

            ServletContext功能：
               1. 获取MIME类型：
                * MIME类型:在互联网通信过程中定义的一种文件数据类型
                    * 格式： 大类型/小类型   text/html		image/jpeg

                * 获取：String getMimeType(String file)
         */
        ServletContext servletContext = this.getServletContext();
        String filePath="a.txt";
        String mimeType = servletContext.getMimeType(filePath);
        System.out.println(mimeType);
    }
}

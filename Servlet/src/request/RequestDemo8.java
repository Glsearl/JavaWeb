package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:10 2019/8/22
 * @Version: $version$
 *请求转发  一种在服务器内部的资源跳转方式
 *
2. 特点：
    1. 浏览器地址栏路径不发生变化
    2. 只能转发到当前服务器内部资源中。
    3. 转发是一次请求
3. 共享数据：
    * 域对象：一个有作用范围的对象，可以在范围内共享数据
    * request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
    */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("requestDemo8被访问了。。。。。。");
        //设置共享数据
        request.setAttribute("name","张益达");
        //请求转发
     request.getRequestDispatcher("/requestDemo9").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}

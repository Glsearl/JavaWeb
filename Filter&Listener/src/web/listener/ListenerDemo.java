package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;


/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:27 2019/10/14
 * @Version: $
 */
@WebListener
public class ListenerDemo implements ServletContextListener {
    @Override  //服务启动时调用该方法
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //获取web.xml中context-param标签中数据
        String abc = servletContext.getInitParameter("abc");
        System.out.println(abc);
        //2.加载资源文件
        String initParameter = servletContext.getInitParameter("appliationContext.xml");
        //获取真实路径
        String realPath = servletContext.getRealPath(initParameter);
        try {
            FileInputStream fis=new FileInputStream(realPath);
            System.out.println(fis);
           }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("servletContextd对象被创建了");
    }

    @Override//服务器正常关闭时调用该方法
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContextd对象被销毁了");
    }
}

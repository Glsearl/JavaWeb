package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:31 2019/9/29
 * @Version: $version$
 */
//@WebFilter(value = "/index.jsp",dispatcherTypes =DispatcherType.REQUEST)// REQUEST：默认值。浏览器直接请求资源
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)//FORWARD：转发访问资源
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo6.。。。。。");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

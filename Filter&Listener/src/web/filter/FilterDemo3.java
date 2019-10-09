package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:29 2019/9/25
 * @Version: $version$
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    public void destroy() {
        System.out.println("destroy....");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter....");
        chain.doFilter(req, resp);
        System.out.println("执行过滤器放行代码下面的代码");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init.....");
    }

}

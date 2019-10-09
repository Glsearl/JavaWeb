package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:24 2019/9/25
 * @Version: $version$
 * 2. 过滤器执行流程
 * 			1. 执行过滤器
 * 			2. 执行放行后的资源
 * 			3. 回来执行过滤器放行代码下边的代码
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("执行过滤器");
        chain.doFilter(req, resp);
        System.out.println("执行过滤器放行后的代码");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

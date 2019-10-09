package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:38 2019/9/29
 * @Version: $version$
 */
@WebFilter("/index.jsp")
public class FilterDemo7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo7......");
        chain.doFilter(req, resp);
        System.out.println("filterDemo7回来了......");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

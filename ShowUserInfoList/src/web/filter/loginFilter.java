package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:46 2019/9/29
 * @Version: $version$
 * 1. 案例1_登录验证
 * 			* 需求：
 * 				1. 访问ShowUserInfoList案例的资源。验证其是否登录
 * 				2. 如果登录了，则直接放行。
 * 				3. 如果没有登录，则跳转到登录页面，提示"您尚未登录，请先登录"。
 */
@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")||uri.contains("/css/")||uri.contains("/fonts/")||uri.contains("/js/")){
            chain.doFilter(req, resp);//直接放行
        }else{
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);//直接放行
            }else {
                request.setAttribute("login_msg","您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}

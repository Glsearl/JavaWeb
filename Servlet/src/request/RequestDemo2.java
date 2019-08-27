package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:47 2019/8/20
 * @Version: $
 */
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String header = req.getHeader("User-Agent");
//        System.out.println(header);
        Enumeration <String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = req.getHeader(name);
            System.out.println(name+"-------"+header);
        }
    }
}

package request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 15:30 2019/8/20
 * @Version: $version$
 * 获取请求体数据
 */
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取字节流
        BufferedReader reader = request.getReader();
        String line=null;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}

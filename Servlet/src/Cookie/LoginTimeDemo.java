package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:30 2019/9/3
 * @Version: $version$
 * 案例：记住上一次访问时间
 * 		1. 需求：
 * 			1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 			2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 *
 * 		2. 分析：
 * 			1. 可以采用Cookie来完成
 * 			2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 				1. 有：不是第一次访问
 * 					1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 					2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 				2. 没有：是第一次访问
 * 					1. 响应数据：您好，欢迎您首次访问
 * 					2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/loginTimeDemo")
public class LoginTimeDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        boolean flag=false;
        if (cookies!=null||cookies.length>0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    flag=true;
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String format = sdf.format(date);
                    //url编码
                    String encode1 = URLEncoder.encode(format, "utf-8");
                    cookie.setValue(encode1);
                    cookie.setMaxAge(60*60*60);
                    response.addCookie(cookie);
                    String value = cookie.getValue();
                    //Url解码
                    String encode = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来，您上次访问时间为:"+encode);
                }

            }
            }
        if (cookies==null||cookies.length==0||flag==false){
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String last_Time = sdf.format(date);
            last_Time = URLEncoder.encode(last_Time, "utf-8");
            Cookie cookie1=new Cookie("lastTime",last_Time);
            cookie1.setMaxAge(60*60*60);
            response.addCookie(cookie1);
            response.getWriter().write("您好，欢迎您首次访问");
        }
    }
}

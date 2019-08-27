package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 9:20 2019/8/22
 * @Version: $version$
 * 		1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
 * 				2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
 * 				3. Enumeration<String> getParameterNames():获取所有请求的参数名称
 * 				4. Map<String,String[]> getParameterMap():获取所有参数的map集合
 */
@WebServlet( "/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        System.out.println("--------------------");
        //获取多选框参数值
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("--------------------");
        Enumeration <String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+"----"+value);
        }
        System.out.println("--------------------");
        Map <String, String[]> parameterMap = request.getParameterMap();
        Set <String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(key+"----"+value);
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }
}

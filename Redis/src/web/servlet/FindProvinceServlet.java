package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.Impl.ProvinceServiceImpl;
import service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:58 2019/11/16
 * @Version: $version$
 */
@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* ProvinceService service=new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/
       ProvinceService service=new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

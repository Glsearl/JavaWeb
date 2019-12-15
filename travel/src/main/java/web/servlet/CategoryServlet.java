package web.servlet;

import domain.Category;
import service.CategoryService;
import service.Impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:34 2019/12/12
 * @Version: $version$
 *查找分类
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service=new CategoryServiceImpl();
        List<Category> all = service.findAll();
        writeValue(all,response);
    }
}

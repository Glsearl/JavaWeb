package web.servlet;

import domain.Favorite;
import domain.PageBean;
import domain.Route;
import domain.User;
import service.FavoriteService;
import service.Impl.FavoriteServiceImpl;
import service.Impl.RouteServiceImpl;
import service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:24 2019/12/13
 * @Version: $version$
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service =new RouteServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid_Str = request.getParameter("cid");
        String currentPage_Str = request.getParameter("currentPage");
        String pageSize_Str = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        rname=URLDecoder.decode(rname,"utf-8");
        int cid=0;
        if (cid_Str!=null && cid_Str.length()>0 && !"null".equalsIgnoreCase(cid_Str)){
            cid = Integer.parseInt(cid_Str);
        }
       int  currentPage=0;
        if (currentPage_Str!=null && currentPage_Str.length()>0){
           currentPage=Integer.parseInt(currentPage_Str);
        }else {
            currentPage=1;//如果不传currentPage,默认值为1
        }
        int pageSize=0;
        if (pageSize_Str!=null && pageSize_Str.length()>0){
           pageSize=Integer.parseInt(pageSize_Str);
        }else {
            pageSize=5;//如果不传pageSize,默认为5
        }
        //调用service查询
        PageBean<Route> routePageBean = service.pageQuery(cid, currentPage, pageSize,rname);
        //序列化为json返回
        writeValue(routePageBean,response);
    }

    /**
     * 根据id查线路详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        Route route= service.findOne(rid);
        writeValue(route,response);
    }
    //判断当前用户是否已经收藏路线
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            uid=0;
        }else {
            uid=user.getUid();
        }
        boolean flag=favoriteService.isFavorite(rid,uid);
        writeValue(flag,response);
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
          return;
        }else {
            uid=user.getUid();
        }
       favoriteService.addFavorite(rid,uid);
    }
}

package service.Impl;

import dao.FavoriteDao;
import dao.Impl.FavoriteDaoImpl;
import dao.Impl.RouteDaoImpl;
import dao.Impl.RouteImgDaoImpl;
import dao.Impl.SellerDaoImpl;
import dao.RouteDao;
import dao.RouteImgDao;
import dao.SellerDao;
import domain.*;
import service.RouteService;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:08 2019/12/13
 * @Version: $
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao dao=new RouteDaoImpl();
    private RouteImgDao routeImgDao=new RouteImgDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pb=new PageBean<>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示多少条
        pb.setPageSize(pageSize);
        //获取总条数
        int totalCount = dao.findTotalCount(cid,rname);
        //设置总条数
        pb.setTotalCount(totalCount);
        //计算总页数
       int totalPage = totalCount % pageSize ==0 ? totalCount / pageSize :(totalCount / pageSize)+1;
       //设置总页数
        pb.setTotalPage(totalPage);
        //设置当前页显示记录
        int start = (currentPage -1)*pageSize; //开始记录数
        List<Route> list = dao.findByPage(cid, start, pageSize,rname);
        pb.setList(list);
        return pb;
    }

    @Override
    public Route findOne(String rid) {
       Route route= dao.findById(Integer.parseInt(rid));
        List<RouteImg> imgs = routeImgDao.findByRid(route.getRid());
        route.setRouteImgList(imgs);
        Seller seller = sellerDao.findBySid(route.getSid());
        route.setSeller(seller);
        int count= favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }
}

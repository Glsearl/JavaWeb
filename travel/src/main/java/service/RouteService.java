package service;

import domain.PageBean;
import domain.Route;
/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:04 2019/12/13
 * @Version: $
 */
public interface RouteService {
   public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    Route findOne(String rid);
}

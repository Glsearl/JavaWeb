package dao;

import domain.RouteImg;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 17:59 2019/12/14
 * @Version: $
 */
public interface RouteImgDao {
    public List<RouteImg> findByRid(int rid);
}

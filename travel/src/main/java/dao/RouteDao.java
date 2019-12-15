package dao;

import domain.Route;

import java.util.List;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:45 2019/12/13
 * @Version: $
 */
public interface RouteDao {
    /**
     * 根据cid查询总记录数
     * @param cid
     * @param rname
     * @return
     */
    public int findTotalCount(int cid, String rname);

    /**
     *
     * @param cid
     * @param start   起始位置
     * @param pageSize 每页显示的条数
     * @param rname
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);

    Route findById(int rid);
}

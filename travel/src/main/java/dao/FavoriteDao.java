package dao;

import domain.Favorite;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:24 2019/12/15
 * @Version: $
 */
public interface FavoriteDao {
    /**
     *
     * 查询是否已经收藏
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findRidAndUid(int rid,int uid);

    /**
     * 查询路线收藏次数
     * @param rid
     * @return
     */
    public  int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(int rid, int uid);
}

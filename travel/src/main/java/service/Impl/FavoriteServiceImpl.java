package service.Impl;

import dao.FavoriteDao;
import dao.Impl.FavoriteDaoImpl;
import domain.Favorite;
import service.FavoriteService;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:23 2019/12/15
 * @Version: $
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao dao=new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = dao.findRidAndUid(Integer.parseInt(rid), uid);
        return favorite !=null;
    }

    @Override
    public void addFavorite(String rid, int uid) {
        dao.add(Integer.parseInt(rid),uid);
    }
}

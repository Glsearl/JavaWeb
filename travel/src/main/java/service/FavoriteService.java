package service;
/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 16:21 2019/12/15
 * @Version: $
 */
public interface FavoriteService {
    public boolean isFavorite(String rid,int uid);

    void addFavorite(String rid, int uid);
}

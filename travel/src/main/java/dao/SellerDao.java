package dao;

import domain.Seller;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 18:05 2019/12/14
 * @Version: $
 */
public interface SellerDao {
    /**
     * 根据商家id查商家信息
     * @param sid
     * @return
     */
    public Seller findBySid(int sid);
}

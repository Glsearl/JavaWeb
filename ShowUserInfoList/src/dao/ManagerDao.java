package dao;

import domain.Manager;
import domain.User;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:14 2019/9/17
 * @Version: $
 */
public interface ManagerDao {
    public Manager login(String username,String password);
}

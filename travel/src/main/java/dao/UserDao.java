package dao;

import domain.User;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:10 2019/12/7
 * @Version: $
 */
public interface UserDao {
    /**
     * 查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);
    User findByUsernameAndPassword(String username, String password);
}

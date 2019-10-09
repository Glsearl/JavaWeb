package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:31 2019/9/17
 * @Version: $
 */
public interface UserDao {
    public List<User> findAll();
    public void add(User user);

    void delete(int id);

    User findUserById(int id);

    void update(User user);

    int findTotalCount(Map <String, String[]> map);

    List <User> findUserByPage(int start, int rows, Map <String, String[]> map);
}

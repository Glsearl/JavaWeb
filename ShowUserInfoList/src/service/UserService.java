package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:41 2019/9/17
 * @Version: $
 */
public interface UserService {
    public List<User> findAll();
    public void add(User user);

    void delete(String id);

    User finUserById(String id);

    void update(User user);

    void deleteSelected(String[] ids);

    PageBean<User> finUserByPage(String currentPag, String rows, Map <String, String[]> map);
}

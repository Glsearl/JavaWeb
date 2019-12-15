package service;

import domain.User;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:16 2019/12/7
 * @Version: $
 */
public interface UserService {
    public boolean register(User user);

    boolean activate(String code);

    User login(User user);
}

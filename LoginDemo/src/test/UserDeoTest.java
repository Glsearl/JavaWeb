package test;

import dao.UserDao;
import domain.User;
import org.testng.annotations.Test;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:11 2019/8/22
 * @Version: $
 */
public class UserDeoTest {
    @Test
    public void test(){
        User user=new User();
        user.setUsername("admin");
        user.setPassword("123");
        UserDao userDao=new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }
}

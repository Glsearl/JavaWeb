package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserService;
import utils.MailUtils;
import utils.UuidUtil;

/**
 * @ Author     ：gaols.
 * @ Date       ：Created in 15:17 2019/12/7
 * @Version: $
 */
public class UserServiceImpl implements UserService {
     private UserDao dao=new UserDaoImpl();
    @Override
    public boolean register(User user) {
        User u = dao.findByUsername(user.getUsername());
        if (u!=null){
            //用户名存在，注册失败
          return false;
        }
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        //保存用户信息
            dao.save(user);
            String content="<a href='http://localhost:8081/travel/user/activate?code="+user.getCode()+"'>点击激活,黑马旅游网账户</a>";
            MailUtils.sendMail(user.getEmail(),content,"黑马旅游网——激活邮件");
            return true;
        }

    @Override
    public boolean activate(String code) {
        //根据code查找用户
       User user= dao.findByCode(code);
       if (user!=null){
           //激活用户
       dao.updateStatus(user);
       return true;
       }else {
           return false;
       }
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}


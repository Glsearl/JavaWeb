package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 10:42 2019/9/17
 * @Version: $
 */
public class UserServiceImpl implements UserService {
    private static UserDao dao=new UserDaoImpl();
    @Override
    public List <User> findAll() {

        return dao.findAll();
    }

    @Override
    public void add(User user) {

        dao.add(user);
    }

    @Override
    public void delete(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User finUserById(String id) {
     User user=  dao.findUserById(Integer.parseInt(id));
      return user;
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelected(String[] ids) {
        for (String id : ids) {
            dao.delete(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean <User> finUserByPage(String s_currentPage, String s_rows, Map <String, String[]> map) {
        int currentPage = Integer.parseInt(s_currentPage);
        int rows = Integer.parseInt(s_rows);
        if(currentPage <=0) {
            currentPage = 1;
        }
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //查询总记录数
        int totalCount=dao.findTotalCount(map);
        pageBean.setTotalCount(totalCount);
        //计算开始查询索引
        int start=(currentPage-1) * rows;
        List<User> list= dao.findUserByPage(start,rows,map);
        pageBean.setList(list);
        //计算总页码
        int totalPage= (totalCount % rows) ==0? (totalCount/rows):(totalCount/rows)+1;
        if (currentPage >= totalPage){
            currentPage=totalPage;
        }
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

}

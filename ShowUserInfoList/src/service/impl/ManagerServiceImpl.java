package service.impl;

import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import domain.Manager;
import service.ManagerService;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 11:34 2019/9/17
 * @Version: $
 */
public class ManagerServiceImpl implements ManagerService {
    @Override
    public Manager login(Manager loginManager) {
        ManagerDao dao=new ManagerDaoImpl();
        return dao.login(loginManager.getUsername(),loginManager.getPassword());
    }
}

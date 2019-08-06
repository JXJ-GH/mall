package service.impl;

import DAO.IUserDao;
import DAO.impl.UserPageDaoImpl;
import DAO.impl.UserDaoImpl;
import page.PageEntity;
import service.IUserService;
import user.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public void addUser(User user) {
        IUserDao dao = new UserDaoImpl();
        dao.insertUser(user);
    }

    @Override
    public void removeUser(int id) {
        IUserDao dao = new UserDaoImpl();
        dao.deleteUserById(id);
    }

    @Override
    public void modifyUser(User user) {
        IUserDao dao = new UserDaoImpl();
        dao.update(user);
    }

    @Override
    public User findUserById(int id) {
        IUserDao dao = new UserDaoImpl();
        User user=null;
        user=dao.selectUserById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        IUserDao dao = new UserDaoImpl();
        List<User> userList=null;
        userList=dao.selectAll();
        return userList;
    }
    @Override
    public void getAll(PageEntity<User> peC) {
        UserPageDaoImpl pQDI = new UserPageDaoImpl();

        try {
            pQDI.getAll(peC);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}

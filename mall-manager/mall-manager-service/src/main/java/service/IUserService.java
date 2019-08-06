package service;

import page.PageEntity;
import user.User;

import java.util.List;

public interface IUserService {
    //增加用户
    public void addUser(User user);
    //删除用户
    public  void removeUser(int id);
    //修改用户
    public void modifyUser(User user);
    //查询单用户
    public User findUserById(int id);
    //查询所有用户
    public List<User> findAll();

    public void getAll(PageEntity<User> peC);


}

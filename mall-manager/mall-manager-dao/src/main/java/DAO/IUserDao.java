package DAO;

import user.User;

import java.util.List;

public interface IUserDao {
    //添加数据
    public void insertUser(User user);
    //删除数据 根据id
    public void deleteUserById(int id);
    //修改数据
    public void update(User user);
    //查询数据 根据ID
    public User selectUserById(int id);

    public List<User> selectAll();


    //获取商品信息总数
    public int selectCount();
}

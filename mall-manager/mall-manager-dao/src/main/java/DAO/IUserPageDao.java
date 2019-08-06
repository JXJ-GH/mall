package DAO;


import page.PageEntity;
import user.User;

public interface IUserPageDao {
    /*
     * 分页查询数据
     * */

    public void getAll(PageEntity<User> pageEntity);



}

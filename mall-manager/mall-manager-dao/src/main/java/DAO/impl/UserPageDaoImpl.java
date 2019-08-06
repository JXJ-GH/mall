package DAO.impl;


import DAO.IUserPageDao;
import Utils.JdbcUtils;
import page.PageEntity;
import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPageDaoImpl implements IUserPageDao {
    Connection conn = null;
    PreparedStatement sta = null;
    User user = null;
    ResultSet rs = null;


    @Override
    public void getAll(PageEntity<User> pageEntity) {
        UserDaoImpl cDI = new UserDaoImpl();
        int totalCount = cDI.selectCount();
        pageEntity.setTotalCount(totalCount);
        /*
         * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
         *              如果当前页为末页，再点下一页显示有问题！
         * 解决：
         *        1. 如果当前页 <= 0;       当前页设置当前页为1;
         *        2. 如果当前页 > 最大页数；  当前页设置为最大页数
         */

        if (pageEntity.getCurrentPage() <= 0) {
            pageEntity.setCurrentPage(1);
        } else if (pageEntity.getCurrentPage() > pageEntity.getTotalPage()) {
            pageEntity.setCurrentPage(pageEntity.getTotalPage());
        }

        int currentPage = pageEntity.getCurrentPage();
        int index = (currentPage - 1) * pageEntity.getPageCount();
        int count = pageEntity.getPageCount();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,username,password,email,phone,truename,birthday,sex from mmall_user limit ?,?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<User> userlist = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setTruename(rs.getString("truename"));
                user.setBirthday(rs.getString("birthday"));
                user.setSex(rs.getString("sex"));

                userlist.add(user);
            }
            pageEntity.setList(userlist);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

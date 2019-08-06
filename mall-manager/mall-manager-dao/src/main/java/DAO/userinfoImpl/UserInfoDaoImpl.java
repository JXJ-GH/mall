package DAO.userinfoImpl;


import DAO.userinfoDao.IUserInfoDao;
import Utils.JdbcUtils;
import user.UserInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDaoImpl implements IUserInfoDao {
    //通过用户名查询用户信息
    @Override
    public UserInfo getUserByUserN(String userName) {
        Connection conn = null;
        PreparedStatement sta = null;
        String sql = "select * from mmall_user where username =?";
        UserInfo user = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            sta.setString(1, userName);
            rs = sta.executeQuery();
            while (rs.next()) {
                user = new UserInfo();
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setUserId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

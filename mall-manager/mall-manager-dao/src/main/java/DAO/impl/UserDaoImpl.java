package DAO.impl;

import DAO.IUserDao;
import Utils.JdbcUtils;
import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public void insertUser(User user) {
        Connection conn =null;
        String sql = "insert into mmall_user(username,password,email,phone,truename,birthday,sex) values (?,?,?,?,?,?,?)";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn= JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
//            pps.setInt(1, user.getId());
            pps.setString(1, user.getUsername());
            pps.setString(2, user.getPassword());
            pps.setString(3, user.getEmail());
            pps.setString(4, user.getPhone());
            pps.setString(5, user.getTruename());
            pps.setString(6, user.getBirthday());
            pps.setString(7, user.getSex());

            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }

    }

    @Override
    public void deleteUserById(int id) {
        Connection conn = null;
        String sql = "delete from mmall_user where id=?";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn=JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
            pps.setInt(1,id);
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
    }

    @Override
    public void update(User user) {
        Connection conn = null;
        String sql = "update mmall_user set username=?,password=?,email=?,phone=?,truename=?,birthday=?,sex=? where id=?";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn=JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
            pps.setString(1, user.getUsername());
            pps.setString(2, user.getPassword());
            pps.setString(3, user.getEmail());
            pps.setString(4, user.getPhone());
            pps.setString(5, user.getTruename());
            pps.setString(6, user.getBirthday());
            pps.setString(7, user.getSex());
            pps.setInt(8, user.getId());
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
    }

    @Override
    public User selectUserById(int id) {
        Connection conn = null;
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        ResultSet res =null;
        String sql = "select * from mmall_user where id=?";
        User user = new User();
        try {
            conn = JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
            pps.setInt(1,id);
            res = pps.executeQuery();
            while (res.next()) {
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
                user.setEmail(res.getString("email"));
                user.setPhone(res.getString("phone"));
                user.setTruename(res.getString("truename"));
                user.setBirthday(res.getString("birthday"));
                user.setSex(res.getString("sex"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        Connection conn=null;
        Statement stt= null;
        ResultSet res=null;
        List<User> userList =new ArrayList<>();
        try {
            String sql="select * from mmall_user";
            conn = JdbcUtils.getConnection();
            stt = conn.prepareStatement(sql);
            res = stt.executeQuery(sql);
            while (res.next()) {
                User user=new User();
                user.setId(res.getInt("id"));
                user.setUsername(res.getString("username"));
                user.setPassword(res.getString("password"));
//                Date hiredate = res.getDate("hiredate");
//                String hiredateStr = "";
//                if(hiredate != null) {
//                    hiredateStr = res.getDate("hiredate").toString();
//                }
//                emp.setHiredate(hiredateStr);
                user.setEmail(res.getString("email"));
                user.setPhone(res.getString("phone"));
                user.setTruename(res.getString("truename"));
                user.setBirthday(res.getString("birthday"));
                user.setSex(res.getString("sex"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
        return userList;

    }




    @Override
    public int selectCount() {
        int count = 0;
        String sql = "select count(*) from mmall_user";
        Connection conn = null;
        PreparedStatement sta = null;

        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  //对总记录数赋值
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
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
        return count;
    }
}
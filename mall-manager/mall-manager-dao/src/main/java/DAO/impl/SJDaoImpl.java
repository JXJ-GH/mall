package DAO.impl;



import DAO.ISJDao;
import Utils.JdbcUtils;
import sj.SJ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SJDaoImpl implements ISJDao {

    @Override
    public void insertSJ(SJ sj) {
        Connection conn =null;
        String sql = "insert into mmall_sj(sjname,sjpassword,frname,frage,frbirnum,sjphone,sjdz,state) values (?,?,?,?,?,?,?,1)";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn= JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
//            pps.setInt(1, sj.getId());
            pps.setString(1, sj.getSjname());
            pps.setString(2, sj.getSjpassword());
            pps.setString(3, sj.getFrname());
            pps.setInt(4, sj.getFrage());
            pps.setString(5, sj.getFrbirnum());
            pps.setString(6, sj.getSjphone());
            pps.setString(7, sj.getSjdz());
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }

    }

    @Override
    public void deleteSJById(int id) {
        Connection conn = null;
        String sql = "delete from mmall_sj where id=?";
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
    public void update(SJ sj) {
        Connection conn = null;
        String sql = "update mmall_sj set sjname=?,sjpassword=?,frname=?,frage=?,frbirnum=?,sjphone=?,sjdz=? where id=?";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn=JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);

            pps.setString(1, sj.getSjname());
            pps.setString(2, sj.getSjpassword());
            pps.setString(3, sj.getFrname());
            pps.setInt(4, sj.getFrage());
            pps.setString(5, sj.getFrbirnum());
            pps.setString(6, sj.getSjphone());
            pps.setString(7, sj.getSjdz());
            pps.setInt(8, sj.getId());
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }

    }

    @Override
    public SJ selectSJById(int id) {
        Connection conn = null;
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        ResultSet res =null;
        String sql = "select * from mmall_sj where id=?";
        SJ sj =new SJ();
        try {
            conn = JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);
            pps.setInt(1,id);
            res = pps.executeQuery();
            while (res.next()) {
                sj.setId(res.getInt("id"));
                sj.setSjname(res.getString("sjname"));
                sj.setSjpassword(res.getString("sjpassword"));
                sj.setFrname(res.getString("frname"));
                sj.setFrage(res.getInt("frage"));
                sj.setFrbirnum(res.getString("frbirnum"));
                sj.setSjphone(res.getString("sjphone"));
                sj.setSjdz(res.getString("sjdz"));
                sj.setState(res.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
        return sj;
    }
//商家列表
    @Override
    public List<SJ> selectAll1() {
        Connection conn=null;
        Statement stt= null;
        ResultSet res=null;
        List<SJ> sjList =new ArrayList<>();
        try {
            String sql="select * from mmall_sj where state=1";
            conn = JdbcUtils.getConnection();
            stt = conn.prepareStatement(sql);
            res = stt.executeQuery(sql);
            while (res.next()) {
                SJ sj =new SJ();
                sj.setId(res.getInt("id"));
                sj.setSjname(res.getString("sjname"));
                sj.setSjpassword(res.getString("sjpassword"));
                sj.setFrname(res.getString("frname"));
                sj.setFrage(res.getInt("frage"));
                sj.setFrbirnum(res.getString("frbirnum"));
                sj.setSjphone(res.getString("sjphone"));
                sj.setSjdz(res.getString("sjdz"));
                sjList.add(sj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
        return sjList;
    }
    //注册商家列表
    @Override
    public List<SJ> selectAll0() {
        Connection conn=null;
        Statement stt= null;
        ResultSet res=null;
        List<SJ> sjList =new ArrayList<>();
        try {
            String sql="select * from mmall_sj where state=0";
            conn = JdbcUtils.getConnection();
            stt = conn.prepareStatement(sql);
            res = stt.executeQuery(sql);
            while (res.next()) {
                SJ sj =new SJ();
                sj.setId(res.getInt("id"));
                sj.setSjname(res.getString("sjname"));
                sj.setSjpassword(res.getString("sjpassword"));
                sj.setFrname(res.getString("frname"));
                sj.setFrage(res.getInt("frage"));
                sj.setFrbirnum(res.getString("frbirnum"));
                sj.setSjphone(res.getString("sjphone"));
                sj.setSjdz(res.getString("sjdz"));
                sjList.add(sj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
        return sjList;
    }


    @Override
    public void ChangeState(SJ sj) {
        Connection conn = null;
        String sql = "update mmall_sj set state=? where id=?";
//		利用PreparedStatement   创建sql语句执行器
        PreparedStatement pps = null;
        try {
            conn=JdbcUtils.getConnection();
            pps = conn.prepareStatement(sql);

            pps.setInt(1, 1);
            pps.setInt(2, sj.getId());
            pps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		释放资源
        }finally {
            JdbcUtils.releaseConnection(conn);
        }
    }
//注册数量
    @Override
    public int selectCount0() {
        int count = 0;
        String sql = "select count(*) from mmall_sj where state=0";
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
//商家数量
    @Override
    public int selectCount1() {
        int count = 0;
        String sql = "select count(*) from mmall_sj where state=1";
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

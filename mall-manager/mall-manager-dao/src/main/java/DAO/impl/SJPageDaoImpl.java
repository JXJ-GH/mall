package DAO.impl;

import DAO.ISJPageDao;
import Utils.JdbcUtils;
import page.PageEntity;
import sj.SJ;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SJPageDaoImpl implements ISJPageDao {
    Connection conn = null;
    PreparedStatement sta = null;
    SJ sj=null;
    ResultSet rs = null;

    @Override
    public void getAll1(PageEntity<SJ> pageEntity) {
        SJDaoImpl sj1 = new SJDaoImpl();
        int totalCount = sj1.selectCount1();
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
            String sql = "select id,sjname,sjpassword,frname,frage,frbirnum,sjphone,sjdz,state from mmall_sj where state=1 limit ?,?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<SJ> sjlist1 = new ArrayList<>();

            while (rs.next()) {
                SJ sj = new SJ();

                    sj.setId(rs.getInt("id"));
                    sj.setSjname(rs.getString("sjname"));
                    sj.setSjpassword(rs.getString("sjpassword"));
                    sj.setFrname(rs.getString("frname"));
                    sj.setFrage(rs.getInt("frage"));
                    sj.setFrbirnum(rs.getString("frbirnum"));
                    sj.setSjphone(rs.getString("sjphone"));
                    sj.setSjdz(rs.getString("sjdz"));
                sj.setState(rs.getInt("state"));
                    sjlist1.add(sj);



            }
            pageEntity.setList(sjlist1);
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

    @Override
    public void getAll0(PageEntity<SJ> pageEntity) {
        SJDaoImpl sj0 = new SJDaoImpl();
        int totalCount = sj0.selectCount0();
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
            String sql = "select id,sjname,sjpassword,frname,frage,frbirnum,sjphone,sjdz,state from mmall_sj where state=0 limit ?,?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<SJ> sjlist0 = new ArrayList<>();

            while (rs.next()) {
                SJ sj = new SJ();

                sj.setId(rs.getInt("id"));
                sj.setSjname(rs.getString("sjname"));
                sj.setSjpassword(rs.getString("sjpassword"));
                sj.setFrname(rs.getString("frname"));
                sj.setFrage(rs.getInt("frage"));
                sj.setFrbirnum(rs.getString("frbirnum"));
                sj.setSjphone(rs.getString("sjphone"));
                sj.setSjdz(rs.getString("sjdz"));
                sj.setState(rs.getInt("state"));
                sjlist0.add(sj);



            }
            pageEntity.setList(sjlist0);
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

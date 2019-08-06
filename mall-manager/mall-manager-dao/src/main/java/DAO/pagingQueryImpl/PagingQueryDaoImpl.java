package DAO.pagingQueryImpl;

import DAO.commodityImpl.CommodityDaoImpl;
import DAO.orderImpl.OrderDaoImpl;
import DAO.pagingQueryDao.IPagingQueryDao;
import Utils.JdbcUtils;
import commodity.CommodityIfo;

import order.OrderInfo;

import page.PageEntity;

import user.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagingQueryDaoImpl implements IPagingQueryDao {
    Connection conn = null;
    PreparedStatement sta = null;
    UserInfo user = null;
    ResultSet rs = null;

    @Override
    public void commodityIfogetAll(PageEntity<CommodityIfo> pageEntity) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
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
            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sort from mmall_product order by sort limit ?,? ";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();
            while (rs.next()) {
                CommodityIfo ci = new CommodityIfo();
                ci.setCommodityId(rs.getInt("id"));
                ci.setCommodityName(rs.getString("name"));
                ci.setCommodityPrice(rs.getDouble("price"));
                ci.setCommodityStock(rs.getInt("stock"));
                ci.setCommodityCapacity(rs.getInt("capacity"));
                ci.setImageUrl(rs.getString("sub_images"));
                ci.setCommodityYears(rs.getInt("years"));
                ci.setCommodityDegree(rs.getDouble("degree"));
                ci.setCommodityDistributor(rs.getString("distributor"));
                ci.setCommoditySort(rs.getInt("sort"));
                cilist.add(ci);
            }
            pageEntity.setList(cilist);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    public void orderInfoGetAll(PageEntity<OrderInfo> pageEntity) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        int totalCount = oDI.selectCount();
        pageEntity.setTotalCount(totalCount);
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
            String sql = "select id,user_id,name,order_no,shop,price,create_time,refund_reason,pay_state,receipt_state,discuss_state,refund_state,discuss,address from mmall_order order by order_no limit ?,?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<OrderInfo> oIL = new ArrayList<OrderInfo>();
            while (rs.next()) {
                OrderInfo oI = new OrderInfo();
                oI.setOrderId(rs.getInt("id"));
                oI.setUserID(rs.getInt("user_id"));
                oI.setOrderName(rs.getString("name"));
                oI.setOrderNo(rs.getString("order_no"));
                oI.setDistributor(rs.getString("shop"));
                oI.setOrderPrice(rs.getDouble("price"));
                oI.setOrderCreatTime(rs.getString("create_time"));
                oI.setRefundReason(rs.getString("refund_reason"));
                oI.setOrderPayState(rs.getString("pay_state"));
                oI.setReceipt_state(rs.getString("receipt_state"));
                oI.setDiscuss_state(rs.getString("discuss_state"));
                oI.setRefund_state(rs.getString("refund_state"));
                oI.setDiscuss(rs.getString("discuss"));
                oI.setOrderAddress(rs.getString("address"));
                oIL.add(oI);
            }
            pageEntity.setList(oIL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

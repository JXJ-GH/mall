package storePlatform.orderDaoImpl;

import Utils.JdbcUtils;
import storePlatform.page.PageEntity;
import storePlatform.order.Order;
import storePlatform.orderDao.IOrderDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    Connection conn = null;
    PreparedStatement sta = null;
//    Order order = null;
    ResultSet rs = null;
    @Override
    public int selectCount(String sjname) {
        int count = 0;
        String sql = "select count(*) from mmall_order where shop=?";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            sta.setString(1, sjname);
            rs = sta.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  //对总记录数赋值
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
        return count;
    }

    @Override
    public void getAllOrder(PageEntity<Order> pageEntity, String sjname) {
//        IOrderDao or = new OrderDaoImpl();
//        int totalCount = or.selectCount(sjname);
        int totalCount = selectCount(sjname);
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
//            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sjsort from mmall_product where distributor=? order by sjsort limit ?,? ";
            String sql = "select * from mmall_order where shop=? limit ?,? ";
            sta = conn.prepareStatement(sql);
            sta.setString(1, sjname);
            sta.setInt(2, index);
            sta.setInt(3, count);
            rs = sta.executeQuery();
            List<Order> orderlist = new ArrayList<>();
            while (rs.next()) {
                Order order =new Order();
                order.setId(rs.getInt("id"));
                order.setUserid(rs.getInt("user_id"));
                order.setName(rs.getString("name"));
                order.setOrderno(rs.getString("order_no"));
                order.setShop(sjname);
                order.setPrice(rs.getDouble("price"));
                order.setCreatetime(rs.getString("create_time"));
                order.setRefundreason(rs.getString("refund_reason"));
                order.setPaystate(rs.getString("pay_state"));
                order.setReceiptstate(rs.getString("receipt_state"));
                order.setDiscussstate(rs.getString("discuss_state"));
                order.setRefundstate(rs.getString("refund_state"));
                order.setDiscuss(rs.getString("discuss"));
                order.setRefundamount(rs.getString("refund_amount"));
                order.setAddress(rs.getString("address"));
                orderlist.add(order);
            }
            pageEntity.setList(orderlist);
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
    public Order selectById(int id) {
        Order order =new Order();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from mmall_order where id=?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, id);
            rs = sta.executeQuery();
            while (rs.next()) {
                order.setId(rs.getInt("id"));
                order.setUserid(rs.getInt("user_id"));
                order.setName(rs.getString("name"));
                order.setOrderno(rs.getString("order_no"));
                order.setShop(rs.getString("shop"));
                order.setPrice(rs.getDouble("price"));
                order.setCreatetime(rs.getString("create_time"));
                order.setRefundreason(rs.getString("refund_reason"));
                order.setPaystate(rs.getString("pay_state"));
                order.setReceiptstate(rs.getString("receipt_state"));
                order.setDiscussstate(rs.getString("discuss_state"));
                order.setRefundstate(rs.getString("refund_state"));
                order.setDiscuss(rs.getString("discuss"));
                order.setRefundamount(rs.getString("refund_amount"));
                order.setAddress(rs.getString("address"));

            }} catch (SQLException e) {
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
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update mmall_order set refund_state=? where id=?";
            sta = conn.prepareStatement(sql);
            sta.setString(1, order.getRefundstate());
            sta.setInt(2, order.getId());
            System.out.println(order);
//            sta.executeUpdate();
            sta.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
        }
    }

    @Override
    public void addStock(String name, String shop) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update mmall_product set stock=stock+1 where name=? and distributor=?";
            sta = conn.prepareStatement(sql);
            sta.setString(1, name);
            sta.setString(2, shop);

//            sta.executeUpdate();
            sta.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
        }
    }

    @Override
    public void deleteStock(String name, String shop) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update mmall_product set stock=stock-1 where name=? and distributor=?";
            sta = conn.prepareStatement(sql);
            sta.setString(1, name);
            sta.setString(2, shop);

//            sta.executeUpdate();
            sta.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
        }
    }
}

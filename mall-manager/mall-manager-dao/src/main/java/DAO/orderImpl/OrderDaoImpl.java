package DAO.orderImpl;


import DAO.orderDao.IOrderDao;
import Utils.JdbcUtils;
import order.OrderInfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    Connection conn = null;
    PreparedStatement sta = null;
    ResultSet rs = null;

    @Override
    public void insert(OrderInfo orderInfo) {

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into mmall_order (id,name,order_no,shop,price,create_time,refund_reason,pay_state,receipt_state,discuss_state,refund_state,discuss) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, orderInfo.getOrderId());
            sta.setString(2, orderInfo.getOrderName());
            sta.setString(3, orderInfo.getOrderNo());
            sta.setString(4, orderInfo.getDistributor());
            sta.setDouble(5, orderInfo.getOrderPrice());
            sta.setString(6, orderInfo.getOrderCreatTime());
            sta.setString(7, orderInfo.getRefundReason());
            sta.setString(8, orderInfo.getOrderPayState());
            sta.setString(9, orderInfo.getReceipt_state());
            sta.setString(10, orderInfo.getDiscuss_state());
            sta.setString(11, orderInfo.getRefund_state());
            sta.setString(12, orderInfo.getDiscuss());
            sta.execute();

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
    public void delete(int orderId) {
        try {

            conn = JdbcUtils.getConnection();
            String sql = "delete from mmall_order where id = ?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, orderId);
            sta.execute();

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
    public void upDate(OrderInfo orderInfo) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update mmall_order set name=?,order_no=?,shop=?,price=?,create_time=?,refund_reason=?,pay_state=?,receipt_state=?,discuss_state=?,refund_state=?,discuss=? where id = ?";
            sta = conn.prepareStatement(sql);
            sta.setString(1, orderInfo.getOrderName());
            sta.setString(2, orderInfo.getOrderNo());
            sta.setString(3, orderInfo.getDistributor());
            sta.setDouble(4, orderInfo.getOrderPrice());
            sta.setString(5, orderInfo.getOrderCreatTime());
            sta.setString(6, orderInfo.getRefundReason());
            sta.setString(7, orderInfo.getOrderPayState());
            sta.setString(8, orderInfo.getReceipt_state());
            sta.setString(9, orderInfo.getDiscuss_state());
            sta.setString(10, orderInfo.getRefund_state());
            sta.setString(11, orderInfo.getDiscuss());
            sta.setInt(12, orderInfo.getOrderId());
            sta.execute();
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
    public OrderInfo selectByID(int oderId) {
        OrderInfo oI = new OrderInfo();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select name,order_no,shop,price,create_time,refund_reason,pay_state,receipt_state,discuss_state,refund_state,discuss from mmall_order where id= ?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, oderId);
            rs = sta.executeQuery();
            while (rs.next()) {
                oI.setOrderId(oderId);
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
            }

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
        return oI;
    }

    @Override
    public List<OrderInfo> select() {
        List<OrderInfo> oIL = new ArrayList<OrderInfo>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,order_no,shop,price,create_time,refund_reason,pay_state,receipt_state,discuss_state,refund_state,discuss from mmall_order";
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();

            while (rs.next()) {
                OrderInfo oI = new OrderInfo();
                oI.setOrderId(rs.getInt("id"));
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
                oIL.add(oI);
            }

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
        return oIL;
    }

    @Override
    public int selectCount() {
        int count = 0;
        String sql = "select count(*) from mmall_order";
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
        return count;

    }

    @Override
    public List<OrderInfo> fuzzySelect(String str) {
        List<OrderInfo> oIL = new ArrayList<OrderInfo>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from mmall_order where name like '%"
                    + str + "%' or order_no like '%" + str + "%' or shop like '%" + str + "%'";
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();

            while (rs.next()) {
                OrderInfo oI = new OrderInfo();
                oI.setOrderId(rs.getInt("id"));
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
        return oIL;

    }
}

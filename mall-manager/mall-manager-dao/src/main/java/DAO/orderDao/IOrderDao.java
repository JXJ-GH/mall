package DAO.orderDao;

import commodity.CommodityIfo;
import order.OrderInfo;

import java.util.List;

public interface IOrderDao {
    //根据商品id增
    public void insert(OrderInfo orderInfo);
    //根据商品id删
    public void delete(int orderId);
    //根据商品id改
    public void upDate(OrderInfo orderInfo);
    //根据商品id查
    public OrderInfo selectByID(int oderId);
    //查询所有
    public List<OrderInfo> select();
    //获取商品信息总数
    public int selectCount();
    //模糊查询
    public List<OrderInfo> fuzzySelect(String str);
}

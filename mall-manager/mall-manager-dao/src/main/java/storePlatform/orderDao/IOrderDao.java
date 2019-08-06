package storePlatform.orderDao;

import storePlatform.page.PageEntity;
import storePlatform.order.Order;

public interface IOrderDao {
    //获取商家订单数目
    public int selectCount(String sjanme);
    //获取某一商家的所预订单
    public void getAllOrder(PageEntity<Order> pageEntity, String sjname);
    //根据订单id获取订单信息
    public Order selectById(int id);
    //修改订单
    public void updateOrder(Order order);
    //修改库存
    public void addStock(String name, String shop);
    public void deleteStock(String name, String shop);
}

package storePlatform.orderServiceImpl;

import storePlatform.order.Order;
import storePlatform.orderDaoImpl.OrderDaoImpl;
import storePlatform.orderService.IOrderService;
import storePlatform.page.PageEntity;

public class OrderServiceImpl implements IOrderService {

    @Override
    public void getOrderAll(PageEntity<Order> peC, String sjname) {
        OrderDaoImpl order = new OrderDaoImpl();
        try {
            order.getAllOrder(peC,sjname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

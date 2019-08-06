package storePlatform.orderService;

import storePlatform.order.Order;
import storePlatform.page.PageEntity;

public interface IOrderService {
    //商家订单（分页）
    public void getOrderAll(PageEntity<Order> peC, String sjname);
}

package service.orderService;

import commodity.CommodityIfo;
import order.OrderInfo;
import page.PageEntity;

import java.util.List;

public interface IorderService {
    public List<OrderInfo> pageSelect();

    //根据id删除
    public void pageDelete(int id);

    public void orderGetAll(PageEntity<OrderInfo> peO);

    public void pageInsert(OrderInfo oI);

    public void pageUpdate(OrderInfo oI);

    public OrderInfo pageSelectById(int id);

    public List<OrderInfo> fuzzySearch(String str);
}

package DAO.pagingQueryDao;

import commodity.CommodityIfo;
import order.OrderInfo;
import page.PageEntity;

public interface IPagingQueryDao {
    /*
     * 分页查询数据
     * */
    public void commodityIfogetAll(PageEntity<CommodityIfo> pageEntity);
    public void orderInfoGetAll(PageEntity<OrderInfo> pageEntity);

}

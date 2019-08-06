package service.orderServiceImpl;

import DAO.orderImpl.OrderDaoImpl;
import DAO.pagingQueryImpl.PagingQueryDaoImpl;
import order.OrderInfo;

import page.PageEntity;
import service.orderService.IorderService;


import java.util.List;

public class OrderServiceImpl implements IorderService {
    @Override
    public List<OrderInfo> pageSelect() {
        OrderDaoImpl oDI = new OrderDaoImpl();
        List<OrderInfo> oIL = oDI.select();
        return oIL;
    }

    @Override
    public void pageDelete(int id) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        oDI.delete(id);
    }

    @Override
    public void orderGetAll(PageEntity<OrderInfo> peO) {
        PagingQueryDaoImpl pQDI = new PagingQueryDaoImpl();
        pQDI.orderInfoGetAll(peO);

    }

    @Override
    public void pageInsert(OrderInfo oI) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        oDI.insert(oI);
    }

    @Override
    public void pageUpdate(OrderInfo oI) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        oDI.upDate(oI);
    }

    @Override
    public OrderInfo pageSelectById(int id) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        OrderInfo oI = oDI.selectByID(id);
        return oI;
    }

    @Override
    public List<OrderInfo> fuzzySearch(String str) {
        OrderDaoImpl oDI = new OrderDaoImpl();
        List<OrderInfo> oIL = oDI.fuzzySelect(str);
        return oIL;
    }
}

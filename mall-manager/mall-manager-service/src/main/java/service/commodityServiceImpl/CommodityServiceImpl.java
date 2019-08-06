package service.commodityServiceImpl;


import DAO.commodityImpl.CommodityDaoImpl;
import DAO.pagingQueryImpl.PagingQueryDaoImpl;
import commodity.CommodityIfo;
import page.PageEntity;
import service.commodityService.IcommodityService;

import java.util.List;

public class CommodityServiceImpl implements IcommodityService {

    @Override
    public List<CommodityIfo> pageSelect() {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        List<CommodityIfo>lCI = cDI.select();
        return lCI;
    }

    @Override
    public void pageDelete(int id) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        cDI.delete(id);
    }

    @Override
    public void getAll(PageEntity<CommodityIfo> peC) {
        PagingQueryDaoImpl pQDI = new PagingQueryDaoImpl();
        try {
            pQDI.commodityIfogetAll(peC);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pageInsert(CommodityIfo cI) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        cDI.insert(cI);
    }

    @Override
    public void pageUpdate(CommodityIfo cI) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        cDI.upDate(cI);
    }

    @Override
    public CommodityIfo pageSelectById(int id) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        CommodityIfo ci =cDI.selectByID(id);
        return ci;
    }

    @Override
    public List<CommodityIfo> fuzzySearch(String str) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        List<CommodityIfo>lCI = cDI.fuzzySelect(str);
        return lCI;
    }

}

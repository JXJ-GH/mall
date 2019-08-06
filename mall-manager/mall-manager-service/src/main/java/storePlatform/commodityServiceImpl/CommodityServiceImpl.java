package storePlatform.commodityServiceImpl;

import storePlatform.commodity.CommodityIfo;
import storePlatform.commodityImpl.CommodityDaoImpl;
import storePlatform.commodityService.IcommodityService;
import storePlatform.page.PageEntity;
import storePlatform.pagingQueryImpl.PagingQueryDaoImpl;

import java.util.List;

public class CommodityServiceImpl implements IcommodityService {

    @Override
    public List<CommodityIfo> pageSelect() {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        List<CommodityIfo>lCI = cDI.select();
        return lCI;
    }

    @Override
    public void getStoreAll(PageEntity<CommodityIfo> peC, String sjname) {
        PagingQueryDaoImpl pQDI = new PagingQueryDaoImpl();
        try {
            pQDI.getAllStore(peC,sjname);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CommodityIfo> findStoreAll(String sjname) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        List<CommodityIfo>lCI = cDI.select(sjname);
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
            pQDI.getAll(peC);
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
    public List<CommodityIfo> fuzzySearch(String str, String shop) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        List<CommodityIfo>lCI = cDI.fuzzySelect(str,shop);
        return lCI;
    }


}

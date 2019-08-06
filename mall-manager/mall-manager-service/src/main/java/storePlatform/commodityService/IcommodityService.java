package storePlatform.commodityService;

import storePlatform.commodity.CommodityIfo;
import storePlatform.page.PageEntity;

import java.util.List;

public interface IcommodityService {
    //查找页面商品属性字段
    public List<CommodityIfo> pageSelect();

    //商家商品
    public void getStoreAll(PageEntity<CommodityIfo> peC, String sjname);

    //
    public List<CommodityIfo> findStoreAll(String sjname);

    //根据id删除
    public void pageDelete(int id);

    public void getAll(PageEntity<CommodityIfo> peC);

    public void pageInsert(CommodityIfo cI);

    public void pageUpdate(CommodityIfo cI);

    public CommodityIfo pageSelectById(int id);

    public List<CommodityIfo> fuzzySearch(String str, String shop);

}

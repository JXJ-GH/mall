package service.commodityService;

import commodity.CommodityIfo;
import page.PageEntity;

import java.util.List;

public interface IcommodityService {
    //查找页面商品属性字段
    public List<CommodityIfo> pageSelect();

    //根据id删除
    public void pageDelete(int id);

    public void getAll(PageEntity<CommodityIfo> peC);

    public void pageInsert(CommodityIfo cI);

    public void pageUpdate(CommodityIfo cI);

    public CommodityIfo pageSelectById(int id);

    public List<CommodityIfo> fuzzySearch(String str);

}

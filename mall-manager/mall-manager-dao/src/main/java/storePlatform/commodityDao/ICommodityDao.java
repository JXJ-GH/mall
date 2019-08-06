package storePlatform.commodityDao;

import storePlatform.commodity.CommodityIfo;

import java.util.List;

public interface ICommodityDao {
    //根据商品id增
    public void insert(CommodityIfo commodityIfo);
    //根据商品id删
    public void delete(int commodityID);

    //根据商品id改
    public void upDate(CommodityIfo commodityIfo);
    //根据商品id查
    public storePlatform.commodity.CommodityIfo selectByID(int commodityID);
    //查询某一商家的所有商品
    public List<CommodityIfo> select(String sjanme);
    //查询所有
    public List<CommodityIfo> select();
    //获取商品信息总数
    public int selectCount();
    //获取商家商品信息总数
    public int selectCount(String sjanme);
    //模糊查询
    public List<CommodityIfo> fuzzySelect(String str, String shop);
}

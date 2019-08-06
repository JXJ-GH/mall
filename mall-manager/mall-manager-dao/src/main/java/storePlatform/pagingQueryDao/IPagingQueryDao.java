package storePlatform.pagingQueryDao;

import storePlatform.commodity.CommodityIfo;
import storePlatform.page.PageEntity;

public interface IPagingQueryDao {
    /*
     * 分页查询数据
     * */
    public void getAll(PageEntity<CommodityIfo> pageEntity);

    public void getAllStore(PageEntity<CommodityIfo> pageEntity, String sjname);
}

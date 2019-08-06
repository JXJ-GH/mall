package storePlatform.pagingQueryImpl;

import Utils.JdbcUtils;
import storePlatform.commodity.CommodityIfo;
import storePlatform.commodityImpl.CommodityDaoImpl;
import storePlatform.page.PageEntity;
import storePlatform.pagingQueryDao.IPagingQueryDao;
import user.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagingQueryDaoImpl implements IPagingQueryDao {
    Connection conn = null;
    PreparedStatement sta = null;
    UserInfo user = null;
    ResultSet rs = null;

    @Override
    public void getAll(PageEntity<CommodityIfo> pageEntity) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        int totalCount = cDI.selectCount();
        pageEntity.setTotalCount(totalCount);
        /*
         * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
         *              如果当前页为末页，再点下一页显示有问题！
         * 解决：
         *        1. 如果当前页 <= 0;       当前页设置当前页为1;
         *        2. 如果当前页 > 最大页数；  当前页设置为最大页数
         */

        if (pageEntity.getCurrentPage() <= 0) {
            pageEntity.setCurrentPage(1);
        } else if (pageEntity.getCurrentPage() > pageEntity.getTotalPage()) {
            pageEntity.setCurrentPage(pageEntity.getTotalPage());
        }

        int currentPage = pageEntity.getCurrentPage();
        int index = (currentPage - 1) * pageEntity.getPageCount();
        int count = pageEntity.getPageCount();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sort from mmall_product order by sort limit ?,? ";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, index);
            sta.setInt(2, count);
            rs = sta.executeQuery();
            List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();
            while (rs.next()) {
                CommodityIfo ci = new CommodityIfo();
                ci.setCommodityId(rs.getInt("id"));
                ci.setCommodityName(rs.getString("name"));
                ci.setCommodityPrice(rs.getDouble("price"));
                ci.setCommodityStock(rs.getInt("stock"));
                ci.setCommodityCapacity(rs.getInt("capacity"));
                ci.setImageUrl(rs.getString("sub_images"));
                ci.setCommodityYears(rs.getInt("years"));
                ci.setCommodityDegree(rs.getDouble("degree"));
                ci.setCommodityDistributor(rs.getString("distributor"));
                ci.setCommoditySort(rs.getInt("sort"));
                cilist.add(ci);
            }
            pageEntity.setList(cilist);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void getAllStore(PageEntity<CommodityIfo> pageEntity, String sjname) {
        CommodityDaoImpl cDI = new CommodityDaoImpl();
        int totalCount = cDI.selectCount(sjname);
        pageEntity.setTotalCount(totalCount);
        /*
         * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
         *              如果当前页为末页，再点下一页显示有问题！
         * 解决：
         *        1. 如果当前页 <= 0;       当前页设置当前页为1;
         *        2. 如果当前页 > 最大页数；  当前页设置为最大页数
         */

        if (pageEntity.getCurrentPage() <= 0) {
            pageEntity.setCurrentPage(1);
        } else if (pageEntity.getCurrentPage() > pageEntity.getTotalPage()) {
            pageEntity.setCurrentPage(pageEntity.getTotalPage());
        }

        int currentPage = pageEntity.getCurrentPage();
        int index = (currentPage - 1) * pageEntity.getPageCount();
        int count = pageEntity.getPageCount();
        try {
            conn = JdbcUtils.getConnection();
//            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sjsort from mmall_product where distributor=? order by sjsort limit ?,? ";
            String sql = "select * from mmall_product where distributor=? order by sjsort limit ?,? ";
            sta = conn.prepareStatement(sql);
            sta.setString(1, sjname);
            sta.setInt(2, index);
            sta.setInt(3, count);
            rs = sta.executeQuery();
            List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();
            while (rs.next()) {
                CommodityIfo ci = new CommodityIfo();
                ci.setCommodityId(rs.getInt("id"));
                ci.setCommodityName(rs.getString("name"));
                ci.setCommodityPrice(rs.getDouble("price"));
                ci.setCommodityStock(rs.getInt("stock"));
                ci.setCommodityCapacity(rs.getInt("capacity"));
                ci.setImageUrl(rs.getString("sub_images"));
                ci.setCommodityYears(rs.getInt("years"));
                ci.setCommodityDegree(rs.getDouble("degree"));
                ci.setCommodityDistributor(rs.getString("distributor"));
                ci.setCommoditySort(rs.getInt("sort"));
                ci.setSjsort(rs.getInt("sjsort"));
                cilist.add(ci);
            }
            pageEntity.setList(cilist);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

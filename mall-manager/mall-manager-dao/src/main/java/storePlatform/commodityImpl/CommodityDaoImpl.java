package storePlatform.commodityImpl;

import Utils.JdbcUtils;
import storePlatform.commodity.CommodityIfo;
import storePlatform.commodityDao.ICommodityDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl implements ICommodityDao {
    Connection conn = null;
    PreparedStatement sta = null;
    ResultSet rs = null;

    @Override
    public void insert(CommodityIfo commodityIfo) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into mmall_product (name,price,stock,capacity,sub_images,years,degree,distributor) values(?,?,?,?,?,?,?,?)";
            sta = conn.prepareStatement(sql);
//            sta.setInt(1, commodityIfo.getCommodityId());
            sta.setString(1, commodityIfo.getCommodityName());
            sta.setDouble(2, commodityIfo.getCommodityPrice());
            sta.setInt(3, commodityIfo.getCommodityStock());
            sta.setInt(4, commodityIfo.getCommodityCapacity());
            sta.setString(5, commodityIfo.getImageUrl());
            sta.setInt(6, commodityIfo.getCommodityYears());
            sta.setDouble(7, commodityIfo.getCommodityDegree());
            sta.setString(8, commodityIfo.getCommodityDistributor());

            sta.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
        }

    }

    @Override
    public void delete(int commodityID) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from mmall_product where id = ?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, commodityID);
            sta.execute();

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
    public void upDate(CommodityIfo commodityIfo) {

        try {
            conn = JdbcUtils.getConnection();
            String sql = "update mmall_product set name=?,price=?,stock=?,capacity=?,sub_images=?,years=?,degree=?,distributor=?,sjsort=? where id=?";
            sta = conn.prepareStatement(sql);
            sta.setString(1, commodityIfo.getCommodityName());
            sta.setDouble(2, commodityIfo.getCommodityPrice());
            sta.setInt(3, commodityIfo.getCommodityStock());
            sta.setInt(4, commodityIfo.getCommodityCapacity());
            sta.setString(5, commodityIfo.getImageUrl());
            sta.setInt(6, commodityIfo.getCommodityYears());
            sta.setDouble(7, commodityIfo.getCommodityDegree());
            sta.setString(8, commodityIfo.getCommodityDistributor());
            sta.setInt(9, commodityIfo.getSjsort());
            sta.setInt(10, commodityIfo.getCommodityId());
            System.out.println(commodityIfo.getCommodityCapacity());
//            sta.executeUpdate();
            sta.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
        }

    }

    @Override
    public CommodityIfo selectByID(int commodityID) {
        CommodityIfo ci = new CommodityIfo();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from mmall_product where id= ?";
            sta = conn.prepareStatement(sql);
            sta.setInt(1, commodityID);
            rs = sta.executeQuery();
            while (rs.next()) {
                ci.setCommodityId(commodityID);
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
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
        return ci;
    }
    @Override
    public List<CommodityIfo> select(String sjname) {
        List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();

        try {
        conn = JdbcUtils.getConnection();
        String sql = "select name,price,stock,capacity,sub_images,years,degree,distributor,sort from mmall_product where distributor=?";
        sta = conn.prepareStatement(sql);
        sta.setString(1, sjname);
        rs = sta.executeQuery();
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
        }} catch (SQLException e) {
        e.printStackTrace();
        }finally {
            JdbcUtils.releaseConnection(conn);
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
        return cilist;
    }
    @Override
    public List<CommodityIfo> select() {
        List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();
        try {

            conn = JdbcUtils.getConnection();
            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sort from mmall_product ";
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();

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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
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
        return cilist;
    }
    @Override
    public int selectCount() {
        int count = 0;
        String sql = "select count(*) from mmall_product";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  //对总记录数赋值
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
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
        return count;
    }
    @Override
    public int selectCount(String sjname) {
        int count = 0;
        String sql = "select count(*) from mmall_product where distributor=?";
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            sta.setString(1, sjname);
            rs = sta.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);  //对总记录数赋值
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
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
        return count;
    }
    @Override
    public List<CommodityIfo> fuzzySelect(String str, String shop) {
        List<CommodityIfo> cilist = new ArrayList<CommodityIfo>();
        try {

            conn = JdbcUtils.getConnection();
//            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sjsort from mmall_product where name like '%"
//                     +str+"%' or distributor like '%"+str+"%' or kind like '%"+str+"%'";
            String sql = "select id,name,price,stock,capacity,sub_images,years,degree,distributor,sjsort from mmall_product where distributor='"+shop+"' and name like '%"
                    +str+"%'";

            sta = conn.prepareStatement(sql);
            rs = sta.executeQuery();
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
                ci.setSjsort(rs.getInt("sjsort"));

                cilist.add(ci);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(conn);
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
        return cilist;

    }

}


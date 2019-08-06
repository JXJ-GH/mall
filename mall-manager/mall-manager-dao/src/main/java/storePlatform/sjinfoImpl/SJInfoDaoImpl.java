package storePlatform.sjinfoImpl;



import Utils.JdbcUtils;
import storePlatform.sj.SJ;
import storePlatform.sjinfoDao.ISJInfoDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SJInfoDaoImpl implements ISJInfoDao {
    @Override
    public SJ getSJByName(String name) {
        Connection conn = null;
        PreparedStatement sta = null;
        String sql = "select * from mmall_sj where sjname =? and state!=0";
        SJ sj= null;
        ResultSet res = null;
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.prepareStatement(sql);
            sta.setString(1, name);
            res = sta.executeQuery();
            while (res.next()) {
                sj = new SJ();
                sj.setId(res.getInt("id"));
                sj.setSjname(res.getString("sjname"));
                sj.setSjpassword(res.getString("sjpassword"));
                sj.setFrname(res.getString("frname"));
                sj.setFrage(res.getInt("frage"));
                sj.setFrbirnum(res.getString("frbirnum"));
                sj.setSjphone(res.getString("sjphone"));
                sj.setSjdz(res.getString("sjdz"));
                sj.setState(res.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sj;
    }
}

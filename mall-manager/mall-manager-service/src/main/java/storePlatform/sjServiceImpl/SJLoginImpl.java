package storePlatform.sjServiceImpl;

import storePlatform.sj.SJ;
import storePlatform.sjService.ISJLogin;
import storePlatform.sjinfoDao.ISJInfoDao;
import storePlatform.sjinfoImpl.SJInfoDaoImpl;

public class SJLoginImpl implements ISJLogin {
    @Override
    public SJ getSj(String name) {
        ISJInfoDao sjl = new SJInfoDaoImpl();
        SJ sj = sjl.getSJByName(name);
        if(sj==null){
            return null;
        }
        return sj;
    }
}

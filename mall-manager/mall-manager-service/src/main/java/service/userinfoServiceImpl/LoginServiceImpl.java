package service.userinfoServiceImpl;


import DAO.userinfoImpl.UserInfoDaoImpl;
import service.userinfoService.ILoginService;
import user.UserInfo;

public class LoginServiceImpl implements ILoginService {
    //通过用户名获取密码用以登陆
    public String getPass(String name) {
        UserInfoDaoImpl uidi = new UserInfoDaoImpl();
        UserInfo ui = uidi.getUserByUserN(name);
        if(ui==null){
            return null;
        }
        return ui.getPassWord();

    }

}

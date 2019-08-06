import service.IUserService;
import service.impl.UserServiceImpl;
import user.User;

import java.util.List;

public class UserTest {
    public static void main(String[] args){
        IUserService service = new UserServiceImpl();
        List<User> userList = service.findAll();
        System.out.println(userList);
    }
}

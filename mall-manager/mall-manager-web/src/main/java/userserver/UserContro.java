package userserver;



import DAO.IUserDao;
import DAO.impl.UserDaoImpl;
import Utils.MD5Utils;
import service.IUserService;
import service.impl.UserServiceImpl;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user.do")
public class UserContro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fun = request.getParameter("_method");
        switch (fun){
            case "add":
                add(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "save":
                save(request,response);
                break;
            case "modify":
                modify(request,response);
                break;
            case "search":
                search(request,response);
                break;
            case "deletes":
                deletes(request,response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserDao user = new UserDaoImpl();
        List<User> userList =null;
        userList =user.selectAll();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/adduser.jsp").forward(req,resp);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        IUserService service = new UserServiceImpl();
        User user =service.findUserById(id);
//        IUserDao dept =new UserDaoImpl();
//        List<User> userList =null;
//        userList=dept.selectAll();
        req.setAttribute("user",user);
//        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/adduser.jsp").forward(req,resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        IUserService service = new UserServiceImpl();
        service.removeUser(id);
        resp.sendRedirect("/userlist.do?_method=pagingSelect");

    }
    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        int id =Integer.valueOf(req.getParameter("id"));
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        String email =req.getParameter("email");
        String phone =req.getParameter("phone");
        String truename =req.getParameter("truename");
        String birthday =req.getParameter("birthday");
        String sex =req.getParameter("sex");





        password= MD5Utils.md5(password);

//        int deptno =Integer.valueOf(req.getParameter("dept"));
        User user =new User();
//        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setTruename(truename);
        user.setSex(sex);

        user.setBirthday(birthday);

        IUserService service =new UserServiceImpl();
        service.addUser(user);
        resp.sendRedirect("/userlist.do?_method=pagingSelect");
    }
    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id =Integer.valueOf(req.getParameter("id"));
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        String email =req.getParameter("email");
        String phone =req.getParameter("phone");
        String truename =req.getParameter("truename");
        String birthday =req.getParameter("birthday");
        String sex =req.getParameter("sex");
        User user =new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setTruename(truename);
        user.setSex(sex);

        user.setBirthday(birthday);
//
        IUserService service =new UserServiceImpl();
        service.modifyUser(user);
        resp.sendRedirect("/userlist.do?_method=pagingSelect");
    }
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("searchwords")==null){

        }else{
            int id=Integer.valueOf(req.getParameter("searchwords"));

            IUserService service = new UserServiceImpl();
            User user =service.findUserById(id);

            req.setAttribute("user",user);
            req.getRequestDispatcher("/searchuser.jsp").forward(req,resp);
        }

    }
    public void deletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService service = new UserServiceImpl();
        String[] ids = req.getParameterValues("check");
        int id= 0;
        if(ids != null){
            for(int i=0;i<ids.length;i++){
                id=Integer.valueOf(ids[i]);
                service.removeUser(id);
            }
            resp.sendRedirect("/userlist.do?_method=pagingSelect");

        }else{
            System.out.println("没传进去");
            resp.sendRedirect("/userlist.do?_method=pagingSelect");
        }
    }


}

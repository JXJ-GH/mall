package sjserver;



import DAO.ISJDao;
import DAO.impl.SJDaoImpl;
import Utils.MD5Utils;
import service.ISJService;
import service.impl.SJServiceImpl;
import sj.SJ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sj.do")
public class SJContro extends HttpServlet {
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
            case "show":
                show(request,response);
                break;
            case "change":
                change(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISJDao sj = new SJDaoImpl();
        List<SJ> sjList =null;

        sjList =sj.selectAll1();

        request.setAttribute("sjList",sjList);
        request.getRequestDispatcher("/addStore.jsp").forward(request,response);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        ISJDao sjl = new SJDaoImpl();
        SJ sj =sjl.selectSJById(id);
//        IUserDao dept =new UserDaoImpl();
//        List<User> userList =null;
//        userList=dept.selectAll();
        req.setAttribute("sj",sj);
//        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/addStore.jsp").forward(req,resp);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        ISJDao sjl = new SJDaoImpl();
        SJ sj =sjl.selectSJById(id);
        if(sj.getState()==1) {
            sjl.deleteSJById(id);
            response.sendRedirect("/sjlist.do?_method=pagingSelect");
        }
        if(sj.getState()==0) {
            sjl.deleteSJById(id);
            response.sendRedirect("/sjlist.do?_method=paging");
        }


    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        int id =Integer.valueOf(req.getParameter("id"));
        String sjname =req.getParameter("sjname");
        String sjpassword =req.getParameter("sjpassword");
        String frname =req.getParameter("frname");
        int frage =Integer.valueOf(req.getParameter("frage"));
        String frbirnum =req.getParameter("frbirnum");
        String sjphone =req.getParameter("sjphone");
        String sjdz =req.getParameter("sjdz");

        sjpassword= MD5Utils.md5(sjpassword);

//        int deptno =Integer.valueOf(req.getParameter("dept"));
        SJ sj = new SJ();
//        sj.setId(id);
        sj.setSjdz(sjdz);
        sj.setSjphone(sjphone);
        sj.setFrbirnum(frbirnum);
        sj.setFrage(frage);
        sj.setFrname(frname);
        sj.setSjpassword(sjpassword);
        sj.setSjname(sjname);
        ISJDao sjl= new SJDaoImpl();
        System.out.println(sj);
        sjl.insertSJ(sj);
        resp.sendRedirect("/sjlist.do?_method=pagingSelect");
    }

    public void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id =Integer.valueOf(req.getParameter("id"));
        String sjname =req.getParameter("sjname");
        String sjpassword =req.getParameter("sjpassword");
        String frname =req.getParameter("frname");
        String sjphone =req.getParameter("sjphone");
        int frage =Integer.valueOf(req.getParameter("frage"));
        String sjdz =req.getParameter("sjdz");
        String frbirnum =req.getParameter("frbirnum");
        SJ sj = new SJ();
        sj.setId(id);
        sj.setSjname(sjname);
        sj.setSjpassword(sjpassword);
        sj.setFrname(frname);
        sj.setSjphone(sjphone);
        sj.setFrage(frage);
        sj.setSjdz(sjdz);

        sj.setFrbirnum(frbirnum);
        System.out.println(sj);
        ISJService service =new SJServiceImpl();

        service.modifySJ(sj);
        resp.sendRedirect("/sjlist.do?_method=pagingSelect");
    }
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("searchwords")==null){

        }else{
            int id=Integer.valueOf(req.getParameter("searchwords"));

            ISJService service =new SJServiceImpl();
            SJ sj =service.findSJById(id);

            req.setAttribute("sj",sj);
            req.getRequestDispatcher("/searchsj.jsp").forward(req,resp);
        }

    }
    public void deletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ISJService service =new SJServiceImpl();
        String[] ids = req.getParameterValues("check");

        int id= 0;
        if(ids != null){

            SJ sj=service.findSJById(Integer.valueOf(ids[0]));

            for(int i=0;i<ids.length;i++){
                id=Integer.valueOf(ids[i]);
                service.removeSJ(id);

            }
            if(sj.getState()==1) {
                resp.sendRedirect("/sjlist.do?_method=pagingSelect");
            }
            if(sj.getState()==0) {

                resp.sendRedirect("/sjlist.do?_method=paging");
            }

        }else{
            System.out.println("没传进去");
            resp.sendRedirect("/sjlist.do?_method=pagingSelect");
        }
    }
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        ISJDao sjl = new SJDaoImpl();
        SJ sj =sjl.selectSJById(id);
//        IUserDao dept =new UserDaoImpl();
//        List<User> userList =null;
//        userList=dept.selectAll();
        req.setAttribute("sj",sj);
//        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/sjapplicantInfo.jsp").forward(req,resp);
    }
    public void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.valueOf(req.getParameter("id"));
        ISJDao sjl = new SJDaoImpl();
        SJ sj =sjl.selectSJById(id);
        sjl.ChangeState(sj);
//        req.setAttribute("sj",sj);
//        req.setAttribute("userList",userList);
        req.getRequestDispatcher("/sjlist.do?_method=paging").forward(req,resp);
    }
}

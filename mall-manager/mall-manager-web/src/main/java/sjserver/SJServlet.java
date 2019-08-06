package sjserver;



import DAO.ISJDao;
import DAO.impl.SJDaoImpl;
import page.PageEntity;
import service.impl.SJServiceImpl;
import sj.SJ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sjlist.do")
public class SJServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("_method");
        if (method == null) {
            doNot(req, resp);
        }
        switch (method) {
            case "pagingSelect":
                pagingSelect(req,resp);
                break;
            case  "paging":
                paging(req,resp);
                break;

        }
    }
    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }
    public void pagingSelect(HttpServletRequest req, HttpServletResponse resp) {
        SJServiceImpl cSI = new SJServiceImpl();
        String uri;
        try {
//获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

//判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

//转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageEntity<SJ> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);

//调用service层

            cSI.getAll1(pe);
            System.out.println(pe.getList());

//保存域对象
            req.setAttribute("pageBean", pe);
            uri = "/storeInformation.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            uri = "/mainindex.jsp";
        }

        try {
            req.getRequestDispatcher(uri).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void paging(HttpServletRequest req, HttpServletResponse resp){
        SJServiceImpl cSI = new SJServiceImpl();
        String uri;
        try {
//获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");

//判断   第一次是设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

//转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
            int currentPage = Integer.parseInt(currPage);

            PageEntity<SJ> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);

//调用service层

            cSI.getAll0(pe);
            System.out.println(pe.getList());

//保存域对象
            req.setAttribute("pageBean", pe);
            uri = "/storeAudit.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            uri = "/mainindex.jsp";
        }

        try {
            req.getRequestDispatcher(uri).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

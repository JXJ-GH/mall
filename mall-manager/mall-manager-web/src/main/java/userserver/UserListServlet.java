package userserver;



import page.PageEntity;
import service.impl.UserServiceImpl;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userlist.do")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        if (method == null) {
            doNot(req, resp);
        }
        switch (method) {

            case "pagingSelect":
                pagingSelect(req,resp);
        }

    }

    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }



    public void pagingSelect(HttpServletRequest req, HttpServletResponse resp) {
        UserServiceImpl cSI = new UserServiceImpl();
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

            PageEntity<User> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);

//调用service层

            cSI.getAll(pe);

//保存域对象
            req.setAttribute("pageBean", pe);
            uri = "/userlist.jsp";
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

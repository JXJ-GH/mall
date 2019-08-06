package storePlatform.login;

import Utils.MD5Utils;
import storePlatform.sj.SJ;
import storePlatform.sjService.ISJLogin;
import storePlatform.sjServiceImpl.SJLoginImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/sj/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("_method");
        if (method == null) {
        doNot(req, resp);
    }
        switch (method) {
        case "login":
            login(req, resp);
            break;
    }
}

    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String psaaword = req.getParameter("password");
        String pass = MD5Utils.md5(psaaword);
//
        ISJLogin log = new SJLoginImpl();
        SJ sj= log.getSj(name);
        if(sj==null){
            req.setAttribute("prompt","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        String dbpass=sj.getSjpassword();
        int state= sj.getState();
//        System.out.println(dbpass);
        if (dbpass == null||!pass.equals(dbpass)) {
            req.setAttribute("prompt","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        if (log != null && pass.equals(dbpass)) {
            HttpSession hs = req.getSession();
            hs.setAttribute("sjname",name);

            if (state == 1) {

                resp.sendRedirect("/storemainindex.jsp");
            }
            if(state==2){
                resp.sendRedirect("/mainindex.jsp");
            }



        }
    }
}

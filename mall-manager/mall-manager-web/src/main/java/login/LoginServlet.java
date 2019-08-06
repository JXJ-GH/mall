package login;



import Utils.MD5Utils;
import service.userinfoServiceImpl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user/login.do")
public class LoginServlet extends HttpServlet {
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
        case "login":
            login(req, resp);
            break;
    }
}

    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uName = req.getParameter("name");
        String passW = req.getParameter("password");
        String pass = MD5Utils.md5(passW);
        LoginServiceImpl log = new LoginServiceImpl();
        String dbpass = log.getPass(uName);
        if (dbpass == null|!pass.equals(dbpass)) {
            req.setAttribute("prompt","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        if (log != null && pass.equals(dbpass)) {
            resp.sendRedirect("/mainindex.jsp");
            HttpSession hs = req.getSession();
            hs.setAttribute("userName",uName);
            return;
        }
    }
}

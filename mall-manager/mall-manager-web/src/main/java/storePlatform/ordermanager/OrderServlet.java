package storePlatform.ordermanager;

import storePlatform.order.Order;
import storePlatform.orderDao.IOrderDao;
import storePlatform.orderDaoImpl.OrderDaoImpl;
import storePlatform.orderServiceImpl.OrderServiceImpl;
import storePlatform.page.PageEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store/order.do")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("_method");
        if (method == null) {
            doNot(req, resp);
        }
        switch (method) {

            case "pagingSelect":
                pagingSelect(req, resp);
                break;
            case "agree":
                agree(req, resp);
                break;
            case "refund":
                refund(req, resp);
                break;

        }
        System.out.println(method);
    }
    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }
    public void pagingSelect(HttpServletRequest req, HttpServletResponse resp) {
        OrderServiceImpl order = new OrderServiceImpl();
        String sjname= (String) req.getSession().getAttribute("sjname");
        String uri;
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");
            //判断 第一次设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

            int currentPage = Integer.parseInt(currPage);
            PageEntity<Order> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);

            order.getOrderAll(pe,sjname);
            req.setAttribute("pageBean", pe);
            uri = "/storeorderlist.jsp";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            uri = "/error.jsp";
        }

        try {
            req.getRequestDispatcher(uri).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void agree(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        IOrderDao or = new OrderDaoImpl();
        Order order=or.selectById(id);

        if("已通过".equals(order.getRefundstate())){

        }else{
            order.setRefundstate("已通过");
            or.updateOrder(order);
            String shop=order.getShop();
            String name=order.getName();
            or.deleteStock(name,shop);
        }

        try {
            req.getRequestDispatcher("/store/order.do?_method=pagingSelect").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void refund(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        IOrderDao or = new OrderDaoImpl();
        Order order=or.selectById(id);
        if("已退单".equals(order.getRefundstate())){

        }else {
            order.setRefundstate("已退单");
            or.updateOrder(order);
            String shop = order.getShop();
            String name = order.getName();
            or.addStock(name, shop);
        }

        try {
            req.getRequestDispatcher("/store/order.do?_method=pagingSelect").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

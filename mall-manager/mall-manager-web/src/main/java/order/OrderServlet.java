package order;


import page.PageEntity;
import service.orderServiceImpl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/order/handle.do")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("_method");
        if (method == null) {
            doNot(req, resp);
        }
        switch (method) {
            //商品管理操作
            case "delete":
                delete(req, resp);
                break;

            case "updateChange":
                updateChange(req, resp);
                break;
            case "updateSubmit":
                updateSubmit(req, resp);
                break;
            case "pagingSelect":
                pagingSelect(req, resp);
                break;

            case "fuzzySearch":
                fuzzySearch(req, resp);
                break;

        }
        System.out.println(method);
    }

    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }



    //删除功能
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        OrderServiceImpl oSI = new OrderServiceImpl();
        String did = req.getParameter("id");
        String currPage = req.getParameter("currentPage");
        Integer deleteId = Integer.parseInt(did);
        int cPage = Integer.parseInt(currPage);
        oSI.pageDelete(deleteId);
        try {
            req.getRequestDispatcher("/order/handle.do?_method=pagingSelect&currentPage=" + cPage).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void updateChange(HttpServletRequest req, HttpServletResponse resp) {
        OrderServiceImpl oSI = new OrderServiceImpl();
        int iD = Integer.parseInt(req.getParameter("id"));
        OrderInfo oI = oSI.pageSelectById(iD);
        try {
            req.setAttribute("info", oI);
            req.getRequestDispatcher("/orderInfo.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //修改后提交
    public void updateSubmit(HttpServletRequest req, HttpServletResponse resp) {
        int orderId = Integer.parseInt(req.getParameter("id"));
        String odno = req.getParameter("orderNO");
        String goodsName = req.getParameter("name");
        int userID = Integer.parseInt(req.getParameter("userid"));

        Double orderPrice = Double.parseDouble(req.getParameter("orderPrice"));
        String store = req.getParameter("distributor");
        String orderTime = req.getParameter("creatTime");
        String orderPayState = req.getParameter("orderPayState");
        String refund_state = req.getParameter("refund_state");
        String receipt_state = req.getParameter("receipt_state");
        OrderInfo oI = new OrderInfo();
        oI.setOrderId(orderId);
        oI.setOrderNo(odno);
        oI.setOrderName(goodsName);
        oI.setUserID(userID);
        oI.setOrderPrice(orderPrice);
        oI.setDistributor(store);
        oI.setOrderCreatTime(orderTime);
        oI.setReceipt_state(receipt_state);
        oI.setOrderPayState(orderPayState);
        oI.setRefund_state(refund_state);
        OrderServiceImpl oSI = new OrderServiceImpl();
        oSI.pageUpdate(oI);
        try {
            req.getRequestDispatcher("/order/handle.do?_method=pagingSelect").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 商品信息分页查询

    public void pagingSelect(HttpServletRequest req, HttpServletResponse resp) {
        OrderServiceImpl oSI = new OrderServiceImpl();
        String uri;
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("currentPage");
            //判断 第一次设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

            int currentPage = Integer.parseInt(currPage);
            PageEntity<OrderInfo> peo = new PageEntity<>();
            peo.setCurrentPage(currentPage);
            oSI.orderGetAll(peo);
            req.setAttribute("orderpage",peo);
            uri = "/orderlist.jsp";
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

    //模糊查询商品信息
    public void fuzzySearch(HttpServletRequest req, HttpServletResponse resp) {
        String str = req.getParameter("keywords");
        System.out.println(str);
        OrderServiceImpl oSI = new OrderServiceImpl();
        List<OrderInfo> oInfoL = oSI.fuzzySearch(str);
        req.setAttribute("fuzzySInfo",oInfoL);
        try {
            req.getRequestDispatcher("/orderFuzzyPage.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
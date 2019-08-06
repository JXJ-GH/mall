package storePlatform.commoditylist;

import storePlatform.commodity.CommodityIfo;
import storePlatform.commodityServiceImpl.CommodityServiceImpl;
import storePlatform.page.PageEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store/commodity/handle.do")
public class CommodityListServlet extends HttpServlet {
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
            case "pagingSelect":
                pagingSelect(req, resp);
                break;
            case "insert":
                insert(req, resp);
                break;
            case "updateChange":
                updateChange(req, resp);
                break;
            case "updateSubmit":
                updateSubmit(req, resp);
                break;
            case "fuzzySearch":
                fuzzySearch(req,resp);
                break;
            case "productDisply":
                productDisply(req, resp);
                break;
            case"deleteSelect":
                deleteSelect(req,resp);
                break;
                //商品上下架操作
            case "putGoodsConfirm":
                putGoodsConfirm(req, resp);
                break;
            case "unShelve":
                unShelve(req, resp);
                break;
            case "putGoods":
                putGoods(req, resp);
                break;
        }
        System.out.println(method);
    }

    public void doNot(HttpServletRequest req, HttpServletResponse resp) {

    }


    // 商品信息分页查询

    public void pagingSelect(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
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
            PageEntity<CommodityIfo> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);

            cSI.getStoreAll(pe,sjname);
            req.setAttribute("pageBean", pe);
            uri = "/storecommoditylist.jsp";
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

    //删除功能
    public void delete(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        String deleteID = req.getParameter("id");
        String currPage = req.getParameter("currentPage");
        Integer id = Integer.parseInt(deleteID);
        int cPage = Integer.parseInt(currPage);
        cSI.pageDelete(id);
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=pagingSelect&currentPage=" + cPage).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //添加商品
    public void insert(HttpServletRequest req, HttpServletResponse resp) {
//        int commodityId = Integer.parseInt(req.getParameter("id"));
        String commodityName = req.getParameter("name");
        double commodityPrice = Double.parseDouble(req.getParameter("price"));
        int commodityStock = Integer.parseInt(req.getParameter("stock"));
        int commodityCapacity = Integer.parseInt(req.getParameter("capacity"));
        String imageUrl = req.getParameter("sub_images");
        int commodityYears = Integer.parseInt(req.getParameter("years"));
        double commodityDegree = Double.parseDouble(req.getParameter("degree"));
        String commodityDistributor = (String) req.getSession().getAttribute("sjname");
        CommodityIfo cIfo = new CommodityIfo();
//        cIfo.setCommodityId(commodityId);
        cIfo.setCommodityName(commodityName);
        cIfo.setCommodityPrice(commodityPrice);
        cIfo.setCommodityStock(commodityStock);
        cIfo.setCommodityCapacity(commodityCapacity);
        cIfo.setImageUrl(imageUrl);
        cIfo.setCommodityYears(commodityYears);
        cIfo.setCommodityDegree(commodityDegree);
        cIfo.setCommodityDistributor(commodityDistributor);
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        cSI.pageInsert(cIfo);
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=pagingSelect").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //模糊查询商品信息
    public void fuzzySearch(HttpServletRequest req, HttpServletResponse resp){
        String str = req.getParameter("keywords");
        CommodityServiceImpl cSI = new CommodityServiceImpl();

        String shop = (String) req.getSession().getAttribute("sjname");

        List<CommodityIfo> lCInfo = cSI.fuzzySearch(str,shop);
        System.out.println(lCInfo);
        req.setAttribute("fuzzySInfo",lCInfo);
        try {
            req.getRequestDispatcher("/storefuzzyPage.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteSelect(HttpServletRequest req, HttpServletResponse resp){
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        String[] deleteIDs = req.getParameterValues("check");
        String currPage = req.getParameter("currentPage");
        int cPage = Integer.parseInt(currPage);
        int id= 0;
        if(deleteIDs != null) {
            for (int i = 0; i < deleteIDs.length; i++) {
                id = Integer.valueOf(deleteIDs[i]);
                cSI.pageDelete(id);
            }
        }else {
            String message ="请选择要删除内容";
            req.setAttribute("hintMessage",message);
        }
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=pagingSelect&currentPage=" + cPage).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //跳转修改商品信息页面
    public void updateChange(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        int iD = Integer.parseInt(req.getParameter("id"));
        CommodityIfo ci = cSI.pageSelectById(iD);
        try {
            req.setAttribute("info", ci);
            req.getRequestDispatcher("/storecommodityInformation.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //修改后提交
    public void updateSubmit(HttpServletRequest req, HttpServletResponse resp) {
        int commodityId = Integer.parseInt(req.getParameter("id"));
        String commodityName = req.getParameter("name");
        double commodityPrice = Double.parseDouble(req.getParameter("price"));
        int commodityStock = Integer.parseInt(req.getParameter("stock"));
        int commodityCapacity = Integer.parseInt(req.getParameter("capacity"));
        String imageUrl = req.getParameter("sub_images");
        int commodityYears = Integer.parseInt(req.getParameter("years"));
        double commodityDegree = Double.parseDouble(req.getParameter("degree"));
        String commodityDistributor = (String) req.getSession().getAttribute("sjname");
        int sjsort= Integer.parseInt(req.getParameter("sjsort"));
        CommodityIfo cIfo = new CommodityIfo();
        cIfo.setCommodityId(commodityId);
        cIfo.setCommodityName(commodityName);
        cIfo.setCommodityPrice(commodityPrice);
        cIfo.setCommodityStock(commodityStock);
        cIfo.setCommodityCapacity(commodityCapacity);
        cIfo.setImageUrl(imageUrl);
        cIfo.setCommodityYears(commodityYears);
        cIfo.setCommodityDegree(commodityDegree);
        cIfo.setCommodityDistributor(commodityDistributor);
        cIfo.setSjsort(sjsort);
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        System.out.println(cSI);

        System.out.println(cIfo);
        cSI.pageUpdate(cIfo);
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=pagingSelect").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //商品上下架页面分页展示
    public void productDisply(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        String sjname= (String) req.getSession().getAttribute("sjname");
        String uri;
        try {
            //获取“当前页”参数(第一次访问时当前页为null)
            String currPage = req.getParameter("cPage");
            //判断 第一次设置默认值
            if (currPage == null || "".equals(currPage)) {
                currPage = "1";
            }

            int currentPage = Integer.parseInt(currPage);
            PageEntity<CommodityIfo> pe = new PageEntity<>();
            pe.setCurrentPage(currentPage);
            cSI.getStoreAll(pe,sjname);
            req.setAttribute("page", pe);
            System.out.println(pe);
            uri = "/storecommodityMgr.jsp";
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

    //上架商品信息确认
    public void putGoodsConfirm(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        int iD = Integer.parseInt(req.getParameter("id"));
        CommodityIfo ci = cSI.pageSelectById(iD);
        req.setAttribute("goodsInfo", ci);
        try {
            req.getRequestDispatcher("/storeputGoods.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //确认上架商品信息后提交上架
    public void putGoods(HttpServletRequest req, HttpServletResponse resp) {
        int commodityId = Integer.parseInt(req.getParameter("id"));
        double commodityPrice = Double.parseDouble(req.getParameter("price"));
        int commodityYears = Integer.parseInt(req.getParameter("years"));
        double commodityDegree = Double.parseDouble(req.getParameter("degree"));
        int commodityCapacity = Integer.parseInt(req.getParameter("capacity"));
        String imageUrl = req.getParameter("sub_images");
        String commodityName = req.getParameter("name");
        String commodityDistributor = (String) req.getSession().getAttribute("sjname");
        System.out.println("--------"+commodityDistributor+"------------------------");
        int commodityStock = Integer.parseInt(req.getParameter("stock"));
        int sjsort = Integer.parseInt(req.getParameter("sjsort"));
        CommodityIfo cIfo = new CommodityIfo();
        cIfo.setCommodityId(commodityId);
        cIfo.setCommodityName(commodityName);
        cIfo.setCommodityPrice(commodityPrice);
        cIfo.setCommodityCapacity(commodityCapacity);
        cIfo.setImageUrl(imageUrl);
        cIfo.setCommodityYears(commodityYears);
        cIfo.setCommodityDegree(commodityDegree);
        cIfo.setCommodityDistributor(commodityDistributor);
        cIfo.setSjsort(sjsort);
        cIfo.setCommodityStock(commodityStock);
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        cSI.pageUpdate(cIfo);
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=productDisply").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //商品下架
    public void unShelve(HttpServletRequest req, HttpServletResponse resp) {
        CommodityServiceImpl cSI = new CommodityServiceImpl();
        int iD = Integer.parseInt(req.getParameter("id"));
        CommodityIfo ci = cSI.pageSelectById(iD);
        ci.setSjsort(100);
        cSI.pageUpdate(ci);
        try {
            req.getRequestDispatcher("/store/commodity/handle.do?_method=productDisply").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <%
        String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path;
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>商品上架确认</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/store/commodity/handle.do?_method=putGoods&stock=${requestScope.goodsInfo.commodityStock}&degree=${requestScope.goodsInfo.commodityDegree}&id=${requestScope.goodsInfo.commodityId}">
            <div class="form-group">
                <div class="label">
                    <label>上架顺序：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.sjsort}"
                           name="sjsort"/>
                    <div class="tips"></div>
                </div>
            </div>
<%--            <div class="form-group">--%>
<%--                <div class="label">--%>
<%--                    <label>商家名称：</label>--%>
<%--                </div>--%>
<%--                <div class="field">--%>
<%--                    <input type="text" class="input w50" value="${requestScope.goodsInfo.commodityDistributor}"--%>
<%--                           name="distributor"/>--%>
<%--                    <div class="tips"></div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="form-group">
                <div class="label">
                    <label>酒名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.commodityName}"
                           name="name"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.imageUrl}"
                           name="sub_images"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>酒规格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.commodityCapacity}" name="capacity"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>酒年份：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.commodityYears}" name="years"
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${requestScope.goodsInfo.commodityPrice}" name="price"
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 确认</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>查询结果</title>
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
    <table class="table table-hover text-center">
        <tr>
            <th width="10%" style="text-align:left; padding-left:20px;">订单号</th>
            <th width="20%">商品信息</th>
            <th width="20%">收货地址</th>
            <th width="10%">创建时间</th>
            <th width="20%">操作</th>
        </tr>
        <volist name="list" id="vo">

            <c:forEach var="fuzzyInfo" items="${requestScope.fuzzySInfo}" varStatus="vs">
                <tr>
                    <td>${fuzzyInfo.orderNo}</td>
                    <td>${fuzzyInfo.orderName}</td>
                    <td>${fuzzyInfo.orderAddress}</td>
                    <td>${fuzzyInfo.orderCreatTime}</td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main"
                               href="/order/handle.do?_method=updateChange&id=${fuzzyInfo.orderId}">修改</a>
                            <a class="button border-red"
                               href="/order/handle.do?_method=delete&id=${fuzzyInfo.orderId}"><span
                                    class="icon-trash-o"></span>删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </volist>
    </table>
</div>
</body>
</html>
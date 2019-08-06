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
    <title>修改订单</title>
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
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 修改订单</strong></div>
        <c:if test="${requestScope.info!=null}">
            <form method="post" class="form-x" action="/order/handle.do?_method=updateSubmit&id=${requestScope.info.orderId}">
                <div class="form-group">
                    <div class="label">
                        <label>订单号：</label>
                    </div>
                    <div class="field">
                        <input type="text" readonly="readonly" class="input" name="orderNO" value="${requestScope.info.orderNo}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="userid"
                               value="${requestScope.info.userID}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商品名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name" value="${requestScope.info.orderName}" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>交易总额：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="orderPrice" value="${requestScope.info.orderPrice}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商家名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="distributor" value="${requestScope.info.distributor}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>生成日期：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="creatTime" value="${requestScope.info.orderCreatTime}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>付款状态：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="orderPayState" value="${requestScope.info.orderPayState}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>退货处理状态：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="refund_state" value="${requestScope.info.refund_state}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>确认收货状态：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="receipt_state" value="${requestScope.info.receipt_state}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    </div>
                </div>
            </form>
        </c:if>

    </div>
</div>
</body>
</html>

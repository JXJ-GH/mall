<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 订单列表</strong> <a href="" style="float:right; display:none;">添加字段</a>
			</div>

				<table class="table table-hover text-center">
						<tr>
							<th width="100" style="text-align:left; padding-left:20px;">订单号</th>
							<th>商品名称</th>

							<th>收货地址</th>
							<th>成交金额</th>
							<th width="10%">创建时间</th>
                            <th>订单状态</th>
							<th width="310">操作</th>
						</tr>

					<c:choose>
						<c:when test="${not empty requestScope.pageBean.list }">
							<c:forEach var="order" items="${requestScope.pageBean.list }" varStatus="vs">
								<tr>
									<td style="text-align:left; padding-left:20px;">${order.orderno}</td>
									<td>${order.name}</td>
									<td>${order.address}</td>
									<td>${order.price}</td>
                                    <td>${order.createtime}</td>
                                    <td>${order.refundstate}</td>
									<td>
										<div class="button-group">
											<a class="button border-main"
											   href="/store/order.do?_method=agree&id=${order.id}">同意</a>
											<a class="button border-red"
											   href="/store/order.do?_method=refund&id=${order.id} "><span class="icon-trash-o"></span>退单</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>

						<tr>

							<td colspan="7">
								<div class="pagelist">
									<a href="${pageContext.request.contextPath }/store/order.do?_method=pagingSelect&currentPage=1">首页</a>
									<a href="${pageContext.request.contextPath }/store/order.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage - 1}">上一页</a>
									<a href="${pageContext.request.contextPath }/store/order.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage + 1}">下一页</a>
									<a href="${pageContext.request.contextPath }/store/order.do?_method=pagingSelect&currentPage=${requestScope.pageBean.totalPage}">尾页</a>
								</div>
							</td>

						</tr>
				</table>

			</div>
		</form>

	</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
<form method="post" action="/order/handle.do?_method=fuzzySearch">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 订单列表</strong></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <input type="submit" value="搜索" class="button border-green icon-trash-o"/>
                </li>
            </ul>
        </div>
    </div>
</form>
<form>
    <div>
        <table class=" table table-hover text-center">
            <tr>
                <th width="10%" style="text-align:left; padding-left:20px;">订单号</th>
                <th width="10%">用户名</th>
                <th width="20%">商品信息</th>
                <th width="20%">收货地址</th>
                <th width="10%">创建时间</th>
                <th width="20%">操作</th>
            </tr>
            <volist name="list" id="vo">
                <c:choose>
                    <c:when test="${not empty requestScope.orderpage.list}">
                        <c:forEach var="order" items="${requestScope.orderpage.list}" varStatus="vs">
                            <tr>
                                <td>${order.orderNo}</td>
                                <td>${order.userID}</td>
                                <td>${order.orderName}</td>
                                <td>${order.orderAddress}</td>
                                <td>${order.orderCreatTime}</td>
                                <td>
                                    <div class="button-group">
                                        <a class="button border-main"
                                           href="/order/handle.do?_method=updateChange&id=${order.orderId}">修改</a>
                                        <a class="button border-red"
                                           href="/order/handle.do?_method=delete&id=${order.orderId}&currentPage=${requestScope.orderpage.currentPage}"><span
                                                class="icon-trash-o"></span>删除</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>
                <tr>
                    <td colspan="8">
                        <div class="pagelist">
                            <a href="${pageContext.request.contextPath }/order/handle.do?_method=pagingSelect&currentPage=1">首页</a>
                            <a href="${pageContext.request.contextPath }/order/handle.do?_method=pagingSelect&currentPage=${requestScope.orderpage.currentPage - 1}">上一页</a>
                            <a href="${pageContext.request.contextPath }/order/handle.do?_method=pagingSelect&currentPage=${requestScope.orderpage.currentPage + 1}">下一页</a>
                            <a href="${pageContext.request.contextPath }/order/handle.do?_method=pagingSelect&currentPage=${requestScope.orderpage.totalPage}">尾页</a>
                        </div>
                    </td>
                </tr>

            </volist>
        </table>
    </div>
</form>
<script type="text/javascript">
    //全选
    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
            $("#listform").submit();
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {


            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var i = 0;
            $("input[name='id[]']").each(function () {
                if (this.checked == true) {
                    i++;
                }
            });
            if (i > 1) {
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected", "selected");
            } else {

                $("#listform").submit();
            }
        } else {
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected", "selected");
            return false;
        }
    }
</script>
</body>
</html>

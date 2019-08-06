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

<%--    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/admin.css' />--%>
<%--    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/pintuer.css' />--%>
<%--    <script src='${pageContext.request.contextPath }/js/jquery.js'type='text/javascript'></script>--%>
<%--    <script src='${pageContext.request.contextPath }/js/pintuer.js'type='text/javascript'></script>--%>
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
<form method="post" action="/commodity/handle.do?_method=fuzzySearch" >
    <div class="panel admin-panel">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li><a class="button border-main icon-plus-square-o" href="/commodityInformation.jsp"> 添加内容</a></li>
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <input type="submit" value="搜索" class="button border-green icon-trash-o `"/>
                </li>
            </ul>
        </div>
    </div>
</form>
<form method="post" action="/commodity/handle.do?&_method=deleteSelect&currentPage=${requestScope.pageBean.currentPage}" id="listform">
    <table class="table table-hover text-center" width="100%">
        <tr>
            <th width="10%" >商品名称</th>
            <th width="20%" >商品图</th>
            <th width="10%" >商品规格(ml)</th>
            <th width="10%" >商品单价</th>
            <th width="10%" >库存</th>
            <th width="20%" >商家</th>
            <th >操作</th>
        </tr>
        <volist name="list" id="vo">
            <c:choose>
                <c:when test="${not empty requestScope.pageBean.list }">
                    <c:forEach var="commodity" items="${requestScope.pageBean.list }" varStatus="vs">
                        <tr>
                            <td style="text-align:left; padding-left:20px;">
                                <input type="checkbox" name="check" value="${commodity.commodityId}"/>
                                    ${commodity.commodityName}</td>
                            <td width="10%"><img src="${commodity.imageUrl}" alt="" width="70" height="50"/></td>
                            <td >${commodity.commodityCapacity}</td>
                            <td>${commodity.commodityPrice}</td>
                            <td>${commodity.commodityStock}</td>
                            <td>${commodity.commodityDistributor}</td>
                            <td>
                                <div class="button-group">
                                    <a class="button border-main"
                                       href="/commodity/handle.do?_method=updateChange&id=${commodity.commodityId}">修改</a>
                                    <a class="button border-red"
                                       href="/commodity/handle.do?_method=delete&id=${commodity.commodityId}&currentPage=${requestScope.pageBean.currentPage}"
                                       onclick="return del(1,1,1)"><span class="icon-trash-o"></span>删除</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
            <tr>
                <td colspan="8">
                    <div class="pagelist">
                        <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=pagingSelect&currentPage=1">首页</a>
                        <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage - 1}">上一页</a>
                        <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage + 1}">下一页</a>
                        <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=pagingSelect&currentPage=${requestScope.pageBean.totalPage}">尾页</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="all"/>全选
                </td>
                <td><input class="button border-main icon-search" type="button" id="uncheck" value="反选"/></td>
                <td colspan="6" style="text-align:left;padding-left:20px;">
                    <input class="button border-red icon-trash-o" type="submit" onclick="DelSelect()" value="删除所选">
                </td>
            </tr>
        </volist>
    </table>
</form>
<script type="text/javascript">
    window.onload = function () {
        var all = document.getElementById("all");
        var checks = document.getElementsByName("check");
        for (var i = 0; i < checks.length; i++) {
            checks[i].onclick = function () {
                for (var i = 0; i < checks.length; i++) {
                    if (!checks[i].checked) {
                        all.checked = false;
                        break;
                    } else {
                        all.checked = true;
                    }
                }
            }
        }
        //全选
        all.onclick = function () {
            for (var i = 0; i < checks.length; i++) {
                var ch = all.checked;
                checks[i].checked = ch;
            }
        }
        //反选
        var uncheck = document.getElementById("uncheck");
        uncheck.onclick = function () {
            for (var i = 0; i < checks.length; i++) {
                checks[i].checked = !checks[i].checked;
            }
        }
    }
    //搜索
    function changesearch() {
    }
    //单个删除
    function del(id, mid, iscid) {
        if (confirm("您确定要删除吗?")) {
        }
    }
    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='check']").each(function () {
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
</script>

</body>
</html>
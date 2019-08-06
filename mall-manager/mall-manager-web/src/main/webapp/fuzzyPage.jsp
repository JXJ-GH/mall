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
<%--    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/admin.css' />--%>
<%--    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/pintuer.css' />--%>
<%--    <script src='${pageContext.request.contextPath }/js/jquery.js'  type='text/javascript'></script>--%>
<%--    <script src='${pageContext.request.contextPath }/js/pintuer.js'  type='text/javascript'></script>--%>
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
        <table class="table table-hover text-center">
            <tr>
                <th width="10%">商品名称</th>
                <th width="20%">商品图</th>
                <th width="10%">商品规格(ml)</th>
                <th width="10%">商品单价</th>
                <th width="20%">商家</th>
                <th width="10%">库存</th>
                <th width="200">操作</th>
            </tr>
            <volist name="list" id="vo">
                        <c:forEach var="fuzzyInfo" items="${requestScope.fuzzySInfo}">
                            <tr>
                                <td style="text-align:left; padding-left:20px;">
                                    <input type="checkbox" name="check" value="${fuzzyInfo.commodityId}"/>
                                        ${fuzzyInfo.commodityName}</td>
                                <td width="10%"><img src="${fuzzyInfo.imageUrl}" alt="" width="70" height="50"/></td>
                                <td>${fuzzyInfo.commodityCapacity}</td>
                                <td>${fuzzyInfo.commodityPrice}</td>
                                <td>${fuzzyInfo.commodityDistributor}</td>
                                <td>${fuzzyInfo.commodityStock}</td>
                                <td>
                                    <div class="button-group">
                                        <a class="button border-main"
                                           href="/commodity/handle.do?_method=updateChange&id=${fuzzyInfo.commodityId}">修改</a>
                                        <a class="button border-red"
                                           href="/commodity/handle.do?_method=delete&id=${fuzzyInfo.commodityId}"
                                           onclick="return del(1,1,1)"><span class="icon-trash-o"></span>删除</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
            </volist>
        </table>
    </div>
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
</script>

</body>
</html>
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
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <a href="/commodity/handle.do?_method=fuzzySearch" class="button border-main icon-search"  onclick="changesearch()"> 搜索</a>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">展示序列</th>
                <th>商家</th>
                <th>酒名</th>
                <th>商品单价</th>
                <th>图片</th>
                <th width="310">操作</th>
            </tr>
            <volist name="list" id="vo">
                <c:choose>
                <c:when test="${not empty requestScope.page.list}">

                <c:forEach var="product" items="${requestScope.page.list }" varStatus="vs">
                <tr>
                    <td style="text-align:left; padding-left:20px;">
                        <input type="checkbox" name="check" value="${product.commodityId}"/>
                            ${product.commoditySort}</td>
                    <td>${product.commodityDistributor}</td>
                    <td>${product.commodityName}</td>
                    <td>${product.commodityPrice}</td>
                    <td width="10%"><img src="${product.imageUrl}" alt="" width="70" height="50"/></td>
                    <td>
                        <div class="button-group">
                            <c:if test="${product.commoditySort >=9}">
                                <a class="button border-green" href="/commodity/handle.do?_method=putGoodsConfirm&id=${product.commodityId}">
                                    <span class="icon-align-justify"></span>上架
                                </a>
                            </c:if>
                            <c:if test="${product.commoditySort <9}">
                                <a class="button border-red" href="/commodity/handle.do?_method=unShelve&id=${product.commodityId}">
                                    <span class="icon-align-justify"></span>下架
                                </a>
                            </c:if>

                        </div>
                    </td>
                </tr>
                </c:forEach>
                </c:when>
                </c:choose>
                <tr>
                    <td colspan="8">
                        <div class="pagelist">
                            <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=productDisply&cPage=1">首页</a>
                            <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=productDisply&cPage=${requestScope.page.currentPage - 1}">上一页</a>
                            <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=productDisply&cPage=${requestScope.page.currentPage + 1}">下一页</a>
                            <a href="${pageContext.request.contextPath }/commodity/handle.do?_method=productDisply&cPage=${requestScope.page.totalPage}">尾页</a>
                        </div>
                    </td>
                </tr>


        </table>
    </div>
</form>
<script type="text/javascript">
    //搜索
    function changesearch() {

    }

    //单个删除
    function del(id, mid, iscid) {
        if (confirm("您确定要下架吗?")) {

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

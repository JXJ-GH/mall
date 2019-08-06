
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>忘忧酒家后台</title>


    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/admin.css' />
    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/pintuer.css' />
    <script src='${pageContext.request.contextPath }/js/jquery.js'  type='text/javascript'></script>
    <script src='${pageContext.request.contextPath }/js/pintuer.js'  type='text/javascript'></script>
<%--    <link rel="stylesheet" href="css/pintuer.css">--%>
<%--    <link rel="stylesheet" href="css/admin.css">--%>
<%--    <script src="js/jquery.js"></script>--%>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" title="欢迎您:${sessionScope.userName}" />忘忧酒家后台</h1>
    </div>
    <div class="head-l">
        <a class="button button-little bg-red" href="index.jsp"><span class="icon-power-off"></span>退出登录</a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-pencil-square-o"></span>商品信息</h2>
    <ul>
        <li><a href="/commodity/handle.do?_method=pagingSelect" target="right"><span class="icon-caret-right"></span>商品列表</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>订单管理</h2>
    <ul>
        <li><a href="/order/handle.do?_method=pagingSelect" target="right"><span class="icon-caret-right"></span>订单列表</a></li>
    </ul>
    <h2><span class="icon-user"></span>用户管理</h2>
    <ul>
        <%--				<li><a href="/userlist.do" target="right"><span class="icon-caret-right"></span>用户列表</a></li>--%>
        <li><a href="/userlist.do?_method=pagingSelect" target="right"><span class="icon-caret-right"></span>用户列表</a></li>

    </ul>
    <h2><span class="icon-user"></span>商家管理</h2>
    <!-- style="display:block" -->
    <ul>
        <li><a href="/sjlist.do?_method=pagingSelect" target="right"><span class="icon-caret-right"></span>店铺信息</a>
        </li>
        <li><a href="/sjlist.do?_method=paging" target="right"><span class="icon-caret-right"></span>店铺审核</a>
        </li>
    </ul>
    <h2><a><span class="icon-pencil-square-o"></span>首页商品</a></h2>
    <ul>
        <li></span><a href=/commodity/handle.do?_method=productDisply target="right"><span class="icon-caret-right"></span>商品上下架</a>
        </li>
    </ul>
</div>
<script type="text/javascript">
    $(function() {
        $(".leftnav h2").click(function() {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function() {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="mainindex.jsp" target="_self" class="icon-home"> 首页</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>

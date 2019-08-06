<%--
  Created by IntelliJ IDEA.
  User: 晓杰
  Date: 2019/7/27
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 晓杰
  Date: 2019/7/27
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
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
    <title>添加用户</title>
    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/admin.css' />
    <link rel='Stylesheet' href='${pageContext.request.contextPath }/css/pintuer.css' />
    <script src='${pageContext.request.contextPath }/js/jquery.js'  type='text/javascript'></script>
    <script src='${pageContext.request.contextPath }/js/pintuer.js'  type='text/javascript'></script>
    <%--    <link rel="stylesheet" href="css/pintuer.css">--%>
    <%--    <link rel="stylesheet" href="css/admin.css">--%>
    <%--    <script src="js/jquery.js"></script>--%>
    <%--    <script src="js/pintuer.js"></script>--%>
</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>商家申请</strong></div>
    <div class="body-content">
            <form method="post" class="form-x" action="/sj.do?_method=change&id=${requestScope.sj.id}">

                <div class="form-group">
                    <div class="label">
                        <label>商家名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name" value="${requestScope.sj.sjname}"/>
                    </div>
                </div>
                <div class="form-group" >
                    <div class="label">
                        <label>负责人：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="id" value="${requestScope.sj.frname}"/>
                        <div class="tips"></div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label> 法人年龄：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="stock" value="${requestScope.sj.frage}" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>法人证件号：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="sub_images" value="${requestScope.sj.frbirnum}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商家联系方式：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="distributor" value="${requestScope.sj.sjphone}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>商家地址：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="degree" value="${requestScope.sj.sjdz}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">同意</button>
                        <button class="button bg-main icon-check-square-o" type="button"><a href="/sjlist.do?_method=paging">返回</a> </button>
                    </div>
                </div>
            </form>

    </div>
</div>
</body>
</html>

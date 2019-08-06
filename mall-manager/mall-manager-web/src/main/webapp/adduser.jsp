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
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加用户</strong></div>
    <div class="body-content">
        <c:if test="${requestScope.user==null}">
            <form method="post" class="form-x" action="/user.do?_method=save">

                <div class="form-group">
                    <div class="label">
                        <label>用户昵称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name" value=""/>
                    </div>
                </div>
                <div class="form-group" >
                    <div class="label">
                        <label>用户真实姓名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="id" value=""/>
                        <div class="tips"></div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label> 用户生日：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="stock" value="" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户性别：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="sub_images" value=""/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>用户密码：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="distributor" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户邮箱：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="degree" value=""/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户联系方式：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="capacity" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                        <button class="button bg-main icon-check-square-o" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${requestScope.user!=null}">
            <form method="post" class="form-x" action="/user.do?_method=modify&id=${requestScope.user.id}">
                <div class="form-group">
                    <div class="label">
                        <label>用户昵称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="username" value="${requestScope.user.username}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户真实姓名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="truename"
                               value="${requestScope.user.truename}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>用户生日：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="birthday" value="${requestScope.user.birthday}" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户性别：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="sex" value="${requestScope.user.sex}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>用户密码：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="password" value="${requestScope.user.password}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户邮箱：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="email" value="${requestScope.user.email}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>用户联系方式：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="phone" value="${requestScope.user.phone}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                        <button class="button bg-main icon-check-square-o" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </c:if>

    </div>
</div>
</body>
</html>

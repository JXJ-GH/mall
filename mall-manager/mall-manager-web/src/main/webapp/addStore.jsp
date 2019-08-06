<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>商家信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<%--<%--%>
<%--    //  List<User> userList = (List<User>) request.getAttribute("userList");--%>
<%--    SJ sj = (SJ) request.getAttribute("sj");--%>
<%--%>--%>

<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 商家信息</strong></div>
  <div class="body-content">
<%--      <%--%>
<%--          if(sj ==null){--%>
<%--      %>--%>
    <c:if test="${empty(requestScope.sj)}">
    <form method="post" class="form-x" action="/sj.do?_method=save">

        <div class="form-group">
            <div class="label">
                <label>商家名称：</label>
            </div>
            <div class="field">
                <input type="text"  style="width:25%; float:left;" class="input" name="sjname" value="" />
                <div class="tips"></div>
            </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label>商家密码：</label>
        </div>
        <div class="field">
          <input type="password"  style="width:25%; float:left;" class="input" name="sjpassword" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>负责人：</label>
        </div>
        <div class="field">
            <input type="text"  style="width:25%; float:left;" class="input" name="frname" value="" />
        </div>
      </div>
        <div class="form-group">
        <div class="label">
            <label>法人年龄：</label>
        </div>
        <div class="field">
            <input type="text"  style="width:25%; float:left;" class="input" name="frage" value="" />
            <div class="tips"></div>
        </div>
    </div>
        <div class="form-group">
            <div class="label">
                <label>法人证件号：</label>
            </div>
            <div class="field">
                <input type="text"  style="width:25%; float:left;" class="input" name="frbirnum" value="" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>商家联系方式：</label>
            </div>
            <div class="field">
                <input type="text"  style="width:25%; float:left;" class="input" name="sjphone" value="" />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>商家地址：</label>
            </div>
            <div class="field">
                <input type="text"  style="width:25%; float:left;" class="input" name="sjdz" value="" />
                <div class="tips"></div>
            </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 保存</button>
        </div>
      </div>
    </form>
    </c:if>
    <c:if test="${!empty(requestScope.sj)}">
      <form method="post" class="form-x" action="/sj.do?_method=modify&id=${requestScope.sj.id}&sjpassword=${requestScope.sj.sjpassword}">

          <div class="form-group">
              <div class="label">
                  <label>商家名称：</label>
              </div>
              <div class="field">
                  <input type="text"  style="width:25%; float:left;" class="input" name="sjname" value="${requestScope.sj.sjname}" />
                  <div class="tips"></div>
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label>负责人：</label>
              </div>
              <div class="field">
                  <input type="text"  name="frname" class="input tips" style="width:25%; float:left;" value="${requestScope.sj.frname}"  />
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label>法人年龄：</label>
              </div>
              <div class="field">
                  <input type="text"  style="width:25%; float:left;" class="input" name="frage" value="${requestScope.sj.frage}" />
                  <div class="tips"></div>
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label>法人证件号：</label>
              </div>
              <div class="field">
                  <input type="text"  style="width:25%; float:left;" class="input" name="frbirnum" value="${requestScope.sj.frbirnum}" />
                  <div class="tips"></div>
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label>商家联系方式：</label>
              </div>
              <div class="field">
                  <input type="text"  style="width:25%; float:left;" class="input" name="sjphone" value="${requestScope.sj.sjphone}" />
                  <div class="tips"></div>
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label>商家地址：</label>
              </div>
              <div class="field">
                  <input type="text"  style="width:25%; float:left;" class="input" name="sjdz" value="${requestScope.sj.sjdz}" />
                  <div class="tips"></div>
              </div>
          </div>
          <div class="form-group">
              <div class="label">
                  <label></label>
              </div>
              <div class="field">
                  <button class="button bg-main icon-check-square-o" type="submit"> 确认</button>
              </div>
          </div>
      </form>
<%--      <%--%>
<%--          }--%>
<%--      %>--%>
    </c:if>

  </div>
</div>
</body>
</html>
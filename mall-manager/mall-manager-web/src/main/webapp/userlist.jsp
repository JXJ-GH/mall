
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">
        window.onload= function(){
            var all = document.getElementById("all");
            var checks =document.getElementsByName("check");
            for(var i = 0 ; i < checks.length;i++){
                checks[i].onclick=function(){

                    for(var i = 0 ; i < checks.length;i++){
                        if(!checks[i].checked){
                            all.checked = false;
                            break;
                        }else{
                            all.checked = true;
                        }
                    }

                }
            }
            //全选
            all.onclick = function(){
                for(var i = 0 ; i < checks.length;i++){
                    var ch = all.checked;
                    checks[i].checked = ch;
                }
            }

            //反选
            var uncheck = document.getElementById("uncheck");
            uncheck.onclick=function(){
                for(var i = 0 ; i < checks.length;i++){

                    checks[i].checked = !checks[i].checked;
                }
            }
        }

    </script>
</head>
<body>
<%--<%--%>
<%--    List<User> userList = (List<User>)request.getAttribute("userList");--%>
<%--%>--%>

<%--<form method="post" action="/Searh.do" id="listform">--%>
<div class="panel admin-panel">
<form method="post" action="/user.do?_method=search" id="listform1">

        <div class="panel-head">
            <strong class="icon-reorder">用户列表</strong>

        </div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    <a class="button border-main icon-plus-square-o" href="adduser.jsp">添加用户</a>
                </li>
                <li>

<%--                    <input type="search" name="searchwords"  />--%>

                    <input type="text" placeholder="请输入用户ID" name="searchwords" class="input" style="width:250px; line-height:17px;display:inline-block" />

                    <input class="button border-main icon-search" type="submit" value="搜索">

                </li>
            </ul>
        </div>
</form>

        <form method="post" action="/user.do?_method=deletes" id="listform2">
        <table class="table table-hover text-center">
            <thead>
            <tr>
                <th>用户昵称</th>
                <th>用户真实姓名</th>
                <th>用户性别</th>
                <th>用户生日</th>
                <th>用户联系方式</th>
                <th>用户邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty requestScope.pageBean.list }">
                        <c:forEach var="user" items="${requestScope.pageBean.list }" varStatus="vs">
                            <tr>
                                <td style="text-align:left; padding-left:20px;width: 15%"><input type="checkbox" name="check" value="${user.id}"/>${user.username}</td>
                                <td>${user.truename}</td>
                                <td>${user.sex}</td>
                                <td>${user.birthday}</td>
                                <td>${user.phone}</td>
                                <td>${user.email}</td>
                                <td>
                                    <div class="button-group">
                                         <a class="button border-main" href="/user.do?_method=update&id=${user.id}"><span class="icon-edit"></span> 修改</a>
                                         <a class="button border-red" href="/user.do?_method=delete&id=${user.id}" onclick="return del(1,1,1)"><span class="icon-trash-o"></span>删除</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                </c:choose>

            <tr>
                <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="all" />全选 </td>
                <td><input class="button border-main icon-search" type="button" id="uncheck" value="反选"/></td>
                <td colspan="6" style="text-align:left;padding-left:20px;">
<%--                    <a href="/deletepart.do" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除所选</a>--%>
<%--                    <a href="/sd.do?_method=delete" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除所选</a>--%>
                    <input class="button border-main icon-search" type="submit" onclick="DelSelect()" value="删除所选">
                </td>
            </tr>
            <tr>
<%--                <td colspan="8">--%>
<%--                    <div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a--%>
<%--                            href="">尾页</a> </div>--%>
<%--                </td>--%>
    <td colspan="8">
        <div class="pagelist">
            <a href="${pageContext.request.contextPath }/userlist.do?_method=pagingSelect&currentPage=1">首页</a>
            <a href="${pageContext.request.contextPath }/userlist.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage - 1}">上一页</a>
            <a href="${pageContext.request.contextPath }/userlist.do?_method=pagingSelect&currentPage=${requestScope.pageBean.currentPage + 1}">下一页</a>
            <a href="${pageContext.request.contextPath }/userlist.do?_method=pagingSelect&currentPage=${requestScope.pageBean.totalPage}">尾页</a>
        </div>
    </td>
            </tr>
            </tbody>
        </table>

</form>
</div>
<script type="text/javascript">
    //单个删除
    function del(id, mid, iscid) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='check']").each(function() {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false){
                return false;
            }else{
                $("input[name='check']").each(function() {
                    var d = this.value;
                    if (this.checked == true){

                    }
                });
            }


            $("#listform").submit();
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }



</script>
</body>
</html>

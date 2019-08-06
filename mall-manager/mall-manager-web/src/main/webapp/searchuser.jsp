


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

</head>
<body>
<%--<%--%>
<%--    User user = (User) request.getAttribute("user");--%>
<%--%>--%>

<form method="post" action="/user.do?_method=search" id="listform1">

    <div class="panel-head">
        <strong class="icon-reorder">用户列表</strong>

    </div>
    <div class="padding border-bottom">
        <ul class="search" style="padding-left:10px;">
            <li>
                <a class="button border-main icon-plus-square-o" href="adduser.jsp"> 添加用户</a>
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
                <th width="100" style="text-align:left; padding-left:20px;">用户昵称</th>
                <th>用户真实姓名</th>
                <th>用户性别</th>
                <th>用户生日</th>
                <th>用户联系方式</th>
                <th>用户邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>

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

            </tbody>
        </table>

</form>
<script type="text/javascript">
    //单个搜索
    function Search() {
        $("#listform").submit();

    }




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



















































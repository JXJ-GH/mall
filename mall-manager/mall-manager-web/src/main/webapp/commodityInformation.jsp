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
    <title>添加商品</title>
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
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 商品信息</strong></div>
    <div class="body-content">
        <c:if test="${requestScope.info==null}">

            <form method="post" class="form-x" action="/commodity/handle.do?_method=insert">

                <div class="form-group">
                    <div class="label">
                        <label>商品名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>商品库存：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="stock" value="" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图像url：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="sub_images" value=""/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>供应商家：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="distributor" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>度数：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="degree" value=""/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>容量：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="capacity" value=""/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商品年份：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="years" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>商品价格：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="price" value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    </div>
                </div>
            </form>
        </c:if>
        <c:if test="${requestScope.info!=null}">
            <form method="post" class="form-x" action="/commodity/handle.do?_method=updateSubmit">
                <div class="form-group">
                    <div class="label">
                        <label>商品ID：</label>
                    </div>
                    <div class="field">
                        <input type="text" readonly="readonly" class="input" name="id" value="${requestScope.info.commodityId}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>商品名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="name"
                               value="${requestScope.info.commodityName}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商品库存：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="stock" value="${requestScope.info.commodityStock}" }/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图像url：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="sub_images" value="${requestScope.info.imageUrl}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>供应商家：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="distributor" value="${requestScope.info.commodityDistributor}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>度数：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="degree" value="${requestScope.info.commodityDegree}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>容量：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="capacity" value="${requestScope.info.commodityCapacity}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="label">
                        <label>商品年份：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="years" value="${requestScope.info.commodityYears}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>商品价格：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input" name="price" value="${requestScope.info.commodityPrice}"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    </div>
                </div>
            </form>
        </c:if>

    </div>
</div>
</body>
</html>

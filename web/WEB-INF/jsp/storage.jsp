<%--
  Created by IntelliJ IDEA.
  User: Eve-赵雅娟
  Date: 2018/5/7 0007
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ERP商品入库</title>
    <link rel="stylesheet" type="text/css" href="statics/css/index.css"/>
</head>

<body>

<div class="container">
     <div style="color:#ff0000; display: none" class="addok">保存成功！</div>
    <input type="hidden" value="${pageContext.request.contextPath }" id="path">
    <%--<%@ include file="list.jsp"%>--%>
    <div class="left"  style="height:500px;">

    </div>
    <div class="right">
        <div style="border-bottom:1px solid #ccc; height:50px; line-height:50px;">
            商品入库
        </div>
        <table  border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td>入库编号</td>
                <td><input type="text"  class="warehouseNo" value=""/></td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td><input type="text" class="commodityName" /><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>供应商</td>
                <td><input type="text"  class="supplier"/><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>商品规格</td>
                <td><input type="text"  class="specifications"/><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>商品规格单位</td>
                <td><input type="text"  class="specificationUnit"/><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>数量</td>
                <td><input type="text" class="number" /><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>计量单位</td>
                <td>
                    <select class="Unit">
                        <option value="包">包</option>
                        <option value="箱">箱</option>
                        <option value="件">件</option>
                        <option value="个">个</option>
                        <option value="瓶">瓶</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>单价</td>
                <td><input type="text"  class="price"/><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>入库日期</td>
                <td><input type="text"  class="storagDate"/><span style="color: red;font-size: 12px"></span></td>
            </tr>
            <tr>
                <td>备注</td>
                <td> <textarea rows="5" cols="28" class="remarks"></textarea></td>
            </tr>


        </table>
        <div style="border-top:1px solid #ccc; height:50px; line-height:50px;">
            <input type="button" value="保存" style="margin-top:14px;" />
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="statics/js/my.js"></script>
</html>
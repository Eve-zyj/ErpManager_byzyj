<%--
  Created by IntelliJ IDEA.
  User: Eve-赵雅娟
  Date: 2018/5/7 0007
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table border="1" cellspacing="0" cellpadding="0" class="list">
        <tr>
            <td colspan="2">商品信息</td>
        </tr>
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
        </tr>
        <tbody id="tbody">
        <c:if test="${! empty page.list and totalCount!=0}">
            <c:forEach items="${page.list}" var="storage">
                <tr class="view" warehouseNo = "${storage.warehouseNo}">
                    <td>${storage.warehouseNo}</td>
                    <td >${storage.commodityName}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
        <c:if test="${empty page.list or totalCount==0}">
            <tr>
                <td colspan="2" style="color: red">暂无商品信息记录</td>
            </tr>
        </c:if>
        <%--<tr>
            <td>TY000019</td>
            <td >矿泉水</td>
        </tr>--%>
    </table>
<c:if test="${! empty page.list and pageCount!=0}">
    <div class="page"><a href="javascript:;" pageIndex="1">首页</a>
        <c:if test="${page.pageIndex>1}">
            <a href="javascript:;" pageIndex="${page.pageIndex-1}" >上一页</a>
        </c:if>
        <c:forEach begin="1" end="${page.pageCount}" varStatus="statu">
            <a href="javascript:;" pageIndex="${statu.count}">${statu.count}</a>
        </c:forEach>
        <c:if test="${page.pageIndex<page.pageCount}">
            <a href="javascript:;" pageIndex="${page.pageIndex+1}">下一页</a>
        </c:if>
        <a href="javascript:;" pageIndex="${page.pageCount}">末页</a></div>
</c:if>


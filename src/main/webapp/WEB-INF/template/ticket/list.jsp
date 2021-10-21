<%@ page import="jee.ticket.domain.Ticket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>中山领航科技有限公司客服系统</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>
<h3>票据</h3>
<c:if test="${loginUser.role=='ROLE_USER'}">
<a href="/ticket?action=create">添加新票据</a><br/><br/>
</c:if>
<hr>
<table border="1" cellspacing="0">
    <tr>
        <th>序號</th>
        <th>票据Id</th>
        <th>企业名</th>
        <th>总金额</th>
        <th>主题</th>
        <th>类型</th>
        <th>提交时间</th>
        <th>主要内容</th>
        <th>提交者</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${ticketList}" var="ticket" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${ticket.id}</td>
            <td>${ticket.companyName}</td>
            <td>${ticket.money}</td>
            <td>${ticket.subject}</td>
            <td>${ticket.type}</td>
            <td>${ticket.submitDate}</td>
            <td>${ticket.body}</td>
            <td>${ticket.submitter}</td>
            <td>
                <c:if test="${loginUser.role=='ROLE_ADMIN'}">
                    <a href="/ticket?action=view&id=${ticket.id}">详情</a>
                    <a href="/ticket?action=audit&id=${ticket.id}">审核</a>
                </c:if>
                <c:if test="${loginUser.role=='ROLE_USER'}">
                    <a href="/ticket?action=view&id=${ticket.id}">详情</a>
                    <a href="/ticket?action=del&id=${ticket.id}">删除</a>
                    <a href="/ticket?action=edit&id=${ticket.id}">编辑</a>
                </c:if>

            </td>

        </tr>
    </c:forEach>
</table>
<%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>

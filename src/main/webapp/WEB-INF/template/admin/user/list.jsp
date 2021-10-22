<%@ page import="jee.ticket.domain.Ticket" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>中山领航科技有限公司客服系统</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>
<h2>用户列表</h2>
<a href="/admin/user?action=create">添加新用户</a><br/><br/>
<table border="1" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>Email</th>
        <th>注册时间</th>
        <th>注册IP</th>
        <th>角色</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="s" >
        <tr>
            <td>${s.count}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.createDate}</td>
            <td>${user.registerIp}</td>
            <td>${user.role eq "ROLE-ADMIN" ? "管理员": "普通用户" }</td>
            <td>${user.status eq 1 ? "激活": "未激活" }</td>
            <td>
                <a href="/admin/user?action=view&id=${user.id}">详情</a>
                <a href="/admin/user?action=edit&id=${user.id}">编辑</a>
                <a href="/admin/user?action=frozen&id=${user.id}">冻结</a>
                <a href="/admin/user?action=active&id=${user.id}">激活</a>
                <a href="/admin/user?action=del&id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>


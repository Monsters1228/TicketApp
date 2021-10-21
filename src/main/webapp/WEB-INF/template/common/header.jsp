<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<span style="font-size: 36px; font-weight: bold">中山领航公司票据管理系统
</span><span>当前用户:${loginUser.username};</span>
<a href="/logout">注销</a>
<p>
<ul>
    <%--根据不同角色现实不同菜单--%>
    <c:if test="${loginUser.role=='ROLE_ADMIN'}">
        <li><a href="/admin/user">用户管理</a></li>
        <li><a href="/ticket">票据管理</a></li>
    </c:if>

    <c:if test="${loginUser.role=='ROLE_USER'}">
        <li>
            <a href="/u">个人信息</a>
        </li>
        <li><a href="/ticket">票据中心</a></li>
    </c:if>
</ul>
<hr>
</body>
</html>

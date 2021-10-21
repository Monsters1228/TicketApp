<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户中心</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>

<i>用户ID:${sessionScope.loginUser.id}</i><br/><br/>
<i><strong>用户名:</strong> ${sessionScope.loginUser.username}</i>
<p><strong>密码:</strong> ${sessionScope.loginUser.password}
<p>
<p><strong>电子邮箱:</strong>  ${sessionScope.loginUser.email}<p>
<p><strong>注册IP:</strong>  ${loginUser.registerIp}<p>
<b><strong>注册时间:</strong> ${loginUser.createDate}<br/><br/>
<p><strong>状态:</strong>  ${loginUser.status}<p>
<p><strong>角色:</strong>  ${loginUser.role}<p>

        <a href="#">修改个人信息</a>
    <%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>
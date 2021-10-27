<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${user.username}</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>
<i>用户ID #${userId}: ${user.id}</i><br/><br/>
<i><strong>用户名:</strong> ${user.username}</i>

<p><strong>密码:</strong> ${user.password}
<p>

        <a href="/admin/user">返回用户列表 </a><br/>
    <a href="/admin/user?action=edit&id=${user.id}">编辑用户信息</a>
    <%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>
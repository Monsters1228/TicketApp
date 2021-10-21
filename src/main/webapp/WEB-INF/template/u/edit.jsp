<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑个人信息</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<form method="POST" action="/lab06/user?action=update">
    <h2>编辑个人信息</h2>

    用户名<br/>
    <input type="text" name="username" value="${user.username}" readonly><br/><br/>
    密码<br/>
    <input type="password" name="password" value="${user.password}}"><br/><br/>
    Email地址<br/>
    <input type="text" name="email" value="${user.email}"><br/><br/>
    <br/><br/>
    <input type="submit" value="更新"/>
</form>
<%@include file="/WEB-INF/template/common/footer.jsp" %>.
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 27606
  Date: 2021/10/22
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 27606
  Date: 2021/10/22
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<form method="POST" action="/admin/user?action=register">
    <h2>注册</h2>

    用户名<br/>
    <input type="text" name="username" value="${user.username}" readonly><br/><br/>
    密码<br/>
    <input type="password" name="password" value="${user.password}"><br/><br/>
    Email地址<br/>
    <input type="text" name="email" value="${user.email}"><br/><br/>
    <br/><br/>
    <input type="submit" value="更新"/>
</form>
<%@include file="/WEB-INF/template/common/footer.jsp" %>.
</body>
</html>

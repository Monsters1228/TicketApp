<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>
<form method="POST" action="/admin/user?action=create">
    <h2>添加新用户</h2>
    用户名<br/>
    <input type="text" name="" value="Tracker"><br/><br/>
    密码<br/>
    <input type="password" name="" value="123"><br/><br/>

    Email地址<br/>
    <input type="text" name="" value="trace@hotmail.com"><br/><br/>
    类型<br/>
    <select  name="">
        <option value="ROLE_USER">普通用户</option>
        <option value="ROLE_ADMIN">管理员</option>
    </select>

    <br/><br/>
    <input type="submit" value="提交"/>
</form>
<%@include file="/WEB-INF/template/common/footer.jsp"%>
</body>
</html>

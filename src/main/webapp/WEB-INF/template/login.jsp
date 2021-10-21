<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<h2>用户登录</h2><hr>
<form action="/login" method="post">
    <div style="color: red"> ${msg==""?"":msg}</div>

    <table>

        <tr>
            <td align="right">用户名:</td>
            <td><input type="text" name="username" value="admin"></td>
        </tr>
        <tr>
            <td align="right">密码:</td>
            <td><input type="password" name="password" value="123456"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>
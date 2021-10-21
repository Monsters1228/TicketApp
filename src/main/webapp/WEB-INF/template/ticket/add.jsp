<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加票据</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp" %>
<form method="POST" action="/ticket">
    <h2>添加新票据</h2>
    <!--用隐藏字段传递action的类型-->
    <input type="hidden" name="action" value="create">
    客户名称<br/>
    <input type="text" name="companyName" value="电子科技大学中山学院"><br/><br/>
    票据主题<br/>
    <input type="text" name="subject" value="2018年设备采购"><br/><br/>
    总金额<br/>
    <input type="text" name="money" value="20000"><br/><br/>
    类型<br/>
    <select name="type">
        <option value="银行汇票" selected>银行汇票</option>
        <option value="商业汇票">商业汇票</option>
        <option value="商业本票">商业本票</option>
        <option value="银行本票">银行本票</option>
        <option value="转帐支票">转帐支票</option>
    </select>
    <br/><br/>
    票据内容<br/>
    <textarea name="body" rows="5" cols="30">购买办公用品、服务器1批，共10000元...
            </textarea><br/><br/>
    <input type="submit" value="提交"/>
</form>
<p>
    <a href="/ticket">返回票据列表</a><br/><br/>
<hr>
@zsc 电子科技大学中山学院 计算机学院 班级:xxx, 学号:xx, 姓名:xxx <p></p>
</body>
</html>
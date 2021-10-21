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
<h2>票据详情</h2><hr>
    票据Id：${ticket.id}<p>
    企业名字：${ticket.companyName}  <p>
    票据总金额：${ticket.money} <p>
    主题：  ${ticket.subject}  <p>
    主要内容： ${ticket.body} <p>
    票据状态： ${ticket.status} <p>

    <a href="/ticket">返回票据列表</a><br /><br />
    <%@include file="/WEB-INF/template/common/footer.jsp" %>
</body>
</html>

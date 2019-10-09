<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/10
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式获取值</title>
</head>
<body>
<%
    request.setAttribute("name","张三");
    session.setAttribute("age",24);
    pageContext.setAttribute("gender","女");
 %>
<h3>el获取值</h3>
${requestScope.name}<br>
${sessionScope.age}<br>
${pageScope.gender}<br>
${name}
</body>
</html>

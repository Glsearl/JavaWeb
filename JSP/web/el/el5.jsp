<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/10
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL隐式对象</title>
    pageContext可以获取jsp内置对象<br>
</head>
<body>
${pageContext.request}<br>
${pageContext.request.contextPath}   动态获取虚拟目录
</body>
</html>

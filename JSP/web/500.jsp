<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/6
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器正忙。。。</h1>
<% String message = exception.getMessage();out.write(message);%>
</body>
</html>

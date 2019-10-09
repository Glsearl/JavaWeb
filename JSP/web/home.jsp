<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/6
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--页面包含的。导入页面的资源文件--%>
<%@include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp注释--%>
<%--<h1>hello</h1>--%>
<% pageContext.setAttribute("msg","hi~~~~~~~~~~");%>



<%= pageContext.getAttribute("msg")%>

</body>

</html>

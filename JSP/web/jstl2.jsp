<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/11
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <p>2. choose:相当于java代码的switch语句
        1. 使用choose标签声明         			相当于switch声明
        2. 使用when标签做判断         			相当于case
        3. 使用otherwise标签做其他情况的声明    	相当于default
   </p>
    <title>choose</title>
</head>
<body>
<%
    request.setAttribute("day",10);
%>
<c:choose>
    <c:when test="${day==1}">星期一</c:when>
    <c:when test="${day==2}">星期二</c:when>
    <c:when test="${day==3}">星期三</c:when>
    <c:when test="${day==4}">星期四</c:when>
    <c:when test="${day==5}">星期五</c:when>
    <c:when test="${day==6}">星期六</c:when>
    <c:when test="${day==7}">星期日</c:when>
    <c:otherwise>输入的参数不合法</c:otherwise>
</c:choose>
</body>
</html>

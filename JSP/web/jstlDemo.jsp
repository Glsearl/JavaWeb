<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/11
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    5. 练习：
    * 需求：在request域中有一个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp页面的表格table中
    <title>demo</title>
</head>
<body>
<%
    List list=new ArrayList();
    list.add(new User("张三",24,"男",new Date()));
    list.add(new User("李四",20,"女",new Date()));
    list.add(new User("王二",19,"男",new Date()));
    request.setAttribute("list",list);
%>
<table width="500" border="1" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list} " var="user" varStatus="s">
      <c:if test="${s.count}%2==0">
        <tr bgcolor="#faebd7">
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
            <td>${user.strbir}</td>
        </tr>
      </c:if>
        <c:if test="${s.count}%2!=0">
            <tr bgcolor="#7fffd4">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.gender}</td>
                <td>${user.strbir}</td>
            </tr>
        </c:if>
    </c:forEach>


</table>
</body>
</html>

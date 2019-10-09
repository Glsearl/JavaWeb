<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/6
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--1. <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。--%>
<%--2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。该脚本可以定义成员变量、成员方法等。--%>
<%--3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%!String str=null;%>
  <% System.out.println("hello jsp");%>
  <%="hi"%>
  </body>
</html>

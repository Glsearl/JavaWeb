<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/10
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL入门</title>
</head>
<body>
\${}可以忽略EL表达式，原样展示在页面上
\${3>4}
 ${3>4}
 <hr>
<h3> 1. 算数运算符： + - * /(div) %(mod)</h3>
  ${3+4}
  ${5-3}
  ${3*4}
  ${12/4}
  ${3%4}<br>
<h3>2. 比较运算符： > < >= <= == != </h3>
${5>3}
${5!=4}
<h3>3. 逻辑运算符： &&(and) ||(or) !(not)</h3>
${5>3&&3<5}
${5>3 and 3<5}
<h3>4. 空运算符： empty</h3>
<%
    String str=null;
    request.setAttribute("str",str);
    List list=new ArrayList();
    request.setAttribute("list",list);
%>
${empty str}
${not empty list}
</body>
</html>

<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/10
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象、集合的值</title>
</head>
<body>
<% User user=new User();
user.setName("李四");
user.setAge(24);
user.setGender("男");
   request.setAttribute("user",user);
    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list",list);
    Map map=new HashMap();
    map.put("sname","张三");
    map.put("sage",12);
    map.put("user",user);
    request.setAttribute("map",map);
%>
<h3>获取对象中的值</h3>
${requestScope.user}
${requestScope.user.name}
${requestScope.user.age}
${requestScope.user.gender}
<h3>获取list中的值</h3>
${list}
${list[0]}
${list[1]}
${list[2].name}
<h3>获取map中的值</h3>
${map}
${map.sname}
${map.sage}
${map.user.name}
${map["sname"]}
</body>
</html>

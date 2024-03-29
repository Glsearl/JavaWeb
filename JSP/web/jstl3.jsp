<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/11
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
 <%--   3. foreach:相当于java代码的for语句
   *1. 完成重复的操作
    for(int i = 0; i < 10; i ++){  }
            * 属性：
            begin：开始值
            end：结束值
            var：临时变量
            step：步长
            varStatus:循环状态对象
               index:容器中元素的索引，从0开始
               count:循环次数，从1开始
    2. 遍历容器
    List<User> list;
    for(User user : list){
    }
        * 属性：
        items:容器对象
        var:容器中元素的临时变量
        varStatus:循环状态对象
           index:容器中元素的索引，从0开始
           count:循环次数，从1开始
    --%>
</head>
<body>
<c:forEach begin="0" end="10" var="i" step="1" varStatus="s">
    ${i} ${s.index} ${s.count}<br>
</c:forEach>
<hr>
<%
    ArrayList list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="str" varStatus="s">
    ${str} ${s.index} ${s.count}<br>
</c:forEach>

</body>
</html>

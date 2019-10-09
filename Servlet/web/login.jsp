<%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/5
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            var img = document.getElementById("img");
            img.onclick = function () {
                this.src = "/Servlet_war_exploded/checkCodeServlet1?time=" + new Date().getTime();
            }
        }

    </script>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="/Servlet_war_exploded/loginServlet" method="post">
    <table>
        <tr>
          <td> 用户名： <input type="text" name="username"></td>
        </tr>
        <tr>
         <td> 密码：  <input type="password" name="password"></td>
        </tr>
        <tr><td> 验证码：<input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/Servlet_war_exploded/checkCodeServlet1"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>

    </table>
</form>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
</div>
<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
</div>

</body>
</html>

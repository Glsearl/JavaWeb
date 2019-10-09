<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Gaols
  Date: 2019/9/3
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    response.setContentType("text/html;charset=utf-8");
    boolean flag=false;
    if (cookies!=null||cookies.length>0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)){
                flag=true;
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String format = sdf.format(date);
                //url编码
                String encode1 = URLEncoder.encode(format, "utf-8");
                cookie.setValue(encode1);
                cookie.setMaxAge(60*60*60);
                response.addCookie(cookie);
                String value = cookie.getValue();
                //Url解码
                String encode = URLDecoder.decode(value, "utf-8");
                %>


              <%  out.write("欢迎回来，您上次访问时间为:"+encode);
            }


        }
    }
              %>
   <%
       if (cookies==null||cookies.length==0||flag==false){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String last_Time = sdf.format(date);
        last_Time = URLEncoder.encode(last_Time, "utf-8");
        Cookie cookie1=new Cookie("lastTime",last_Time);
        cookie1.setMaxAge(60*60*60);
        response.addCookie(cookie1);
        %>
      <%
        out.write("您好，欢迎您首次访问");
    }%>
</body>
</html>

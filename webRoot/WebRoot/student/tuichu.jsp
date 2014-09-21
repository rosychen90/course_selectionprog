<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  </head>
  <body>
   <%
   	session.removeAttribute("isLogin");
    response.setHeader("refresh","0;URL=../index.jsp") ;
    %> 
  </body>
</html>

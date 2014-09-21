<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
	<title>error</title>
</head>
<body>

<center>
<div style="background-color:#999; border:#00C, solid,2px; width:300px; height:150px;margin-top:100px;">
    <% 
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=../index.jsp") ;
	%>
			您还未登陆，请先登陆！！！<br>
			两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="../index.jsp">这里</a>！！！<br>
	<%
	%>
	</div>
</center>

</body>
</html>
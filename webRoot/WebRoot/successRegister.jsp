<%@ page contentType="text/html;charset=utf-8"%>
<html>
  <head>
    <title>successRegister.html</title>
  </head>
  
  <body>
  <center>
 <div style=" border:#00C, solid,2px; width:300px; height:180px;margin-top:100px;">
  <h1>
		注册成功
		
  	</h1>
  	  <% 
			// 用户未登陆，提示用户登陆，并跳转
			response.setHeader("refresh","2;URL=index.jsp") ;
	%>
  	<h3>两秒后自动跳转到登陆窗口！！！<br>
			如果没有跳转，请按<a href="index.jsp">这里</a>！！！</h3> 
			</div>
  </center>
    
  
  
  
  	
  </body>
</html>

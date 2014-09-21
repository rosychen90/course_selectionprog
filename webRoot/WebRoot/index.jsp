<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<script type="text/javascript">
function regist(){
	window.location="register.jsp";
}

</script>
	<style type="text/css">
<!--
.STYLE2 {
	font-size: 36pt;
	color: #006699;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}
.STYLE4 {font-size: 16px}
.STYLE5 {font-size: 16px; font-weight: bold; }
-->
</style>
<head>
	<title>欢迎来到选课系统</title>
</head>
<body >

	   <table width="940" height="105" border="0">
  <tr>
    <td width="339" height="101"><div align="center"><br></div></td>
    <td width="591"><div align="left">
      <p align="center"><span class="STYLE2">学生选课系统</span></p>
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
  <div > 

<center>


	<%
		if(request.getAttribute("errors")!=null)
		{
			// 有错误，要进行打印输出
			ArrayList<String> all = (ArrayList<String>)request.getAttribute("errors") ;
			Iterator iter = all.iterator();
			while(iter.hasNext())
			{
	%>
			<label style="color:red;"><%=iter.next()%></label>
	<%
			}
		}
	%>
	</center>
	</div>
	<form action="loginServlet"  method="post" >
<table width="307" height="247" border="0" align="center">

  <tr>
    <td width="110" height="49"><div align="center"><strong><span class="STYLE4">用户名</span></strong></div></td>
    <td width="187">
      <input type="text" name="id" />
    </td>
  </tr>
  <tr>
    <td height="53"><div align="center"><strong><span class="STYLE4">密码</span></strong></div></td>
    <td>
      <input type="password" name="password" />
     </td>
  </tr>
   <tr>
    <td height="53"><div align="center"><strong><span class="STYLE4">选择</span></strong></div></td>
    <td>
      <input type="radio" name="vip" value="1"/>教师
      <input type="radio" name="vip" value="0"  checked="checked"/>学生
     </td>
  </tr>
  <tr>
    <td height="45">
      <div align="right">
        <input name="Cancle" type="reset" id="Cancle" value="取消" />
        </div>
    </td>
    <td>     
        <div align="center">
          <input name="Enter" type="submit" id="Enter" value="进入&gt;&gt;" />
        </div>
    </td>
  </tr>
  <tr>
    <td height="43" colspan="2"><hr /></td>
  </tr>
  <tr>
    <td height="45" colspan="2" class="STYLE5"><div align="center">
      <ul>
        <li> 没有账号？  
          
         <input type="button" value="注册" onclick="regist()">
          </li>
      </ul>
    </div></td>
  </tr>
</table>
</form>



</body>
</html>
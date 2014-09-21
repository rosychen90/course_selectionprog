<%@ page language="java" import="java.util.*" import="dbc.*"
	import="java.sql.*" import="vo.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
function index(){
	window.location="index.jsp";
}
</script>
<style type="text/css">
	<!--
	.STYLE2 {	font-size: 36pt;
		color: #006699;
		font-weight: bold;
		font-family: Arial, Helvetica, sans-serif;
	}
	.STYLE3 {font-size: 16px}
	.STYLE4 {
		font-size: 18px;
		font-weight: bold;
	}
	.STYLE6 {font-size: 16px; font-weight: bold; }
	-->
	</style>
	
	<head>
		<title>学生注册</title>
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
		<center>

			

			<%
				if (request.getAttribute("errors") != null) {
					// 有错误，要进行打印输出
					ArrayList<String> all = (ArrayList<String>)request.getAttribute("errors");
					Iterator iter = all.iterator();
					while (iter.hasNext()) {
			%>
		<label style="color:red;"><%=iter.next()%></label>
			<%
				    }
				}
			%>



			<form action="registerServlet" method="post" name="register">
				<table align="center">
					<tr >
						<td align="center">
							姓名
						</td>
						<td>
							<input type="text" name="register_name" SIZE=20 value="">
						</td>
					</tr>
					<tr >
						<td align="center">
							密码
						</td>
						<td>
							<input type="password" name="register_password1" SIZE=20>
						</td>

					</tr>
					<tr >
						<td align="center">
							确认密码
						</td>
						<td>
							<input type="password" name="register_password2" SIZE=20>
						</td>

					</tr>
					<tr >
						<td align="center">
							学号
						</td>
						<td>
							<input type="text" name="register_id" SIZE=20 value="">
						</td>

					</tr>
					<tr >
						<td align="center">
							性别
						</td>
						<td align="center">

							<input type="radio" name="register_sex" value="1"
								checked="checked">
							男

							<input type="radio" name="register_sex" value="0">
							女
						</td>

					</tr>
					<tr>
						<td align="center">
							学院名称
						</td>
						<td>
						<input type="text" name="college" />

						</td>
					</tr>

					<tr>
						<td align="center">
							专业
						</td>
						<td>
							<input type="text" name=profession />
						</td>

					</tr>
					<tr>
    <td height="35" colspan="5"><p><span class="STYLE6">*请完整并真实填写以上的信息</span></p></td>
  </tr>
				</table>
				<br>
				<div align="center">
					<input type="submit" value="提交">
					&nbsp;&nbsp;
					<input type="reset" value="重置">
					&nbsp;&nbsp;
					<input type="button" value="返回" onclick="index()">
				</div>
			</form>
		</center>
	</body>
</html>

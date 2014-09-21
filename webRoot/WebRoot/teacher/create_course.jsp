<%@ page language="java" import="java.util.*" import="dbc.*"
	import="java.sql.*" import="vo.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加课程</title>
	</head>

	<body >
		<div style="width: 100%;">
			<center>

				<h2>
					添加课程
				</h2>
				<%
					if (session.getAttribute("errors_create_course") != null) {
						// 有错误，要进行打印输出
						ArrayList<String> all = (ArrayList<String>) session
								.getAttribute("errors_create_course");
						Iterator iter = all.iterator();
						while (iter.hasNext()) {
				%>
				<label style="color:red;"><%=iter.next()%></label>
				<%
					}
						session.removeAttribute("errors_create_course");
					}
				%>
				<form action="../servlet/create_course_slt" method="post">
					<input type="hidden" name="teacher_id" SIZE=20
						value="<%=session.getAttribute("id")%>" />
					<table align="center">
						<tr>
							<td align="center">
								课程名
							</td>
							<td>
								<input type="text" name="name" SIZE=20 value="">
							</td>
						</tr>
						<tr >
							<td align="center">
								课程编号
							</td>
							<td>
								<input type="text" name="id" SIZE=20 value="">
							</td>

						</tr>


						<tr>
							<td align="center">
								课程类型
							</td>
							<td>
								<input type="text" name="status" value="">
							</td>

						</tr>
						<tr>
							<td align="center">
								上课时间
							</td>
							<td >
								<input type="text" name="time" value="" />

							</td>

						</tr>
						<tr>
							<td align="center">
								上课教室
							</td>
							<td>
								<input type="text" name="classroom" value="" />
							</td>

						</tr>
						<tr>
							<td align="center"> 
								总人数</td>
							<td>
								<input type="text" name="maxNum" SIZE=20 value="">


							</td>

						</tr>

					</table>
					<br>
					<div align="center">
						<input type="submit" value="确定">
						&nbsp;&nbsp;
						<input type="reset" value="重置">
					</div>
				</form>

			</center>
		</div>
	</body>
</html>

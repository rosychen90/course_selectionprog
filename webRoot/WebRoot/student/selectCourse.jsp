<%@ page language="java" import="java.util.*" import="dbc.*"
	import="java.sql.*" import="vo.*" pageEncoding="UTF-8"%>
<html>
<body >
<center>
		
			<div id="right" style="float: left; width: 100%;">
			<h2>请选择课程</h2>
		<%
				if (session.getAttribute("errors_select") != null) {
					// 有错误，要进行打印输出
					ArrayList<String> all = (ArrayList<String>)session.getAttribute("errors_select") ;
					Iterator iter = all.iterator();
					while (iter.hasNext()) {
			%>
			<label style="color:red;"><%=iter.next()%></label>
			<%
				    }
				    session.removeAttribute("errors_select");
				}
				
			%>
			<form action="../servlet/servletCourse" method="post"
				name="selectCourse">
				<table border="1">
					<tr>
						<td width="50" height="38" align="center">
							选择
						</td >
						<td  width="70" align="center"> 
							课程编号</td>
						<td width="70" align="center">
							科目
						</td>
						<td width="58" align="center">
							教师
						</td>
						<td width="80" align="center">
							类型
						</td>
						<td width="85" align="center">
							上课时间
						</td>
						<td width="70" align="center">
							上课教室
						</td>
						<td width="70" align="center"> 
							剩余人数 
						</td>
						<td width="65" align="center"> 
							总人数 
						</td>
					</tr>
					<jsp:useBean id="course" class="vo.CourseVo" scope="page" />
					<jsp:useBean id="course2" class="vo.CourseVo" scope="page" />
					<jsp:useBean id="secletinfo" class="vo.SelectInfo" scope="page" />
					<%!ResultSet rs = null;%>
					<%!ResultSet rs_select = null;boolean flag = true;%>
					<%
						//id name teacher_id college_id status time classroom num maxNum
						String sql = "SELECT * FROM course";
						String sql_select = "SELECT * FROM select_info WHERE student_id=?";
						try {
							secletinfo.setSQL(sql_select);
							secletinfo.getPstmt().setString(1,
									(String) session.getAttribute("id"));
							secletinfo.setResultSet();
							rs_select = secletinfo.getRs();
							course.setSQL(sql);
							course.setResultSet();
							rs = course.getRs();
							while (rs.next()) {
								flag = true;
								if(rs_select.first()){
									rs_select.first();
									if (rs.getString(1).equals(rs_select.getString(2))) {
											flag = false;
									}
									while (rs_select.next()) {
										if (rs.getString(1).equals(rs_select.getString(2))) {
											flag = false;
										}	
									}
							}
								if (flag == true) {
					%>
					<tr>
						<td align="center">
							<input type="checkbox" name="course" value="<%=rs.getString(1)%>">
						</td>
						<td align="center">
							<%=rs.getString(1)%>
						</td>
						<td align="center">
							<%=rs.getString(2)%>
						</td>
						<td align="center">
							<%
								sql = "SELECT name FROM teacher WHERE id=?";
											course2.setSQL(sql);
											course2.getPstmt().setString(1, rs.getString(3));
											course2.setResultSet();
											ResultSet rs2 = course2.getRs();
											while (rs2.next()) {
							%>
							<%=rs2.getString(1)%>
						</td>
						<%
							}
						%>
					
						<td align="center">
							<%=rs.getString(4)%>
						</td>
						<td align="center">
							<%=rs.getString(5)%>
						</td>
						<td align="center">
							<%=rs.getString(6)%>
						</td>
						<td align="center">
							<%=rs.getInt(7)%>
						</td>
						<td align="center">
							<%=rs.getInt(8)%>
						</td>
					</tr>
					<%
						    	}
						    }

						} catch (Exception e) {
							System.out.println(e);
						}
					%>
				</table>
		
					<div style="float: left; width: 100%;">
					<center>
					<input type="submit" value="选择" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重选" />
					</center>
				</div>
			</form>
		</div>

			<%secletinfo.close();
				course.close();
				rs.close();
			rs_select.close();
				%>



</center>
	</body>
</html>

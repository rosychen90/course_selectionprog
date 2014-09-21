<%@ page language="java" import="java.util.*" import="dbc.*"
	import="java.sql.*" import="vo.*" pageEncoding="UTF-8"%>
<html>
<body >
		<div id="right" style="float: left; width: 100%;">
		<center>
		<h2>所有课程</h2>
		
		<%
				if (session.getAttribute("errors_look_course") != null) {
					// 有错误，要进行打印输出
					ArrayList<String> all = (ArrayList<String>)session.getAttribute("errors_look_course") ;
					Iterator iter = all.iterator();
					while (iter.hasNext()) {
			%>
			<%=iter.next()%>
			<%
				    }
				    session.removeAttribute("errors_look_course");
				}
				
			%>
				<table border="1">
					<tr>
						<td  height="38" width="75" align="center"> 
							课程编号</td>
						<td width="70" align="center">
							科目
						</td>
						<td width="65" align="center">
							教师
						</td>
						<td width="80" align="center">
							类型
						</td>
						<td width="85" align="center">
							上课时间
						</td>
						<td width="75" align="center">
							上课教室
						</td>
						<td width="70" align="center"> 
							剩余人数 
						</td>
						<td width="70" align="center"> 
							总人数 
						</td>
					</tr>
					<jsp:useBean id="course" class="vo.CourseVo" scope="page" />
					<jsp:useBean id="course2" class="vo.CourseVo" scope="page" />
					<jsp:useBean id="createCour" class="vo.CreatCour" scope="page" />
					
					<%!ResultSet rs_select = null;%>
					<%
						boolean flag=false;
						//id name teacher_id college_id status time classroom num maxNum
						String sql =null;
						String sql_select = "SELECT * FROM create_cour WHERE teacher_id=?";
						try {
							createCour.setSQL(sql_select);
							createCour.getPstmt().setString(1,
									(String) session.getAttribute("id"));
							createCour.setResultSet();
							rs_select = createCour.getRs();
							while (rs_select.next()) {
							sql = "SELECT * FROM course WHERE id=?";
								flag=true;
								course.setSQL(sql);
								course.getPstmt().setString(1,rs_select.getString(2));
								course.setResultSet();
								ResultSet rs = course.getRs();
								if(rs.first()){
									
							
					%>
					<tr>
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
			</center>
		</div>

			<%createCour.close();
			if(flag==true){
		
				course.close();
				}
			rs_select.close();
				%>




	</body>
</html>

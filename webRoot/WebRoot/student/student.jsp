<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<html>
	<style type="text/css">
.STYLE2 {
	font-size: 36pt;
	color: #006699;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
}

.STYLE4 {
	font-size: 16px
}

.STYLE5 {
	font-size: 16px;
	font-weight: bold;
}

<
style type ="text/css"><!-- /*通用*/ body {
	font: 12px Arial, Verdana, Tahoma, "宋体";
}

* {
	padding: 0px;
	margin: 0px;
}

* li {
	list-style: none;
}

a {
	text-decoration: none;
	color: #20537A;
}

a:hover {
	text-decoration: underline;
}

.clearfix:after {
	content: "\0020";
	display: block;
	height: 0;
	clear: both;
}

.clearfix {
	_zoom: 1;
}

*+html .clearfix {
	overflow: auto;
}

.menu_navcc {
	width: 970px;
	margin: 0 auto;
}

.menu_nav {
	width: 970px;
	height: 48px;
	background: url(img/nav_bg.gif) repeat-x;
	float: left;
	margin-top: 18px;
}

.menu_nav .nav_content {
	padding-left: 25px;
	background: url(img/nav_l_bg.gif) no-repeat;
	float: left;
}

.menu_nav .nav_content li {
	width: 88px;
	height: 48px;
	padding-left: 15px;
	padding-right: 13px;
	background: url(img/nav_li_right.gif) no-repeat right center;
	float: left;
	line-height: 48px;
	text-align: center;
	font-size: 14px;
	font-weight: bold;
}

.menu_nav .nav_content li a {
	color: #fff;
	width: 88px;
	height: 48px;
	display: block;
}

.menu_nav .nav_content li.current {
	line-height: 37px;
}

.menu_nav .nav_content li em {
	background: url(img/bid_new.gif) no-repeat;
	width: 35px;
	height: 21px;
	display: inline-block;
	position: absolute;
	top: -20px;
	left: 40px;
}

.menu_nav .nav_content li.current a,.menu_nav .nav_content li a:hover {
	width: 88px;
	height: 37px;
	background: url(img/nav_li_current.gif) no-repeat;
	display: block;
	color: #fff;
}

.menu_nav .nav_content li a:hover {
	background: url(img/nav_li_hover.gif) no-repeat;
	line-height: 37px;
	text-decoration: none;
}

.menu_nav_right {
	padding-right: 20px;
	background: url(img/nav_r_bg.gif) no-repeat right top;
	float: right;
	margin-left: 50px;
	padding-top: 13px;
	height: 23px;
	padding-bottom: 12px;
}

p {
	margin-bottom: 15px
}
-->
</style>
	<head>
	</head>

	<body onload="Time()">
		<%
			if (session.getAttribute("isLogin") == "ok") {
			} else {
				response.sendRedirect("noLogin.jsp");
			}
		%>
		<center>
			<div id="top"
				style="float: left; width: 80%; margin-left: 4%; height: 40px;">
				<p align="center">
					<span class="STYLE2">学生选课系统</span>
				</p>
				<div
					style="font-size: 14px; width: 160px; height: 20px; float: left;">
					学生姓名：<%=session.getAttribute("name")%></div>
				<div
					style="font-size: 14px; width: 160px; height: 20px; float: left;">
					学号：<%=session.getAttribute("id")%></div>
				<!--nav,start-->
				<div class="menu_navcc">
					<div class="menu_nav clearfix">
						<ul class="nav_content">
							<li >
								<a href="main.jsp" target="main" ><span>首页</span>
								</a>
							</li>
							<li>
								<a href="student/selectCourse.jsp" target="main">学生选课</a>
							
							</li>
							<li >
									<a href="student/select_chakan.jsp" target="main">删除课程</a>
							
							</li>
							<li >
									<a href="student/tuichu.jsp" style="text-decoration: none;">退出</a>
						
							</li>
						</ul>
						<div class="menu_nav_right">
						</div>
					</div>
				</div>
				<!--nav,end-->
			</div>
			<div id="right"
				style="float: left; width: 58%; border: rgb(200, 213, 251) 2px solid;margin-left:16%;">
				<iframe width=100% name="main" frameborder="0" scrolling="auto"
					src="main.jsp" height=400>
				</iframe>
			</div>
		</center>
	</body>
</html>

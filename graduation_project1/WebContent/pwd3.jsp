<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<title>第二课堂管理系统</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>
<%
	String user = (String) session.getAttribute("userName");
	if (user == null) {
%>
<script>
	alert('尊敬的游客，由于您未登录，所以无法使用该平台，谢谢合作！');
	window.location.href = 'sign-in.html';
</script>
<%
	}
%>

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<ul class="nav pull-right">
					<li id="fat-menu" class="dropdown">
					<a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i>${userName} <i class="icon-caret-down"></i>
					</a>
					
					<ul class="dropdown-menu">
							<li><a tabindex="-1" href="sign-in.html">注销</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="pwd.jsp">修改密码</a></li>
						</ul>
					</li>
					
				</ul>
				<a class="brand" href="manangerIndex.jsp"><span class="first">浙江传媒学院</span>
					<span class="second">第二课堂管理系统</span>(教师)</a>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="sidebar-nav">
					<div class="nav-header" data-toggle="collapse"
						data-target="#dashboard-menu">
						<i class="icon-dashboard"></i>导航栏
					</div>
					<ul id="dashboard-menu" class="nav nav-list collapse in">
						<li><a href="manageIndex.jsp">主页</a></li>
						<li><a href="manVolunteerActivity.jsp">志愿者活动</a></li>
						<li><a href="manCompetition.jsp">竞赛活动</a></li>
						<li><a href="manChair.jsp">讲座</a></li>
						<li><a href="manTeacherProject.jsp">教师项目</a></li>
						<li><a href="manhelp.jsp">帮助</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>第二课堂项目管理</span>
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="manVolunteerActivityManage.jsp">志愿者活动管理</a></li>
						<li><a href="manCompetitionManage.jsp">竞赛活动管理</a></li>
						<li><a href="manChairManage.jsp">讲座管理</a></li>
						<li><a href="manTeacherProjectManage.jsp">教师项目管理</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#legal-menu">
						<i class="icon-legal"></i>用户管理
					</div>
					<ul id="legal-menu" class="nav nav-list collapse in">
						<li><a href="manUserManage2.jsp">查看用户</a></li>
						<li><a href="manUserManage.jsp">用户管理</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<h3 class="page-title">修改密码</h3>
				<form id="tab2" action="StudentPwd" method="get">
				<div class="well">
					<label>用户名</label>
					<input name="name" type="text" value = ${userName} class="input-xlarge" readonly> 
					<label>请输入新的密码</label>
					<input name="firstPwd" type="password" class="input-xlarge"> 
					<label>请再次输入确认</label>
					<input name="secondPwd" type="password" class="input-xlarge"> 
					<div>
					<button class="btn btn-primary" style="submit">提交修改</button>
					</div>
				</div>
				</form>
				
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
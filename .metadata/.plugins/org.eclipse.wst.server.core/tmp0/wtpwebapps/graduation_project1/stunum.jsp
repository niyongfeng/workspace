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

<link rel="stylesheet" href="stylesheets/panigate.css">
<script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="javascripts/panigate.js"></script>


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
<script type="text/javascript">
var reg = new RegExp('\\d+');
var id = reg.exec(window.location.search)[0];
console.log(id);
$.ajax({
	type : "get",
	url : 'UserVolunteerServlet',
	data : $.param({
		id : id
	}),
	cache : false, 
	success : function(data) {
		var json = eval('(' + data + ')');
		for (var i = 0; i < json.length; i++) {
			var val = json[i];
			$("#description").append(val.desc);
			var str = "<tr><td>"+ (json.length - i)
					+ "</td><td>"
					+ val.name
					+ "</td><td>"
					+ val.student_number
					+ "</td><td>"
					+ val.major
					+ "</td><td>"
					+ val.phone
					+ "</td><td style=\"display:none;\">" + val.volunteer_id
					+ "</td><td><a href=\"#\" role=\"button\" data-toggle=\"modal\" onclick='deleteChair($(this))'><i class=\"icon-remove\"></i></a></td></tr>";		
			$("#volunteerActivityList").after(str);
		}
	}
})</script>
<script type="text/javascript">
function deleteChair(e) {
	var id = e.parents('td').prev().text();
	$.ajax({
		type : "post",
		url : 'DeleteUserVolunteer',
		data : $.param({
			volunteer_id : id
		}),
		cache : false, // 提交两个参数：pageIndex(页面索引)，pageSize(显示条数)
		success : function(data) {
			if ($.trim(data) == "OK") {
				e.parents('tr').hide();
				alert("删除成功");
				location.reload(false);
				// parent.location.reload();
			} else {
				return false;
			}
		}
	});
}
</script>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<ul class="nav pull-right">
					<li id="fat-menu" class="dropdown"><a href="#" id="drop3"
						role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i>${userName} <i class="icon-caret-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="sign-in.html">注销</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="pwd.jsp">修改密码</a></li>
							<!-- <li class="divider"></li>
							<li><a tabindex="-1" href="studentInfo.jsp">个人中心</a></li> -->
						</ul>
					</li>
				</ul>
				<a class="brand" href="teacherIndex.jsp"><span class="first">浙江传媒学院</span>
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
						<li><a href="teacherIndex.jsp">主页</a></li>
						<li><a href="teacherVolunteerActivity.jsp">志愿者活动</a></li>
						<li><a href="teacherCompetition.jsp">竞赛活动</a></li>
						<li><a href="teacherChair.jsp">讲座</a></li>
						<li><a href="teacherTeacherProject.jsp">教师项目</a></li>
						<li><a href="teacherhelp.jsp">帮助</a></li>
					</ul>
					<div class="nav-header" data-toggle="collapse"
						data-target="#accounts-menu">
						<i class="icon-briefcase"></i>第二课堂项目管理</span>
					</div>
					<ul id="accounts-menu" class="nav nav-list collapse in">
						<li><a href="teacherVolunteerActivityManage.jsp">志愿者活动管理</a></li>
						<li><a href="teacherCompetitionManage.jsp">竞赛活动发布管理</a></li>
						<li><a href="teacherChairManage.jsp">讲座发布管理</a></li>
						<li><a href="teacherTeacherProjectManage.jsp">教师项目发布管理</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>
				<h1 class="page-title">名单</h1>
				<div class="well">
					<table class="table">
							<h4 id = "description" align="center">志愿者活动名单：</h4>
							<tr title="" id="volunteerActivityList">
								<th>#</th>
								<th>姓名</th>
								<th>学号</th>
								<th>专业</th>
								<th>联系方式</th>
								<th></th>
								<th style="display: none;">volunteer_id</th>
							</tr>
						</thead>
					</table>
					</div>
					<div class="well search-well">
					<form class="form-inline"  method="get">
						<button id = "export" class="btn" type="submit" onclick="jj()">
							<i class="icon-signout"></i>导出数据
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function jj() {
		var reg = new RegExp('\\d+');
		var id = reg.exec(window.location.search)[0];
		console.log(id);
		$.ajax({
			type : "get",
			url : 'ExportServlet2',
			data : $.param({
				id : id
			}),
			cache : false,
			success:
				alert("导出成功！"),
				
				/* window.location.href="manVolunteerActivity.jsp"; */
			
		})
	}
	</script>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>

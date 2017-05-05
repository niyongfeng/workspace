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

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="stylesheets/panigate.css">
<script src="lib/jquery-1.8.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="javascripts/panigate.js"></script>
<script type="text/javascript" src="javascripts/chair.js"></script>

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
					<li id="fat-menu" class="dropdown"><a href="#" id="drop3"
						role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i>${userName} <i class="icon-caret-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="sign-in.html">注销</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="pwd.jsp">修改密码</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="studentInfo.jsp">个人中心</a></li>
						</ul></li>
				</ul>
				<a class="brand" href="studentIndex.jsp"><span class="first">浙江传媒学院</span>
					<span class="second">第二课堂管理系统</span>(学生)</a>
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
						<li><a href="studentIndex.jsp">主页</a></li>
						<li><a href="studentVolunteerActivity.jsp">志愿者活动</a></li>
						<li><a href="studentCompetition.jsp">竞赛活动</a></li>
						<li class="active"><a href="studentChair.jsp">讲座</a></li>
						<li><a href="studentTeacherProject.jsp">教师项目</a></li>
						<li><a href="studenthelp.jsp">帮助</a></li>
						<li><a href="myHelp.jsp">我的问题</a></li>
						<li><a href="myVolunteerActivity.jsp">我报名的活动</a></li>
					</ul>
				</div>
			</div>
			<div class="span9">
				<script type="text/javascript" src="lib/jqplot/jquery.jqplot.min.js"></script>
				<script type="text/javascript" charset="utf-8"
					src="javascripts/graphDemo.js"></script>
				<h1 class="page-title">讲座</h1>
				<h6 id="tatol" style="display:none">搜索结果:<a id = "number">${number}</a></h6>
				<div class="well">
					<table class="table">
						<thead>
							<tr title="" id="chairList">
								<th>#</th>
								<th>活动时间</th>
								<th>主讲人</th>
								<th>具体内容</th>
								<th>地点</th>
								<th>发布时间</th>
							</tr>
						</thead>
					</table>
					<div id="Pagination" class="right flickr"></div>
				</div>
				<div class="well search-well">
					<form class="form-inline">
						<input name="info" class="input-xlarge"
							placeholder="Search Help..." id="appendedInputButton" type="text">
						<button id="search" class="btn" type="button">
							<i class="icon-search"></i>Go
						</button>
					</form>
				</div>
			</div>
			<script type="text/javascript">
 $("#search").click(function(){
			var info = $("input[name='info']").val();
			$.ajax({
				type : "get",
				url : 'searchChair', 
				data:{info:info},
				cache : false, 
				success : function(data) {
					console.log("开始渲染数据");
					console.log("info:"+info);
					console.log(data);
					var json = eval('('+data+')');
					tatol.style.display="";
					$("#number").text(json.length);
					$(".table tr:gt(0)").remove();
					for (var i = 0; i < json.length; i++) {
						var val = json[i];
						var s = "（未解决）";
						if(!(val.answer == null)) {
							s = val.answer;
						}
						var str = "<tr><td>"+ (json.length - i)
						+ "</td><td>"
						+ val.activity_time
						+ "</td><td>"
						+ val.chair_professor
						+ "</td><td>"
						+ val.description
						+ "</td><td>"
						+ val.address
						+ "</td><td>"
						+ val.release_time
						+ "</td><td style=\"display:none;\">" + val.id +"</td></tr>";
						$("#chairList").after(str);         
					
					};
					$("#Pagination").hide();
					
				}
			});
	});
 </script>
			<script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>

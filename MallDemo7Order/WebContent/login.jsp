<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>登录</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/form_login.css" rel="stylesheet">
<script src="js/jquery.js?_=201703042022"></script>
<script src="js/bootstrap.js"></script>

</head>
<%
String msg = (String)session.getAttribute(
		SessionKeyEnum.message.name());
if (msg != null) {
	session.removeAttribute(SessionKeyEnum.message.name());
}
%>
<body>
<div class="container">

      <form class="form-signin" action="servlet/login.do" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="loginName" class="sr-only">用户名</label>
        <input type="text" id="loginName" name="loginName" class="form-control" placeholder="用户名" required="true" autofocus="">
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="true">
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <% if (msg != null && !"".equals(msg)) {%>
        		<span class="btn-danger"><%=msg %></span>
        	<% } %>
      </form>
<a href="index.jsp">回首页</a>
    </div>

</body>
</html>
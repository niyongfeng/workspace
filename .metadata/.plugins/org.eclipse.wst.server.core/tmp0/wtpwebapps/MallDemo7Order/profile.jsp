<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="mall.demo.mybatis.pojo.User" %>
<%@ page import="mall.demo.mybatis.service.UserService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>

<script src="<%=request.getContextPath() %>/js/jquery.js?_=201703042022"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>

<title>User Profile</title>
</head>
<%
boolean isUserLogged = (new UserService()).isUserLogged(request.getSession());
if (!isUserLogged) {
	response.sendRedirect(request.getContextPath() + "/index.jsp");
	return;
}
User user = null;
if (isUserLogged) {
	user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
}
%>
<body>
<div class="container">
<jsp:include page="top.jsp"></jsp:include>
<p style="height:50px;">&nbsp;</p>
<div class="row">
	<div class="col-md-6"><label>LoginName: </label><%=user.getLoginName() %></div>
	<div class="col-md-6"><label>NickName: </label><%=user.getNickname() %></div>
</div>
<div class="row">
	<div class="col-md-6"><label>Email: </label><%=user.getEmail() %></div>
	<div class="col-md-6"><label>Status: </label><%=user.getStatusDisplay() %></div>
</div>
<div class="row">
	<div class="col-md-12">
		<form class="form-inline" action="<%=request.getContextPath() %>/servlet/uploadPhotoServlet"
			method="POST" enctype="multipart/form-data">
  <div class="form-group">
    <label>上传新头像: </label>
    <input type="file" name="photo" class="form-control" 
    		id="photo"  >
  </div>
  
  <button type="submit" class="btn btn-default">上传</button>
</form>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
	<% if(user.getPhotoPath() == null) {%>
	<span>暂无头像</span>
	<% } else { %>
	<img src="servlet/photoDownload" class="img-responsive" alt="Responsive image"/>
	<%} %>
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="mall.demo.mybatis.service.AdminService" %>
<%
if(!(new AdminService()).isAdminLogged(request.getSession())) {
	response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台-新增商品</title>
<link href="../css/bootstrap.css" rel="stylesheet">

<script src="../js/jquery.js?_=201703042022"></script>
<script src="../js/bootstrap.js"></script>

</head>
<body>
<div class="container">
<jsp:include page="admin_top.jsp"></jsp:include>
<!-- first div move down -->
<p style="height:50px;">&nbsp;</p>
<p>&nbsp;</p>
<form action="../servlet/AddProductServlet" method="POST">
<label>编码</label><input type="text" name="code"><br/>
<label>名字</label><input type="text" name="name"><br/>
<label>描述</label><textarea rows="20" cols="50" name="desc"></textarea><br>
<label>价格</label><input type="text" name="price"><br>
<input type="submit">  <input type="reset">
</form>
<a href="product.jsp">Back</a>
<jsp:include page="admin_footer.jsp"></jsp:include>
</div>
</body>
</html>
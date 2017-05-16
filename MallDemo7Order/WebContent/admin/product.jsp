<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="java.util.List" %>
<%@ page import="mall.demo.mybatis.pojo.Product" %>
<%@ page import="mall.demo.mybatis.service.ProductService" %>
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
<title>后台-商品</title>
<link href="../css/bootstrap.css" rel="stylesheet">

<script src="../js/jquery.js?_=201703042022"></script>
<script src="../js/bootstrap.js"></script>

</head>
<%
List<Product> list = (new ProductService()).getAllProducts();
%>
<body>
<div class="container">
<jsp:include page="admin_top.jsp"></jsp:include>
<!-- first div move down -->
<p style="height:50px;">&nbsp;</p>
<p><a href="addproduct.jsp">新增商品</a>
</p>
<table>
<tr><th>Code</th><th>Name</th><th>Desc</th><th>Price</th><th></th></tr>
<% for (Product prod : list) {%>
<tr><td><%= prod.getCode() %></td>
	<td><%= prod.getName() %></td>
	<td><%= prod.getDescription() %></td>
	<td><%= prod.getPrice() %></td>
	<td><a href="editproduct.jsp?pid=<%=prod.getProductId()%>">修改</a> <a href="../servlet/delproduct?pid=<%=prod.getProductId()%>">删除</a></td>
	
</tr>
<% } %>
</table>
<jsp:include page="admin_footer.jsp"></jsp:include>
</div>
</body>
</html>
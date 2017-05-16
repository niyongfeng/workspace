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
String pid = request.getParameter("pid");
Product product = (new ProductService()).getProductById(Integer.parseInt(pid));
if(product == null) {
	response.sendRedirect("product.jsp");
	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台-修改商品</title>
<link href="../css/bootstrap.css" rel="stylesheet">

<script src="../js/jquery.js?_=201703042022"></script>
<script src="../js/bootstrap.js"></script>

</head>

<body>
<div class="container">
<jsp:include page="admin_top.jsp"></jsp:include>
<!-- first div move down -->
<p style="height:50px;">&nbsp;</p>

<form action="../servlet/updateproduct" method="POST">
<input type="hidden" name="pid" value="<%=product.getProductId()%>">
<label>编码</label><input type="text" name="code" value="<%=product.getCode()%>"><br/>
<label>名字</label><input type="text" name="name" value="<%=product.getName() %>"><br/>
<label>描述</label><textarea rows="20" cols="50" name="desc"><%=product.getDescription() %></textarea><br>
<label>价格</label><input type="text" name="price" value="<%=product.getPrice()%>"><br>
<input type="submit">  <input type="reset">
</form>
<a href="product.jsp">Back</a>
<jsp:include page="admin_footer.jsp"></jsp:include>
</div>
</body>
</html>
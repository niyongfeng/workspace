<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.mybatis.pojo.Product" %>
<%@ page import="mall.demo.util.RequestKeyEnum" %>
<%@ page import="mall.demo.mybatis.service.ProductService" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>首页</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

<script src="<%=request.getContextPath() %>/js/jquery.js?_=201703042022"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/js/index.js?_=20170503"></script>
<script>
var webContextPath = "<%=request.getContextPath() %>";
</script>
</head>
<%
//先在request里取，如果没有，就先全部读取一把
List<Product> products = null;
products = (List<Product>)request.getAttribute(RequestKeyEnum.productList.name());
if (products == null ) {
	products = (new ProductService()).getAllProducts();
}

String searchKey = null;
searchKey = (String)request.getAttribute(RequestKeyEnum.searchKey.name());
if(searchKey == null) {
	searchKey = "";
}
%>
<body>
<div class="container">
<jsp:include page="top.jsp"></jsp:include>
<!-- first div move down -->
<p style="height:50px;">&nbsp;</p>
<form class="form-inline" action="<%=request.getContextPath() %>/servlet/ProductSearchServlet">
  <div class="form-group">
    
    <input type="text" name="searchKey" class="form-control" 
    		id="searchKey" placeholder="搜搜看" value="<%=searchKey %>">
  </div>
  
  <button type="submit" class="btn btn-default">搜一下</button>
</form>
<div class="row">
 	<% for (Product product : products) { %>
 	<div class="col-md-4">
 		<h2><%=product.getCode() %> - <%=product.getName() %></h2>
 		<p><%=product.getDescription() %></p>
 		<p><%=product.getPrice() %></p>
 		<a href="#" onclick="addToCart(<%=product.getProductId() %>);">加入购物车</a>
	</div>
	<% } %>
<!-- </table> -->
</div>

<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
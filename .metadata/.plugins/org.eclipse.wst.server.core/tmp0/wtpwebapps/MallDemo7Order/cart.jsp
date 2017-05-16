<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.mybatis.pojo.ProductInCart" %>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="mall.demo.mybatis.service.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">

<script src="<%=request.getContextPath() %>/js/jquery.js?_=201703042022"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>

</head>
<%
List<ProductInCart> productInCart = (List<ProductInCart>)session.getAttribute(SessionKeyEnum.cart.name());
if(productInCart == null) {
	productInCart = new ArrayList<ProductInCart>();
}
/* Object obj = session.getAttribute(SessionKeyEnum.isUserLoggedIn.name());
boolean isUserLoggedIn = false;
if(obj != null) {
	isUserLoggedIn = (boolean) obj;
} */
boolean isUserLoggedIn = (new UserService()).isUserLogged(request.getSession());
%>
<body>
<div class="container">
<jsp:include page="top.jsp"></jsp:include>
<p style="height:50px;">&nbsp;</p>
<table>
	<tr>
	<th>Code</th>
	<th>Name</th>
	<th>Price</th>
	<th>Amount</th>
	</tr>
	<% for (ProductInCart product : productInCart) { %>
	<tr><td><%=product.getCode() %></td>
		<td><%=product.getName() %></td>	
		<td><%=product.getPrice() %></td>	
		<td><%=product.getAmount() %></td>	
	</tr>
	<% } %>
</table>
<% if (!isUserLoggedIn) {%>
<a href="login.jsp">还没有登录，先登录吧</a>
<%} else if (productInCart.isEmpty()) {%>
<span>购物车没有东西</span>
<% } else { %>
 
	<a href="servlet/makeorder.do">确定下单了</a>
<% } %>

<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
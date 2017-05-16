<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.mybatis.pojo.ProductInCart" %>
<%@ page import="mall.demo.mybatis.pojo.OrderWithDetail" %>
<%@ page import="mall.demo.mybatis.pojo.OrderDetail" %>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="mall.demo.mybatis.pojo.User" %>
<%@ page import="mall.demo.mybatis.service.OrderService" %>
<%@ page import="mall.demo.mybatis.service.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>订单</title>
<link href="css/bootstrap.css" rel="stylesheet">
<script src="js/jquery.js?_=201703042022"></script>
<script src="js/bootstrap.js"></script>
</head>
<%

//Object obj = session.getAttribute(SessionKeyEnum.userObj.name());
boolean isUserLoggedIn = (new UserService()).isUserLogged(request.getSession());

User user = null;
if (isUserLoggedIn) {
	user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
}
int userId = 0;
if (user != null) {
	userId = user.getUserId();
}
List<OrderWithDetail> list = (new OrderService()).getOrdersByUserId(userId);
%>
<body>
<div class="container">
<jsp:include page="top.jsp"></jsp:include>
<!-- first div move down -->
<p style="height:50px;">&nbsp;</p>
<div class="row">
<div class="col-md-3"><b>Code</b></div>
<div class="col-md-3"><b>Price</b></div>
<div class="col-md-3"><b>Status</b></div>
<div class="col-md-3"><b>最后更新时间</b></div>
</div>

	<% for (OrderWithDetail order : list ) { %>
	<div class="row">
	<div class="col-md-3"><%=order.getOrder().getCode() %></div>
		<div class="col-md-3"><%=order.getOrder().getTotalPrice() %></div>
		
		<div class="col-md-3"><%=order.getOrder().getStatus() %></div>
		
		<div class="col-md-3"><%=order.getOrder().getLastTime() %></div>
	</div>
	<div class="row"><div class="col-md-1">&nbsp;</div>
	<div class="col-md-11">
		<div class="row">
			<div class="col-md-3">商品Code</div>
			<div class="col-md-3">Name</div>
			<div class="col-md-3">下单时价格</div>
			<div class="col-md-3">数量</div>
		</div>
		<div class="row">
			<% for (OrderDetail od : order.getDetails()) {%>
			<div class="col-md-3"><%= od.getProduct().getCode() %></div>
				<div class="col-md-3"><%= od.getProduct().getName() %></div>
				<div class="col-md-3"><%= od.getOrderPrice() %></div>
				<div class="col-md-3"><%= od.getAmount() %></div>
			
			<% } %>
		</div>
	</div>
	</div>
			
		
	<% } %>

<a href="index.jsp">回首页</a>

<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
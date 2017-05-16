<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.demo.util.SessionKeyEnum" %>
<%@ page import="mall.demo.mybatis.pojo.ProductInCart" %>
<%@ page import="mall.demo.mybatis.pojo.User" %>
<%@ page import="mall.demo.mybatis.service.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<div class="top">
<!-- <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul> --> 
<ul class="nav nav-pills pull-right">
<%
	List<ProductInCart> productInCart = new ArrayList<ProductInCart>();
	//获取用户的购物车
	productInCart = (List<ProductInCart>)session.getAttribute(SessionKeyEnum.cart.name());
	if (productInCart == null) {
		productInCart = new ArrayList<ProductInCart>();
	}
	int number = 0;
	for(ProductInCart p : productInCart) {
		number += p.getAmount();
	}
	
	boolean isUserLogged = (new UserService()).isUserLogged(request.getSession());
	User user = null;
	if (isUserLogged) {
		user = (User)request.getSession().getAttribute(SessionKeyEnum.userObj.name());
	}
%>
<li><a href="<%=request.getContextPath() %>/index.jsp">主页</a></li>
<li><a href="<%=request.getContextPath() %>/cart.jsp">&nbsp;购物车(
<span id="cartnumber"><%= number%></span> )</a></li>
<% if (isUserLogged) {%>
<li><a href="<%=request.getContextPath() %>/profile.jsp">Hello <%=user.getDisplayName() %></a></li>
<li><a href="<%=request.getContextPath() %>/order.jsp">我的订单</a></li>
<li><a href="<%=request.getContextPath() %>/servlet/logout.do">注销</a></li>
<% } else { %>
<li><a href="<%=request.getContextPath() %>/login.jsp">登录</a></li>
<li><a href="<%=request.getContextPath() %>/register.jsp">注册</a></li>
<%} %>
</ul>
</div>
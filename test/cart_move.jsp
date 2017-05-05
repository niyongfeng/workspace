<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" errorPage="" %>
<%
Vector cart=(Vector)session.getAttribute("cart");
try{
	int id=Integer.parseInt(request.getParameter("ID"));
	cart.removeElementAt(id);
	session.setAttribute("cart",cart);
	response.sendRedirect("cart_see.jsp");
	}catch(Exception e){
}
%>

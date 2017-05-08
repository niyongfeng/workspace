<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getParameter("word")%>查询结果</title>
</head>
<body>
<h1><%=request.getParameter("word")%>查询结果是：</h1>
<hr>
<h3>
<%=request.getAttribute("result") %>
</h3>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<%  
		String user = request.getParameter("user");
        session.setAttribute("username", user);  
        String userId = request.getParameter("userId");
        session.setAttribute("userId", userId);
        String permission = request.getParameter("permission");
        session.setAttribute("permission", permission);
        response.sendRedirect("/xiaohoo-admin/view/starter.jsp");
%>  
</body>
</html>
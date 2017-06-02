<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Pleae Login</h2>
<p><font color="red">${errorMessage}</font></p>
<form action="login" method="post" >
<p>
Name:<br>
<input type="text" name="login">
</p>
<p>
Password:<br>
<input type="password" name="password">
</p>
<p><input type="submit" value="submit"></p>
</form>
</body>
</html>

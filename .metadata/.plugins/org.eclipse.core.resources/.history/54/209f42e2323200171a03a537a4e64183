<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
html,body{padding:0; margin:0;}
.d2{
position:relative;
width:1300px;
/*height:180px;*/
text-align:center;
line-height:40px;
margin:0 auto;
}
</style>
<title>第一天的网站</title>
</head>
<body>
<form action="AddServlet" method="get">
<div class="d2">
<input id = "1" name = "data1" type="text" placeholder = "请输入数字"></input>
<label>+</label>
<input id = "2" name = "data2" type="text" placeholder = "请输入数字"></input>
<p id = "3">计算结果</p>
</div>
<div class="d2">
<button type="button" onclick="jj()">计算</button>
</div>
</form>
<script>
function jj(){
	var x = document.getElementById("data1");
	var y = document.getElementById("data2");
	console.log(x + ":" + y);
	alert(x + ":" + y);
	document.getElementById('3').innerHTML = x + y;
}
</script>
</body>
</html>
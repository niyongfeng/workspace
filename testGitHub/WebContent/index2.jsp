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
width:800px;
/*height:180px;*/
text-align:center;
line-height:40px;
margin:0 auto;
}
</style>
<title>第一天的网站</title>
</head>
<body>
<div class="d2">
<form action="AddServlet" method="get">
<h1>加法计算器</h1>
<input id = "1" style="width:100px;height:30px;font-size:17px;" type="text" placeholder = "请输入数字"></input>
<label>+</label>
<input id = "2" style="width:100px;height:30px;font-size:17px;" type="text" placeholder = "请输入数字"></input>
<p id = "3" style="font-size:17px;">计算结果</p>
<button style="width:100px;height:30px;font-size:17px;" type="button" onclick="jj()">计算</button>
</form>
</div>
<script>
function jj(){
	var x = document.getElementById('1').value;
	var y = document.getElementById('2').value;
	if(checkNumber(x) && checkNumber(y)) {
		document.getElementById('3').innerHTML = "计算结果:" + (parseInt(x) + parseInt(y));
	}else {
		alert("非法数字！");
	}
}
function checkNumber(str)
{
    var reg = /^[0-9]+$/;
    if(!reg.test(str))
    {
        return false;
    }
    return true;
}
</script>
</body>
</html>
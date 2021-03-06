<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.nyf.pojo.*"%>
<%
	List list = (List) request.getAttribute("list");
%>
<%
	List list1 = (List) request.getSession().getAttribute("list1");
%>
<%
	List list3 = (List) request.getAttribute("product");
	Product product = new Product();
	if(list3.size() != 0) {
		product = (Product)list3.get(0);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico"> -->

<title>轻课商城</title>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="navbar.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
html, body {
	padding: 0;
	margin: 0;
}

.d1 {
	width: 600px;
	height: 80px;
	text-align: center;
	line-height: 40px;
	margin: 0 auto;
}
</style>
</head>

<body>
	<h2 style="text-align: center">添加商品</h2>
	<form action="AddServlet" method="post">
	<%if(product != null) {%>
	<input name ="type" type="hidden" value = "<%=product.getId()%>"/>
	<%}%>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品名&nbsp;&nbsp;&nbsp;</span>
			<input  name="title" type="text" class="form-control" placeholder="输入商品名"
				aria-describedby="sizing-addon1" style="width: 500px" value="<%=product.getTitle()%>">
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品编号</span> <input name="code"
				type="text" class="form-control" placeholder="输入商品编号"
				aria-describedby="sizing-addon1" style="width: 500px" value="<%=product.getCode()%>">
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品描述</span> <input name="description"
				type="text" row="5" class="form-control" placeholder="输入商品描述"
				aria-describedby="sizing-addon1" style="width: 500px" value="<%=product.getDescription()%>">
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品分类</span><select
				name="tag_id" class="form-control input-sm"
				style="width: 500px" value="<%=product.getTag_id()%>">
				<%
					for (Object ob : list1) {
						Tag tag = (Tag) ob;
				%>
				<%if(product.getTag_id() == tag.getId()) {%>
				<option value="<%=tag.getId()%>" selected="selected"><%=tag.getName()%></option>
				<%}else { %>
				<option value="<%=tag.getId()%>"><%=tag.getName()%></option>
				<%
				}}
				%>
			</select>
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品价格</span> <input name="price"
				type="number" class="form-control" placeholder="输入商品价格"
				aria-describedby="sizing-addon1" style="width: 500px" step="0.01" value="<%=product.getPrice()%>">
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">商品库存</span> <input name="number"
				type="number" class="form-control" placeholder="输入商品库存"
				aria-describedby="sizing-addon1" style="width: 500px" step="0.01" value="<%=product.getNumber()%>">
		</div>
	</div>
	<div class="d1">
		<div class="input-group input-group-lg">
			<span class="input-group-addon">图片地址</span> <input name="picture" 
				type="text" class="form-control" placeholder="输入商品地址url"
				aria-describedby="sizing-addon1" style="width: 500px" value="<%=product.getPicture()%>">
		</div>
	</div>

	<div class="d1">
		
			<button class="btn btn-primary" type="submit"
				style="width: 100px; height: 45px; font-size: 20px">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="product">
				<button class="btn btn-primary" type="button"
				style="width: 100px; height: 45px; font-size: 20px">返回</button></a>
		
	</div>
	</form>
	<!-- /container -->



	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
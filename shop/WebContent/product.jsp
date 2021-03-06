<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.nyf.pojo.*"%>
<%
	List list = (List) request.getAttribute("list");
%>
<%
	List list1 = (List) request.getSession().getAttribute("list1");
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

<!-- 浮动窗口样式css begin -->
<style type="text/css">
#msg_win {
  border: 1px solid #A67901;
  background: #EAEAEA;
  width: 240px;
  position: absolute;
  right: 0;
  font-size: 12px;
  font-family: Arial;
  margin: 0px;
  display: none;
  overflow: hidden;
  z-index: 99;
}
#msg_win .icos {
  position: absolute;
  top: 2px;
  *top: 0px;
  right: 2px;
  z-index: 9;
}
.icos a {
  float: left;
  color: #833B02;
  margin: 1px;
  text-align: center;
  font-weight: bold;
  width: 14px;
  height: 22px;
  line-height: 22px;
  padding: 1px;
  text-decoration: none;
  font-family: webdings;
}
.icos a:hover {
  color: #fff;
}
#msg_title {
  background: #BBDEF6;
  border-bottom: 1px solid #A67901;
  border-top: 1px solid #FFF;
  border-left: 1px solid #FFF;
  color: #000;
  height: 25px;
  line-height: 25px;
  text-indent: 5px;
}
#msg_content {
  margin: 5px;
  margin-right: 0;
  width: 230px;
  height: 126px;
  overflow: hidden;
}
</style>
<!-- 浮动窗口样式css end -->
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
<script src="javascripts/jquery-1.9.0.min.js" type="text/javascript"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]-->
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <!--[endif]-->
</head>

<body>

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">轻课商城</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#">热销商品</a></li>
					<li><a href="#">热门活动</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./">个人中心 <span class="sr-only">(current)</span></a></li>
					<li><a href="../navbar-static-top/">购物车</a></li>
					<li><a href="ExitServlet">退出</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h3>热门商品</h3>
			<p>不要998！不要998！只要99！只要99</p>
		</div>
		<!-- <label>我的购物车：</label>
		<div id = "cart"></div> -->
		<hr/>
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<form class="form-inline" action="SearchServlet" method="get">
					<div class="form-group">
						<input type="text" name="searchKey" class="form-control"
							id="searchKey" placeholder="搜搜看"> <select id="tag_id"
							name="tag_id" class="form-control input-sm">
							<%
								for (Object ob : list1) {
									Tag tag = (Tag) ob;
							%>
							<option value="<%=tag.getId()%>"><%=tag.getName()%></option>
							<%
								}
							%>
						</select>
						<button type="submit" class="btn btn-default">搜一下</button>
					</div>
				</form>
			</div>
			<div class="btn-group">
				<button class="btn btn-default btn-sm dropdown-toggle" type="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					管理员操作<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" >
				<li class="active"><a href="add.jsp">添加商品<span class="sr-only"></span></a></li>
				</ul>
			</div>
		</div>
		<hr />
		<div class="row">
			<%
				if (list.size() == 0) {
			%>
			<p style="text-align: center">搜索无结果！</p>
			<%
				}
			%>
			<%
				for (Object ob : list) {
					Product product = (Product) ob;
			%>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img src="<%=product.getPicture()%>" alt="...">
					<div class="caption">
						<h3 style="text-align: center"><%=product.getTitle()%></h3>
						<p id = "price" style="text-align: center">
							价格：<%=product.getPrice()%>&nbsp;&nbsp;&nbsp;数量：<%=product.getNumber()%></p>
						<p style="text-align: center">
							<a href="AddServlet?id=<%=product.getId()%>" class="btn btn-primary" role="button">修改商品</a>&nbsp;&nbsp;
							<a href="DeleteServlet?id=<%=product.getId()%>" class="btn btn-default" role="button">删除商品</a><br/><br/>
							<a href="#" class="btn btn-default addCart" role="button">添加购物车</a>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<script type="text/javascript">
		$(".addCart").click(function (){
			alert("添加到购物车");
			var parent = $(this).parents(".thumbnail");
			console.log(parent);
			var children = parent.children("div");
			var title = children.children("h3").text();
			var priceAndNumber = children.children("#price").text();
			var price = priceAndNumber.substring(priceAndNumber.indexOf("：") + 1,priceAndNumber.indexOf("数量"));
			var number = 1;
			var str = "<tr><td>" + title + "</td><td>" + number + "</td><td>" + price +"</td></tr>";
			$("#cart").after(str);
		});
	</script>
	
	<!-- 浮动窗口html代码 begin -->
<hr>
<div id="msg_win" style="display: block; top: 490px; visibility: visible; opacity: 1;">
 <div class="icos">
  <a id="msg_min" title="最小化" href="javascript:void 0" >_</a><a id="msg_close" title="关闭" href="javascript:void 0">x</a>
 </div>
 <div id="msg_title">我的购物车</div>
 <div style="overflow: auto; height: 150px; width: 100%; white-space: nowrap">
 	<table class="table">
 		<thead>
 			<tr title="" id="cart"><th>商品名</th><th>数量</th><th>单价</th></tr>
 		</thead>
 	</table>
 </div>
</div>
<!-- 浮动窗口html代码 end -->
	
	<!-- 浮动窗口js，必须要放置到最后 begin-->
<script type="text/javascript">
var Message={
  set: function() {//最小化与恢复状态切换
    var set=this.minbtn.status == 1?[0,1,'block',this.char[0],'最小化']:[1,0,'none',this.char[1],'展开'];
    this.minbtn.status=set[0];
    this.win.style.borderBottomWidth=set[1];
    this.content.style.display =set[2];
    this.minbtn.innerHTML =set[3]
    this.minbtn.title = set[4];
    this.win.style.top = this.getY().top;
  },
  close: function() {//关闭
    this.win.style.display = 'none';
    window.onscroll = null;
  },
  setOpacity: function(x) {//设置透明度
    var v = x >= 100 ? '': 'Alpha(opacity=' + x + ')';
    this.win.style.visibility = x<=0?'hidden':'visible';//IE有绝对或相对定位内容不随父透明度变化的bug
    this.win.style.filter = v;
    this.win.style.opacity = x / 100;
  },
  show: function() {//渐显
    clearInterval(this.timer2);
    var me = this,fx = this.fx(0, 100, 0.1),t = 0;
    this.timer2 = setInterval(function() {
      t = fx();
      me.setOpacity(t[0]);
      if (t[1] == 0) {clearInterval(me.timer2) }
    },10);
  },
  fx: function(a, b, c) {//缓冲计算
    var cMath = Math[(a - b) > 0 ? "floor": "ceil"],c = c || 0.1;
    return function() {return [a += cMath((b - a) * c), a - b]}
  },
  getY: function() {//计算移动坐标
    var d = document,b = document.body, e = document.documentElement;
    var s = Math.max(b.scrollTop, e.scrollTop);
    var h = /BackCompat/i.test(document.compatMode)?b.clientHeight:e.clientHeight;
    var h2 = this.win.offsetHeight;
    return {foot: s + h + h2 + 2+'px',top: s + h - h2 - 2+'px'}
  },
  moveTo: function(y) {//移动动画
    clearInterval(this.timer);
    var me = this,a = parseInt(this.win.style.top)||0;
    var fx = this.fx(a, parseInt(y));
    var t = 0 ;
    this.timer = setInterval(function() {
      t = fx();
      me.win.style.top = t[0]+'px';
      if (t[1] == 0) {
        clearInterval(me.timer);
        me.bind();
      }
    },10);
  },
  bind:function (){//绑定窗口滚动条与大小变化事件
    var me=this,st,rt;
    window.onscroll = function() {
      clearTimeout(st);
      clearTimeout(me.timer2);
      me.setOpacity(0);
      st = setTimeout(function() {
      me.win.style.top = me.getY().top;
      me.show();
      },600);
    };
    window.onresize = function (){
      clearTimeout(rt);
      rt = setTimeout(function() {me.win.style.top = me.getY().top},100);
    }
  },
  init: function() {//创建HTML
    function $(id) {return document.getElementById(id)};
    this.win=$('msg_win');
    var set={minbtn: 'msg_min',closebtn: 'msg_close',title: 'msg_title',content: 'msg_content'};
    for (var Id in set) {this[Id] = $(set[Id])};
    var me = this;
    this.minbtn.onclick = function() {me.set();this.blur()};
    this.closebtn.onclick = function() {me.close()};
    this.char=navigator.userAgent.toLowerCase().indexOf('firefox')+1?['_','::','×']:['0','2','r'];//FF不支持webdings字体
    this.minbtn.innerHTML=this.char[0];
    this.closebtn.innerHTML=this.char[2];
    setTimeout(function() {//初始化最先位置
      me.win.style.display = 'block';
      me.win.style.top = me.getY().foot;
      me.moveTo(me.getY().top);
    },0);
    return this;
  }
};
Message.init();
</script>
<!-- 浮动窗口js end-->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script> -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
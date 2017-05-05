<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>BOS-员工登录</title>
		<link href="${path}/logo.ico" rel="shortcut icon" type="image/x-icon" />
		<link type="text/css" rel="stylesheet" href="${path}/css/style.css" />
		<link type="text/css" rel="stylesheet" href="${path}/css/style_grey.css" />
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<style>
			input[type=text] {
				width: 80%;
				height: 25px;
				font-size: 12pt;
				font-weight: bold;
				margin-left: 45px;
				padding: 3px;
				border-width: 0;
			}
			input[type=password] {
				width: 80%;
				height: 25px;
				font-size: 12pt;
				font-weight: bold;
				margin-left: 45px;
				padding: 3px;
				border-width: 0;
			}
		</style>
		<script type="text/javascript">
			//$.messager.defaults.ok = '确定';
			
			/** 登录窗口不能被其它窗口包含 */
			if (window != parent){
				parent.location = window.location;
			}
			/** 判断用户是否登录 */
			if ("${session_user}" != ""){
				window.location.href = "${path}/main.jspx";
			}
		
			/** 文档加载完 */
			$(window).ready(function(){
				/** 获取验证图片绑定onmouseover 与 onclick */
				$("#see").mouseover(function(){
					// this: dom元素   光标变成手状
					$(this).css("cursor", "pointer");
				}).click(function(){ // onclick
					// 让src重新请求一次
					$(this).attr("src", "${path}/verify.jspx?random=" + Math.random());
				});
				
				
				/** 为登录按钮绑定点击事件 */
				$("#loginBtn").on("click", function(){
					/** 表单校验 */
					var userId = $("#userId");
					var password = $("#password");
					var vcode = $("#vcode");
					var msg = "";
					var obj = null;
					if ($.trim(userId.val()) == ""){
						msg = "账号不能为空！";
						obj = userId;
					}else if (!/^\w{5,20}$/.test($.trim(userId.val()))){
						msg = "账号格式不正确！";
						obj = userId;
					}else if ($.trim(password.val()) == ""){
						msg = "密码不能为空！";
						obj = password;
					}else if (!/^\w{6,20}$/.test($.trim(password.val()))){
						msg = "密码格式不正确！";
						obj = password;
					}else if ($.trim(vcode.val()) == ""){
						msg = "验证码不能为空！";
						obj = vcode;
					}else if (!/^[a-zA-Z0-9]{4}$/.test($.trim(vcode.val()))){
						msg = "验证码格式不正确！";
						obj = vcode;
					}
					if (msg != ""){
						if (window.isFlag){
							window.isFlag = false;
							setTimeout(function(){
								/** 监听消息窗口的关闭事件 */
								$.messager.alert("警告信息", msg, "warning").window({
									onClose : function(){
										obj.focus(); // 获取焦点
										window.isFlag = true;
									}
								});
							}, 1);
						}
					}else{
						/** 获取表单中的请求参数 */
						var params = $("#loginform").serialize();
						// userId=admin&password=111111&vcode=2455&key=1
						/** 异步请求登录 */
						$.ajax({
							url : "${path}/login.jspx", // 请求URL
							type : "post", // 请求方式post|get
							data : params, // 请求参数 key=value&key=value|{key:value,key:value}|[{key:value,key:value},{key:value,key:value}]
							dataType : "json", // 指定服务器响应回来的数据类型
							async : true,  // true:异步请求中异步(不等待响应数据)   false:异步请求中同步(等待响应数据)
							success : function(data){ // 请求成功
								// data: 服务器响应回来的数据
								// data: json {status : 0, tip : ""}
								//alert(data);
								/** 在控制台输出日志 */
								//console.log(data);
								if (data.status == 0){
									window.location.href = "${path}/main.jspx";
								}else{
									/** 让验证码变一下 */
									$("#see").trigger("click");
									$.messager.alert("提示信息", data.tip, "info");
								}
							},
							error : function(){ // 请求出错
								$.messager.alert("错误信息", "亲，网络出现了异常！", "error");
							}
						});
					}
				});
				
				/** 定义标记 */
				window.isFlag = true;
				/** 监听回车键  onkeydown */
				$(document).keydown(function(event){
					// event：事件对象
					// keyCode : 按键对应的代号 13 回车键
					if(event.keyCode === 13 && window.isFlag){
						/** 事件主动触发 */
						$("#loginBtn").trigger("click");
					}
				});
				
				/** 为忘记密码a标签绑定点击事件 */
				$("#findPwd").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成dialog */
					divDialog.dialog({
						title : "找回密码", // 标题
						width : 330, // 宽度
						height : 190, // 高度
						modal : true // 模态窗口
					});
					/** 创建iframe子窗口 */
					$("<iframe width='100%' height='100%' frameborder='0'/>")
					  .prop("src", "${path}/showFindPassword.jspx")
					  .appendTo(divDialog);
				});
			});
			
		</script>
	</head>
<body style="background-color: #E6E6FA;">
	<div style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: -280px;">
		<span style="float: right; margin-top: 35px; color: #488ED5;">新BOS系统，致力于便捷、安全、稳定等方面的客户体验</span>
	</div>
	
	<div class="main-inner" id="mainCnt"
		style="width: 900px; height: 440px; overflow: hidden; position: absolute; left: 50%; top: 50%; margin-left: -450px; margin-top: -220px; background-image: url('images/bg_login.jpg')">
		<div id="loginBlock" class="login"
			style="margin-top: 80px; height: 255px;">
			<div class="loginFunc">
				<div id="lbNormal" class="loginFuncMobile">员工登录</div>
			</div>
			
			<div class="loginForm">
				<form id="loginform" method="post" class="niceform">
				
					<div id="idInputLine" class="loginFormIpt showPlaceholder"
						style="margin-top: 5px;">
						<input id="userId" type="text" name="userId" class="loginFormTdIpt" maxlength="50" />
						<label for="idInput" class="placeholder" id="idPlaceholder">账号：</label>
					</div>
					<div class="forgetPwdLine"></div>
					
					
					<div id="pwdInputLine" class="loginFormIpt showPlaceholder">
						<input id="password" class="loginFormTdIpt" type="password" name="password"/>
						<label for="pwdInput" class="placeholder" id="pwdPlaceholder">密码：</label>
					</div>
					
					<div class="loginFormIpt loginFormIptWiotTh" style="margin-top:58px;">
						<div id="codeInputLine" class="loginFormIpt showPlaceholder"
							style="margin-left:0px;margin-top:-40px;width:50px;">
							<input id="vcode" class="loginFormTdIpt" type="text"
								name="vcode" title="请输入验证码" style="margin-left: 1px;margin-top: 1px;"/>
							<img id="see" src="${path}/verify.jspx" width="75"
								style="margin: 0px 0 0 60px;height:32px;"/>
						</div>
						<span id="loginBtn" class="btn btn-login"
								style="margin-top:-36px;">登录</span>
					</div>
					
					<div class="loginFormIpt loginFormIptWiotTh"
						style="margin-top:8px;font-size:14px;">
						<input type="checkbox" name="key" value="1"/>
						<font color="#888">记住用户</font>&nbsp;
						&nbsp;
						<a href="javascript:;" id="findPwd" style="padding-left: 100px;">忘记密码</a>
						<font color="red"></font>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: 220px;">
		<span style="color: #488ED5;">Powered By www.itcast.cn</span><span
			style="color: #488ED5;margin-left:10px;">推荐浏览器（右键链接-目标另存为）：<a
			href="http://download.firefox.com.cn/releases/full/23.0/zh-CN/Firefox-full-latest.exe">Firefox</a>
		</span>
	</div>
</body>
</html>
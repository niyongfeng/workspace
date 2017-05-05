<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>BOS-便捷、安全、稳定</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
		<meta name="Keywords" content="keyword1,keyword2,keyword3"/>
		<meta name="Description" content="网页信息的描述" />
		<meta name="Author" content="itcast.cn" />
		<meta name="Copyright" content="All Rights Reserved." />
		<link rel="shortcut icon" type="image/x-icon" href="${path}/logo.ico"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/default.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.rules.js"></script>
		<script type="text/javascript" src="${path}/js/jquery-timer-1.0.js"></script>
		<script type="text/javascript">
			$(function(){
				
				/** 为获取验证码按钮绑定点击事件 */
				$("#verifyBtn").click(function(){
					/** 获取手机号码 */
					var phone = $("#phone").val();
					var msg = "";
					if ($.trim(phone) == ""){
						msg = "手机号码不能为空！";
					}else if(!/^1[3|5|7|8]\d{9}$/.test($.trim(phone))){
						msg = "手机号码格式不正确！";
					}
					if (msg != ""){
						alert(msg);
					}else{
						/** 异步发送短信验证码 */
						$.post("${path}/sendSmsVerifyCode.jspx", {"phone" : phone}, function(data,status){
							if (status == "success"){
								// data : 1 成功、 0 失败
								if (data == 1){
									/** 禁用按钮 */
									$("#verifyBtn").downcount("{0}秒后，重新获取!", 60);
								}
							}
						}, "json");
					}
				});
				
				/** 为确定按钮绑定点击事件 */
				$("#submitBtn").click(function(){
					
					/** 获取表单，开启校验 */
					var validate = $("#verifySmsForm").form("enableValidation") // 启用验证
					               			    .form("validate");// 做校验 true:通过  false: 不通过
					if (validate){
						/** 
						 * 第一个参数：请求URL
						 * 第二个参数：请求参数 key=value&key=value | {key:value,key:value}
						 * 第三个参数：回调函数
						 * 第四个参数：服务器响应回来的数据类型
						 */
						 var params = $("#verifySmsForm").serialize(); // 把表单序列化成get请求参数字符串
						 $.post("${path}/verifyFindPwdSms.jspx",params,function(data,status){
							// status : success、error 状态码
							if (status == "success"){
								if (data == 1){
									window.location.href = "${path}/smsPassword.jspx";
								}else{
									$("#tip").text("验证失败！");
								}
							}
						 },"json");
					}
					
				});
				
			});
			
		</script>
	</head>
	<body>
		<form id="verifySmsForm" class="easyui-form"  data-options="novalidate:true">
			<table align="center" cellpadding="4" style="padding-top: 2px;">
				<tr>
					<td>用户账号：</td>
					<td><input type="text" name="userId" class="easyui-textbox" size="28"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'用户账号不能为空！'"
							validType="length[5,20]"
							invalidMessage="用户账号格式不正确！"/></td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input type="text" id="phone" 
							name="phone" class="easyui-textbox" size="28"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'手机号码不能为空！'"
							validType="phone"/></td>
				</tr>
				<tr>
					<td>验证码：</td>
					<td><input type="text" name="verifyCode" class="easyui-textbox" size="28"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'验证码不能为空！'"
							validType="regex['\\d{6}']"
							invalidMessage="验证码格式不正确！"/></td>
				</tr>
				
				<tr align="center">
					<td colspan="2">
						<input id="verifyBtn" type="button" value="获取验证码"/>
						<input id="submitBtn" type="button" value="确定"/>
						&nbsp;<font id="tip" color="red"></font>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
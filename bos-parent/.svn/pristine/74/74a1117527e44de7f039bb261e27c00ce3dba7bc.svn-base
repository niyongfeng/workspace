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
		<script type="text/javascript">
			$(function(){
				/** 为添加按钮绑定点击事件 */
				$("#submitBtn").click(function(){
					/** 获取表单，开启校验 */
					var validate = $("#roleForm").form("enableValidation") // 启用验证
					               			    .form("validate");// 做校验 true:通过  false: 不通过
					if (validate){
						/** 
						 * 异步添加职位 
						 * 第一个参数：请求URL
						 * 第二个参数：请求参数 key=value&key=value | {key:value,key:value}
						 * 第三个参数：回调函数
						 * 第四个参数：服务器响应回来的数据类型
						 */
						 var params = $("#roleForm").serialize(); // 把表单序列化成get请求参数字符串
						 $.post("${path}/identity/updateRole.jspx",params,function(data,status){
							// status : success、error 状态码
							// data : 响应数据 {}、[]、[{},{}]、1、true $.parseJSON() 1或0
							if (status == "success"){
								$("#tip").text(data == 1 ? "修改成功！" : "修改失败！");
							}
						 },"json");
					}
					
				});
				
				/** 为重置按钮绑定点击事件 */
				$("#resetBtn").click(function(){
					$("#roleForm").form("reset") // 重置
					             .form("disableValidation"); // 禁用验证 
				});
			});
			
		</script>
	</head>
	<body>
		<form id="roleForm" class="easyui-form"  data-options="novalidate:true">
			<input type="hidden" name="role.id" value="${role.id }"/>
			<table align="center" cellpadding="2" style="padding-top: 2px;">
				<tr>
					<td>代号：</td>
					<td><input type="text" name="role.code" class="easyui-textbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'代号不能为空！'"
						    value="${role.code }"/></td>
				</tr>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="role.name" class="easyui-textbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'名称不能为空！'"
							value="${role.name }"/></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><textarea type="text" 
					    style="width:252px;height:83px;"
					    name="role.remark"
						class="easyui-validatebox"
						data-options="required:true,
									  tipPosition:'bottom',
									  missingMessage:'备注不能为空！'">${role.remark}</textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<a class="easyui-linkbutton" id="submitBtn" data-options="iconCls:'icon-ok'">修改</a>
						<a class="easyui-linkbutton" id="resetBtn" data-options="iconCls:'icon-no'">重置</a>
						&nbsp;<font id="tip" color="red"></font>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
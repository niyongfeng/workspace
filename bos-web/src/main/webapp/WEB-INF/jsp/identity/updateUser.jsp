<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
		<link rel="shortcut icon" type="image/x-icon" href="${path}/logo.ico"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/default.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.rules.js"></script>
		
		<script type="text/javascript">
			
		
			$(function(){
				
				/** 异步加载部门与职位数据 */
				$.ajax({
					url : "${path}/identity/loadDeptJob.jspx",
					type : "post",
					dataType : "json",
					async : true,
					success : function(data){ // 请求成功
						// data: {"depts" : [{id:1,name:''},{}], "jobs" : [{id:1,name:''},{}]}
						/** 部门下拉列表 */
						$("#deptSelect").combobox({
							width : 140,
							valueField : 'id',
							textField : 'name',
							data : data.depts, // [{id:1,name:''},{}]
							panelHeight : 100,
							editable : false,
							value : '${user.dept.id}' // 取第一个json对象的id值(第一个option就选中)
						});
						/** 职位下拉列表 */
						$("#jobSelect").combobox({
							width : 140,
							valueField : 'id',
							textField : 'name',
							data : data.jobs, // [{id:1,name:''},{}]
							panelHeight : 100,
							editable : false,
							value : "${user.job.id}" // 取第一个json对象的id值(第一个option就选中)
						});
					},
					error : function(){// 请求失败
						$.messager.alert("错误提示","网络可能存在问题！", "error");
					}
				});
				
				/** 为添加按钮绑定点击事件 */
				$("#submitBtn").click(function(){
					/** 获取表单，开启校验 */
					var validate = $("#userForm").form("enableValidation") // 启用验证
					               			     .form("validate");// 做校验 true:通过  false: 不通过
					if (validate){
						/** 验证生日 */
						var birthday = $("#birthday");
						if ($.trim(birthday.val()) == ""){
							$.messager.alert("警告信息","生日不能为空！","warning");
						}else{
							/** 
							 * 异步添加职位 
							 * 第一个参数：请求URL
							 * 第二个参数：请求参数 key=value&key=value | {key:value,key:value}
							 * 第三个参数：回调函数
							 * 第四个参数：服务器响应回来的数据类型
							 */
							 var params = $("#userForm").serialize(); // 把表单序列化成get请求参数字符串
							 $.post("${path}/identity/updateUser.jspx",params,function(data,status){
								// status : success、error 状态码
								// data : 响应数据 {}、[]、[{},{}]、1、true $.parseJSON() 1或0
								if (status == "success"){
									$("#tip").text(data == 1 ? "修改成功！" : "修改失败！");
								}
							 },"json");
						}
					}
				});
				
				/** 为重置按钮绑定点击事件 */
				$("#resetBtn").click(function(){
					$("#userForm").form("reset") // 重置
					              .form("disableValidation"); // 禁用验证 
				});
			});
			
			
		</script>
	</head>
	<body>
		<form id="userForm" class="easyui-form" data-options="novalidate:true">
			<input type="hidden" name="user.userId" value="${user.userId}"/>
			<table align="center" cellpadding="2px" >
				<tr>
					<td>登&nbsp;录&nbsp;名：</td>
					<td>
						<input type="text"
							    disabled="xxx"
								size="18"
								class="easyui-textbox"
								data-options="required:true"
								missingMessage="登录名不能为空！"
								validType="length[5,20]"
								invalidMessage="登录名长度必须在5-20位之间！"
								value="${user.userId}"/>
					</td>
					<td>用户姓名：</td>
					<td>
						<input type="text" id="name" 
							   name="user.name" size="18"
							   class="easyui-textbox"
							   data-options="required:true"
							   missingMessage="用户姓名不能为空！"
							   value="${user.name}"/>
					</td>
				</tr>
				
				<tr>
					<td>性别：</td>
					<td>
						<select name="user.sex" class="easyui-combobox" 
							data-options="width:100,value:${user.sex},editable:false" 
							panelHeight="60">
							<option value="1">男</option>
							<option value="2">女</option>
						</select>
					</td>
					<td>部&nbsp;&nbsp;门：</td>
					<td>
						<select id="deptSelect" name="user.dept.id"></select>
					</td>
				</tr>
	
				<tr>
					<td>职&nbsp;&nbsp;位：</td>
					<td>
						<select id="jobSelect" name="user.job.id"></select>
					</td>
					<td>邮&nbsp;&nbsp;箱：</td>
					<td>
						<input type="text" 
							 	name="user.email" size="18"
							 	class="easyui-textbox"
							    data-options="required:true"
							    missingMessage="邮箱不能为空！"
							    validType="email"
							    invalidMessage="邮箱格式不正确！"
							    value="${user.email}"/>
					</td>
				</tr>
				<tr>
					<td>手&nbsp;&nbsp;机：</td>
					<td>
						<input type="text" id="phone"
							   name="user.phone" size="18"
							   class="easyui-textbox"
							   data-options="required:true"
							   missingMessage="手机不能为空！"
							   validType="phone"
							   value="${user.phone}"/>
					</td>
					<td>薪&nbsp;&nbsp;水：</td>
					<td>
						<input type="text" id="salary"
							   name="user.salary" size="18"
							   class="easyui-numberbox"
							   data-options="required:true,precision:2"
							   missingMessage="薪水不能为空！"
							   value="${user.salary}"/>
					</td>
				</tr>
				
				<tr>
					<td>生&nbsp;&nbsp;日：</td>
					<td colspan="3">
						<input type="text" id="birthday" value="${user.birthday}"
							   name="user.birthday" size="18" 
							   class="Wdate" 
							   onclick="WdatePicker({skin:'whyGreen',lang:'zh-tw',dateFmt:'yyyy-MM-dd'});"/>
						 &nbsp;<font color="red" id="tip"></font>
					</td>
				</tr>
				
				<tr>
					<td colspan="4" align="center">
						<a class="easyui-linkbutton" id="submitBtn" data-options="iconCls:'icon-ok'">修改</a>
						<a class="easyui-linkbutton" id="resetBtn" data-options="iconCls:'icon-no'">重置</a>
						&nbsp;<font id="tip" color="red"></font>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
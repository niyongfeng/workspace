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
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${path}/js/jquery.util-1.0.js"></script>
		<style type="text/css">
			/** 更改行的高度  easyui.css: 1363行 */
			.datagrid-row {
			   height: 30px;
			}
			
		</style>
		<script type="text/javascript">
			$(function(){
				/** 把表格转化成datagrid */
				$("#user_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true, // 列填充父容器
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/identity/selectUser.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "userId", checkbox : true},
					   {field : "user_id", title : "编号", width : 60, formatter : function(value, rowData){
						   return rowData.userId;
					   }},
					   {field : "name", title : "姓名", width : 60},  
					   {field : "sex", title : "性别", width : 40, formatter : function(value){
						   return ["男","女"][value - 1];
					   }},
					   {field : "deptName", title : "部门", width : 100},
					   {field : "jobName", title : "职位", width : 120},
					   {field : "phone", title : "手机号码", width : 100},
					   {field : "email", title : "邮箱", width : 120},
					   {field : "birthday", title : "生日", width : 120, formatter : function(value){
						   return value.replace("T00:00:00", "");
					   }},
					   {field : "salary", title : "薪水", width : 100},
					   {field : "status", title : "状态", width : 80, formatter : function(value){
						   // value:就是status的值 
						   // 0新建,1审核,2不通过审核,3冻结
						   return ["<font color='red'>新建</font>",
						           "<font color='blue'>审核</font>",
						           "<font color='green'>不通过</font>",
						           "<font color='#888'>冻结</font>"][value];
					   }}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 5, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1  // 设置初始化页面时，当前页码为1
				});
				
				/** 异步请求查询部门数据填充下拉列表 */
				$.ajax({
					url : "${path}/identity/loadDept.jspx", // 请求URL
					type : "post", // 请求方式
					dataType : "json", // 服务器响应回来的数据类型
					async : true, // 异步请求
					success : function(deptData){ // 请求成功
						// deptData: [{id : 1, name : ''},{id : 2, name : ''}]
					    // deptData(Array): unshift往数组最前面添加一个数组元素
					    deptData.unshift({id : 0, name : '==请选择=='});
						$("#deptSelect").combobox({
							width : 100, // 组件的宽度
							valueField : "id", // option的value
							textField : "name", // option的text
							data : deptData, // 数据[{},{}]
							panelHeight : 100, // 下拉列表面板的高度
							editable : false // 不能编辑
						});
					},
					error : function(){ // 请求失败
						$.messager.alert("错误提示", "服务器出现错误！", "error");
					}
				});
				/** 为搜索按钮绑定点击事件 */
				$("#searchBtn").click(function(){
					/** 获取查询条件 */
					var params = $("#searchForm").form2JSON();
					// alert(params["user.name"]);
					/** 传查询条件，并刷新表格
					 reload --> {"user.name" : "李"}
					*/
					$("#user_datagrid").datagrid("reload", params);
				});
				
				/** 为添加用户按钮绑定点击事件 */
				$("#addUser").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成Dialog */
					divDialog.dialog({
						title : "添加用户", // 标题
						width : 460, // 宽度
						height : 245, // 高度
						collapsible : true, // 可折叠
						modal : true, // 模态窗口
						onClose : function(){ // 关闭窗口
							/** 获取iframe对应的子窗口 */
							$("#iframe")[0].contentWindow.$dp.cal.close(); // 关闭日期
							/** 让数据表格重新加载数据 */
							$("#user_datagrid").datagrid("reload");
						}
					});
					/** 创建iframe */
					$("<iframe id='iframe' style='width:100%;height:245px;' frameborder='0'></iframe>")
					  .attr("src", "${path}/identity/showAddUser.jspx") // 设置属性
					  .appendTo(divDialog);
				});
				/** 为修改按钮绑定点击事件 */
				$("#updateUser").click(function(){
					/** 获取用户选中的行 rows: [{id:1,name:'',remark:''},{}] */
					var rows = $("#user_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要修改的行！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "修改用户", // 标题
							width : 460, // 宽度
							height : 220, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 让数据表格重新加载数据 */
								$("#user_datagrid").datagrid("reload");
							}
							
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:245px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/identity/showUpdateUser.jspx?user.userId=" + rows[0].userId) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","修改用户时，只能选择一行！","warning");
					}
				});
				
				/** 为删除按钮绑定点击事件 */
				$("#deleteUser").click(function(){
					/** 获取用户选中的行 */
					var rows = $("#user_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要删除的行！","warning");
					}else{
						$.messager.confirm("确认信息", "您确定要删除吗？", function(r){
							if (r){
								/** 定义数组封装用户主键id的值 */
								var userIds = new Array();
								for (var i = 0; i < rows.length; i++){
									userIds.push(rows[i].userId);
								}
								/** 异步请求删除用户 */
								$.post("${path}/identity/deleteUser.jspx",{userIds : userIds.join(",")},function(data, status){
									if (status == "success"){
										// data : 1 代表删除成功 0 删除失败
										$("#tip").text(data == 1 ? "删除成功！" : "删除失败！");
										if (data == 1){
											/** 让数据表格重新加载数据 */
											$("#user_datagrid").datagrid("reload");
										}
									}
								},"json");
							}
						});
					}
				});
				
				/** 为审批按钮绑定点击事件 */
				$("#checkUser").click(function(){
					
					/** 获取用户选中的行 */
					var rows = $("#user_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要审核的行！","warning");
					}else{
						/** 定义数组封装用户主键id的值 */
						var userIds = new Array();
						for (var i = 0; i < rows.length; i++){
							userIds.push(rows[i].userId);
						}
						/** 异步请求审核用户 */
						$.post("${path}/identity/checkUser.jspx",
								{userIds : userIds.join(","), 
								"user.status" : $("#status").combobox("getValue")},function(data, status){
							if (status == "success"){
								// data : 1 代表审批成功 0 审批失败
								$("#tip").text(data == 1 ? "审批成功！" : "审批失败！");
								if (data == 1){
									/** 让数据表格重新加载数据 */
									$("#user_datagrid").datagrid("reload");
								}
							}
						},"json");
					}
				});
				/** 为用户绑定角色按钮绑定点击事件 */
				$("#bindRole").click(function(){
					/** 获取用户选中的所有的行 */
					var rows = $("#user_datagrid").datagrid("getSelections");
					/** 判断是否选中了行 */
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要绑定的用户！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "绑定角色", // 标题
							width : 450, // 宽度
							height : 320, // 高度
							collapsible : true, // 可折叠
							modal : true // 模态窗口
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:320px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/identity/showBindRole.jspx?user.userId=" + rows[0].userId) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","用户绑定角色时，只能选择一行！","warning");
					}
					
				});
				
				/** 根据按钮添加分隔符 */
				/** 查询工具栏中table中的所有td，去掉第一个td与最后一个td */
				var tds = $("#toolbar > table").find("td")
								.not(":first") // 去掉第一个td
								.not(":last"); // 去掉最后一个td
				/** 判断td的个数 */
				if (tds.length > 0){
					/** 创建td添加到所有查询到得td前面(相邻元素) */
					$('<td><div class="dialog-tool-separator"></div></td>').insertBefore(tds);
				}
				/** 没有一个权限需要把工具栏中table隐藏 */
				if ($("#toolbar > table").find("td").length == 1){
					$("#toolbar > table").hide();	
				}
				
			});
		</script>
	</head>
	<body class="easyui-layout">
	
		<!-- 定义数据表格中的工具栏容器 -->
		<div id="toolbar">
			<!-- 按钮区 -->
			<table>
				<tr>
					
					<!-- 判断用户是否有添加的权限 -->
					<shiro:hasPermission name="user:add">
						<td>
							<a class="easyui-linkbutton" id="addUser" data-options="iconCls:'icon-add'">添加</a>
						</td>
					</shiro:hasPermission>
					
					<!-- 判断用户是否有修改的权限 -->
					<shiro:hasPermission name="user:update">
						<td>
							<a class="easyui-linkbutton" id="updateUser" data-options="iconCls:'icon-edit'">修改</a>
						</td>
					</shiro:hasPermission>
					
					<!-- 判断用户是否有删除的权限 -->
					<shiro:hasPermission name="user:delete">
						<td>
							<a class="easyui-linkbutton" id="deleteUser" data-options="iconCls:'icon-remove'">删除</a>
						</td>
					</shiro:hasPermission>
					
					<!-- 判断用户是否有审核的权限 -->
					<shiro:hasPermission name="user:check">
						<td>
							<!-- 
								panelHeight: 下拉列表面板的高度
								editable: 是否可以编辑
							 -->
							审批状态：<select class="easyui-combobox" id="status"
									data-options="panelHeight:75,editable:false">
									<option value="1">审核</option>
									<option value="2">不通过</option>
									<option value="3">冻结</option>
								</select>
							<a class="easyui-linkbutton" id="checkUser" data-options="iconCls:'icon-edit'">审批</a>
						</td>
					</shiro:hasPermission>
					
					<!-- 判断用户是否有绑定的权限 -->
					<shiro:hasPermission name="user:bind">
						<td>
							<a class="easyui-linkbutton" id="bindRole" data-options="iconCls:'icon-ok'">绑定角色</a>
						</td>
					</shiro:hasPermission>
					<td>&nbsp;<font id="tip" color="red"></font></td>
				</tr>
			</table>
			
			<!-- 查询区 -->
			<form id="searchForm" style="background-color: #fff;border-top: 1px solid #ccc;">
				<table>
					<tr>
						<td>姓名：<input type="text" name="user.name" class="easyui-textbox" size="15"/></td>
						<td>手机号码：<input type="text" name="user.phone"  class="easyui-textbox" size="15"/></td>
						<td>部门：<select id="deptSelect" name="user.dept.id" ></select></td>
						<td>
							<a class="easyui-linkbutton" id="searchBtn" 
								data-options="iconCls:'icon-search'">搜索</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<!-- 数据表格 -->
		<table id="user_datagrid">
		</table>
	</body>
</html>
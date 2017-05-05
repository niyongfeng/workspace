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
		<style type="text/css">
			/** 更改行的高度  easyui.css: 1363行 */
			.datagrid-row {
			   height: 30px;
			}
			
		</style>
		<script type="text/javascript">
			$(function(){
				/** 把表格转化成datagrid */
				$("#role_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true,// 列自适应父容器
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/identity/selectAllRole.jspx?userId=${user.userId}", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "id", checkbox : true},  // 指定id列的信息
					   {field : "code", title : "代号", width : 60},   // 指定code列的信息
					   {field : "name", title : "名称", width : 100},   // 指定name列的信息
					   {field : "remark", title : "备注", width : 100}  // 指定remark列的信息
					]],
					onLoadSuccess : function(data){ // 数据加载成功的时候触发
						// data : {"rows" : [{},{}]}
						// 迭代所有行
						$.each(data.rows, function(i){
							// this : 数组元素{} 一行
							if (this.checked){ // 代表这一行需要选中
								/** 选中一行 */
								$("#role_datagrid").datagrid("selectRow", i);
							}
						});
					}
				});
				
				
				/** 为绑定角色按钮绑定点击事件 */
				$("#bindRole").click(function(){
					/** 获取用户选中的行 */
					var rows = $("#role_datagrid").datagrid("getSelections");
					
					/** 定义数组封装角色主键id的值 */
					var ids = new Array();
					for (var i = 0; i < rows.length; i++){
						ids.push(rows[i].id);
					}
					/** 异步请求绑定角色 */
					$.post("${path}/identity/bindRole.jspx",
							{"user.userId" : "${user.userId}",ids : ids.join(",")},function(data, status){
						if (status == "success"){
							// data : 1 代表删除成功 0 删除失败
							$("#tip").text(data == 1 ? "绑定成功！" : "绑定失败！");
							if (data == 1){
								/** 让数据表格重新加载数据 */
								$("#role_datagrid").datagrid("reload");
							}
							setTimeout(function(){
								$("#tip").text("");
							},2000);
						}
					},"json");
				});				
				
			});
		</script>
	</head>
	<body class="easyui-layout">
	
		<!-- 定义数据表格中的工具栏容器 -->
		<div id="toolbar">
			<table>
				<tr>
					<td>
						<a class="easyui-linkbutton" id="bindRole" data-options="iconCls:'icon-ok'">绑定</a>
						&nbsp;<font id="tip" color="red"></font>
					</td>
					
				</tr>
			</table>
		</div>
		
		<!-- 数据表格 -->
		<table id="role_datagrid">
		</table>
	</body>
</html>
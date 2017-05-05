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
				$("#customer_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true,// 列自适应父容器
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/basic/selectUnRelationCustomer.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "id", checkbox : true},  // 指定id列的信息
					   {field : "name", title : "姓名", width : 30},   // 指定code列的信息
					   {field : "phone", title : "手机号码", width : 60},   // 指定name列的信息
					   {field : "station", title : "所属单位", width : 60},
					   {field : "address", title : "联系地址", width : 100}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 5, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1  // 设置初始化页面时，当前页码为1
				});
				
				
				/** 为关联客户按钮绑定点击事件 */
				$("#relationCustomer").click(function(){
					/** 获取用户选中的行 */
					var rows = $("#customer_datagrid").datagrid("getSelections");
					if (rows.length > 0){
						/** 定义数组封装客户主键id的值 */
						var ids = new Array();
						for (var i = 0; i < rows.length; i++){
							ids.push(rows[i].id);
						}
						/** 异步请求关联客户 */
						$.post("${path}/basic/relationCustomer.jspx",
								{"fixedArea.id" : "${fixedArea.id}",ids : ids.join(",")},function(data, status){
							if (status == "success"){
								// data : 1 代表关联成功 0 关联失败
								$("#tip").text(data == 1 ? "关联成功！" : "关联失败！");
								if (data == 1){
									/** 让数据表格重新加载数据 */
									$("#customer_datagrid").datagrid("reload");
								}
								setTimeout(function(){
									$("#tip").text("");
								},1000);
							}
						},"json");
					}else{
						$.messager.alert("提示信息","请选择关联的客户！","info");
					}
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
						<a class="easyui-linkbutton" id="relationCustomer" data-options="iconCls:'icon-edit'">关联</a>
						&nbsp;<font id="tip" color="red"></font>
					</td>
					
				</tr>
			</table>
		</div>
		
		<!-- 数据表格 -->
		<table id="customer_datagrid">
		</table>
	</body>
</html>
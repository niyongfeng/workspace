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
				
				/** 把表格转化成treegrid */
				$("#resource_datagrid").treegrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true, // 列自适应父容器 
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/identity/selectAllResource.jspx?roleId=${role.id}", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "name", title : "资源名称", width : 180},  
					   {field : "permission", title : "资源权限", width : 120},   
					   {field : "type", title : "资源类型", width : 60},   
					   {field : "url", title : "资源链接", width : 300}
					]],
					idField : "code", // 指定主键列的值
					treeField : "name", // 指定树节点的名称
					cascadeCheck : false, // 是否级联检查
					checkbox : function(row){ // 指定树节点前面的checkbox
						console.log(row);
						// 第一行：根节点 row.code : undefind
						if (row.code){
							// row ：一行数据 {}
							return row.code.length > 4;
						}
					} 
				});
				
				/** 为绑定资源按钮绑定点击事件 */
				$("#bindResource").click(function(){
					/** 获取树的所有子节点 [{},{}]*/
					var rows = $("#resource_datagrid").treegrid("getChildren");
					/** 定义数组封装资源主键code的值 */
					var codes = new Array();
					for (var i = 0; i < rows.length; i++){
						/** 判断树节点前面的checkbox是否选中 */
						if (rows[i].checked){
							codes.push(rows[i].code);
						}
					}
					/** 异步请求删除资源 */
					$.post("${path}/identity/bindResource.jspx",
							{"role.id" : "${role.id}", codes : codes.join(",")},function(data, status){
						if (status == "success"){
							// data : 1 代表绑定成功 0 绑定失败
							$("#tip").text(data == 1 ? "绑定成功！" : "绑定失败！");
						}
					},"json");
						
				});
			});
		</script>
	</head>
	<body class="easyui-layout">
		
		<!-- 中间区域 -->
		<div data-options="region:'center',border:false">
			<!-- 定义数据表格中的工具栏容器 -->
			<div id="toolbar">
				<table>
					<tr>
						<td>
							<a class="easyui-linkbutton" id="bindResource" data-options="iconCls:'icon-ok'">绑定</a>
							&nbsp;<font id="tip" color="red"></font>
						</td>
						
					</tr>
				</table>
			</div>
			
			<!-- 数据表格 -->
			<table id="resource_datagrid">
			</table>
		</div>
	</body>
</html>
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
				$("#subArea_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true, // 列填充父容器
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/basic/selectSubArea.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "id", checkbox : true},
					   {field : "subArea_id", title : "编号", formatter : function(value, rowData){
						   return rowData.id;
					   }},
					   {field : "province", title : "省", width : 30, formatter : function(value, rowData){
						   return rowData.region.province;
					   }},  
					   {field : "city", title : "市", width : 30, formatter : function(value, rowData){
						   return rowData.region.city;
					   }},
					   {field : "district", title : "区", width : 30, formatter : function(value, rowData){
						   return rowData.region.district;
					   }},
					   {field : "addressKey", title : "关键字", width : 50},
					   {field : "startNum", title : "起始号"},
					   {field : "endNum", title : "终止号"},
					   {field : "single", title : "单双号", formatter : function(value){
						   return ["单双号","单号","双号"][value];
					   }},
					   {field : "fixedArea_name", title : "定区名称", width : 50, formatter : function(value, rowData){
						   return rowData.fixedArea.name;
					   }},
					   {field : "position", title : "位置", width : 150}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 5, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1  // 设置初始化页面时，当前页码为1
				});
				/** 为搜索按钮绑定点击事件 */
				$("#searchBtn").click(function(){
					/** 获取查询条件 */
					var params = $("#searchForm").form2JSON();
					$("#subArea_datagrid").datagrid("reload", params);
				});
				/** 为添加分区按钮绑定点击事件 */
				$("#addSubArea").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成Dialog */
					divDialog.dialog({
						title : "添加分区", // 标题
						width : 370, // 宽度
						height : 290, // 高度
						collapsible : true, // 可折叠
						modal : true, // 模态窗口
						onClose : function(){ // 关闭窗口
							/** 让数据表格重新加载数据 */
							$("#subArea_datagrid").datagrid("reload");
						}
					});
					/** 创建iframe */
					$("<iframe id='iframe' style='width:100%;height:295px;' frameborder='0'></iframe>")
					  .attr("src", "${path}/basic/showAddSubArea.jspx") // 设置属性
					  .appendTo(divDialog);
				});
				
				
				
				
				/** 为修改按钮绑定点击事件 */
				$("#updateSubArea").click(function(){
					/** 获取分区选中的行 rows: [{id:1,name:'',remark:''},{}] */
					var rows = $("#subArea_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要修改的行！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "修改分区", // 标题
							width : 460, // 宽度
							height : 220, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 让数据表格重新加载数据 */
								$("#subArea_datagrid").datagrid("reload");
							}
							
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:245px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/basic/showUpdatesubArea.jspx?subArea.subAreaId=" + rows[0].subAreaId) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","修改分区时，只能选择一行！","warning");
					}
				});
				/** 为删除按钮绑定点击事件 */
				$("#deleteSubArea").click(function(){
					/** 获取分区选中的行 */
					var rows = $("#subArea_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要删除的行！","warning");
					}else{
						$.messager.confirm("确认信息", "您确定要删除吗？", function(r){
							if (r){
								/** 定义数组封装分区主键id的值 */
								var subAreaIds = new Array();
								for (var i = 0; i < rows.length; i++){
									subAreaIds.push(rows[i].subAreaId);
								}
								/** 异步请求删除分区 */
								$.post("${path}/basic/deletesubArea.jspx",{subAreaIds : subAreaIds.join(",")},function(data, status){
									if (status == "success"){
										// data : 1 代表删除成功 0 删除失败
										$("#tip").text(data == 1 ? "删除成功！" : "删除失败！");
										if (data == 1){
											/** 让数据表格重新加载数据 */
											$("#subArea_datagrid").datagrid("reload");
										}
									}
								},"json");
							}
						});
					}
				});
				
				
				
				/** 为导出按钮绑定点击事件 */
				$("#exportSubArea").click(function(){
					window.location.href = "${path}/basic/exportSubArea.jspx";
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
					
					<!-- 判断分区是否有添加的权限 -->
					<shiro:hasPermission name="subarea:add">
						<td>
							<a class="easyui-linkbutton" id="addSubArea" data-options="iconCls:'icon-add'">添加</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断分区是否有修改的权限 -->
					<shiro:hasPermission name="subarea:update">
						<td>
							<a class="easyui-linkbutton" id="updateSubArea" data-options="iconCls:'icon-edit'">修改</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断分区是否有删除的权限 -->
					<shiro:hasPermission name="subarea:delete">
						<td>
							<a class="easyui-linkbutton" id="deleteSubArea" data-options="iconCls:'icon-remove'">删除</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断分区是否有导出的权限 -->
					<shiro:hasPermission name="subarea:export">
						<td>
							<a class="easyui-linkbutton" id="exportSubArea" data-options="iconCls:'icon-undo'">导出</a>
						</td>
					</shiro:hasPermission>
					<td>&nbsp;<font id="tip" color="red"></font></td>
				</tr>
			</table>
			
			<!-- 查询区 -->
			<form id="searchForm" style="background-color: #fff;border-top: 1px solid #ccc;">
				<table>
					<tr>
						<td>省：<input type="text" name="subArea.region.province" class="easyui-textbox" size="10"/></td>
						<td>市：<input type="text" name="subArea.region.city"  class="easyui-textbox" size="10"/></td>
						<td>区(县)：<input type="text" name="subArea.region.district"  class="easyui-textbox" size="10"/></td>
						<td>关键字：<input type="text" name="subArea.addressKey"  class="easyui-textbox" size="10"/></td>
						<td>
							<a class="easyui-linkbutton" id="searchBtn" 
								data-options="iconCls:'icon-search'">搜索</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<!-- 数据表格 -->
		<table id="subArea_datagrid">
		</table>
	</body>
</html>
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
		<script type="text/javascript" src="${path}/js/jquery.ocupload-1.1.2.js"></script>
		<style type="text/css">
			/** 更改行的高度  easyui.css: 1363行 */
			.datagrid-row {
			   height: 30px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				/** 把表格转化成datagrid */
				$("#region_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/basic/selectRegion.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "id", checkbox : true},
					   {field : "r_id", title : "区域编号", width : 100, formatter: function(value, rowData){
						   return rowData.id;
					   }}, 
					   {field : "province", title : "省", width : 100}, 
					   {field : "city", title : "市", width : 100}, 
					   {field : "district", title : "区", width : 100}, 
					   {field : "postCode", title : "邮编", width : 100},
					   {field : "shortCode", title : "简码", width : 100},
					   {field : "cityCode", title : "城市编码", width : 100}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 10, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1  // 设置初始化页面时，当前页码为1
				});
				
				/** 为添加区域按钮绑定点击事件 */
				$("#addRegion").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成Dialog */
					divDialog.dialog({
						title : "添加区域", // 标题
						width : 350, // 宽度
						height : 230, // 高度
						collapsible : true, // 可折叠
						modal : true, // 模态窗口
						onClose : function(){
							/** 让数据表格重新加载数据 */
							$("#region_datagrid").datagrid("reload");
						}
					});
					/** 创建iframe */
					$("<iframe style='width:100%;height:230px;' frameborder='0'></iframe>")
					  .attr("src", "${path}/basic/showAddRegion.jspx") // 设置属性
					  .appendTo(divDialog);
				});
				
				/** 为修改按钮绑定点击事件 */
				$("#updateRegion").click(function(){
					/** 获取用户选中的行 rows: [{id:1,name:'',remark:''},{}] */
					var rows = $("#region_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要修改的行！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "修改区域", // 标题
							width : 350, // 宽度
							height : 200, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 让数据表格重新加载数据 */
								$("#region_datagrid").datagrid("reload");
							}
							
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:200px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/basic/showUpdateRegion.jspx?region.id=" + rows[0].id) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","修改区域时，只能选择一行！","warning");
					}
				});
				
				
				/** 为删除按钮绑定点击事件 */
				$("#deleteRegion").click(function(){
					/** 获取用户选中的行 */
					var rows = $("#region_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要删除的行！","warning");
					}else{
						$.messager.confirm("确认信息", "您确定要删除吗？", function(r){
							if (r){
								/** 定义数组封装区域主键id的值 */
								var ids = new Array();
								for (var i = 0; i < rows.length; i++){
									ids.push(rows[i].id);
								}
								/** 异步请求删除区域 */
								$.post("${path}/basic/deleteRegion.jspx",{ids : ids.join(",")},function(data, status){
									if (status == "success"){
										// data : 1 代表删除成功 0 删除失败
										$("#tip").text(data == 1 ? "删除成功！" : "删除失败！");
										if (data == 1){
											/** 让数据表格重新加载数据 */
											$("#region_datagrid").datagrid("reload");
										}
									}
								},"json");
							}
						});
					}
				});
				
				
				/** 为导入按钮绑定一键上传方法 */
				$("#importRegion").upload({
					name : "regionFile", // 指定的是<input type='file' name="regionFile"/>
					action : "${path}/basic/importRegion.jspx", // 请求地址
					onComplete : function(data){ // 异步请求完成后会回调的函数
						// data 1 、 0
						if (data == 1){
							/** 让数据表格重新加载数据 */
							$("#region_datagrid").datagrid("reload");
						}
						$("#tip").text(data == 1 ? "导入成功！" :"导入失败！");
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
			<table>
				<tr>
					<shiro:hasPermission name="region:add">
						<td>
							<a class="easyui-linkbutton" id="addRegion" data-options="iconCls:'icon-add'">添加</a>
						</td>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="region:update">			
						<td>
							<a class="easyui-linkbutton" id="updateRegion" data-options="iconCls:'icon-edit'">修改</a>
						</td>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="region:delete">
						<td>
							<a class="easyui-linkbutton" id="deleteRegion" data-options="iconCls:'icon-remove'">删除</a>
						</td>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="region:import">
						<td>
							<a class="easyui-linkbutton" id="importRegion" data-options="iconCls:'icon-redo'">导入</a>
						</td>
					</shiro:hasPermission>
					<td>&nbsp;<font id="tip" color="red"></font></td>
					
				</tr>
			</table>
		</div>
		
		<!-- 数据表格 -->
		<table id="region_datagrid">
		</table>
	</body>
</html>
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
		<link rel="stylesheet" type="text/css" href="${path}/js/ztree/zTreeStyle/zTreeStyle.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${path}/js/ztree/jquery.ztree.all.min.js"></script>
		<style type="text/css">
			/** 更改行的高度  easyui.css: 1363行 */
			.datagrid-row {
			   height: 30px;
			}
			
		</style>
		<script type="text/javascript">
			/** 树的全局配置信息 json格式 */
			var settings = {
				async : { // 异步请求配置部分
					enable : true, // 开启异步请求
					type : "post", // 请求方式
					dataType : "json", // 指定服务器响应回来的数据类型
					url : "${path}/identity/loadResourceTree.jspx" // 请求URL
				},
				data : { // 树的数据部分配置
					simpleData : { // 简单的数据
						enable : true, // 开启
						idKey : "id", // 自己节点的id
						pIdKey : "pid" // 父节点的id
					}
				},
				view : { // 显示部分的配置
					showLine : true, // 显示连接线
					showIcon : true, // 显示图标
					showTitle : true, // 显示标题
					selectedMulti : false, // 可以多选
					expandSpeed : 100, // 展开树节点的速度
					nameIsHTML: true // 树节点的名称是否可以用html格式
				},
				callback : { // 为树绑定事件部分
					onClick : function(event, treeId, treeNode){ // 为树节点绑定点击事件
						// treeNode: 树节点
						/** 判断树节点的id是不是零 */
						var code = treeNode.id == 0 ? "" : treeNode.id;
						/** 重新加载表格中的数据 */
						$("#resource_datagrid").datagrid("reload", {"parentCode" : code});
					}
				}
			};
			/** 定义树的数据 */
			var nodes = [{id:0, pid:-1, name:"资源树",isParent : true, open: true}];
			
			$(function(){
				/** 
				 * 初始化ztee树 
				 * 第一个参数：树容器 (jQuery对象)
				 * 第二个参数：树的全局配置信息 json格式
				 * 第三个参数：生成树需要数据[{},{}]
				 */
				$.fn.zTree.init($("#res_tree"), settings, nodes);
				
				/** 把表格转化成datagrid */
				$("#resource_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : true, // 列自适应父容器 
					fit : true, // 自适应父容器
					rownumbers : true, // 显示行号
					url : "${path}/identity/selectResource.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					   {field : "code", checkbox : true},  
					   {field : "r_code", title : "资源编号",width:100, formatter : function(value,rowData){
						   return rowData.code;
					   }}, 
					   {field : "name", title : "资源名称", width : 150},   
					   {field : "type", title : "资源类型", width : 100},   
					   {field : "permission", title : "资源权限", width : 150},   
					   {field : "url", title : "资源链接", width : 300}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 5, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1  // 设置初始化页面时，当前页码为1
				});
				
				/** 为添加资源按钮绑定点击事件 */
				$("#addResource").click(function(){
					/** 获取树对象 */
					var treeObj = $.fn.zTree.getZTreeObj("res_tree");
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成Dialog */
					divDialog.dialog({
						title : "添加资源", // 标题
						width : 370, // 宽度
						height : 200, // 高度
						collapsible : true, // 可折叠
						modal : true, // 模态窗口
						onClose : function(){
							/** 获取所有的树节点 */
							var nodes = treeObj.getNodes();
							/** 调用ztee树对象中的方法刷新树*/
							treeObj.reAsyncChildNodes(nodes[0], "refresh");
							/** 让数据表格重新加载数据 */
							$("#resource_datagrid").datagrid("reload");
						}
					});
					
					/** 获取用户选中的树节点 */
					var nodes = treeObj.getSelectedNodes();
					var parentCode = "";
					if (nodes.length > 0){
						/** 获取一个 */
						parentCode = nodes[0].id == 0 ? "" : nodes[0].id;
					}
					/** 创建iframe */
					$("<iframe style='width:100%;height:200px;' frameborder='0'></iframe>")
					  .attr("src", "${path}/identity/showAddResource.jspx?parentCode=" + parentCode) // 设置属性
					  .appendTo(divDialog);
				});
				
				/** 为修改按钮绑定点击事件 */
				$("#updateResource").click(function(){
					/** 获取用户选中的行 rows: [{id:1,name:'',remark:''},{}] */
					var rows = $("#resource_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要修改的行！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "修改资源", // 标题
							width : 370, // 宽度
							height : 200, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 获取树对象 */
								var treeObj = $.fn.zTree.getZTreeObj("res_tree");
								/** 获取所有的树节点 */
								var nodes = treeObj.getNodes();
								/** 调用ztee树对象中的方法刷新树*/
								treeObj.reAsyncChildNodes(nodes[0], "refresh");
								/** 让数据表格重新加载数据 */
								$("#resource_datagrid").datagrid("reload");
							}
							
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:200px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/identity/showUpdateResource.jspx?resource.code=" + rows[0].code) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","修改资源时，只能选择一行！","warning");
					}
				});
				
				/** 为删除按钮绑定点击事件 */
				$("#deleteResource").click(function(){
					/** 获取用户选中的行 */
					var rows = $("#resource_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要删除的行！","warning");
					}else{
						$.messager.confirm("确认信息", "您确定要删除吗？", function(r){
							if (r){
								/** 定义数组封装资源主键code的值 */
								var codes = new Array();
								for (var i = 0; i < rows.length; i++){
									codes.push(rows[i].code);
								}
								/** 异步请求删除资源 */
								$.post("${path}/identity/deleteResource.jspx",{codes : codes.join(",")},function(data, status){
									if (status == "success"){
										// data : 1 代表删除成功 0 删除失败
										$("#tip").text(data == 1 ? "删除成功！" : "删除失败！");
										if (data == 1){
											/** 获取树对象 */
											var treeObj = $.fn.zTree.getZTreeObj("res_tree");
											/** 获取所有的树节点 */
											var nodes = treeObj.getNodes();
											/** 调用ztee树对象中的方法刷新树*/
											treeObj.reAsyncChildNodes(nodes[0], "refresh");
											/** 让数据表格重新加载数据 */
											$("#resource_datagrid").datagrid("reload");
										}
									}
								},"json");
							}
						});
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
		<!-- 西部区域 -->
		<div data-options="region:'west',width:168,split:true">
			<ul id="res_tree" class="ztree"></ul>
		</div>
		
		<!-- 中间区域 -->
		<div data-options="region:'center',border:false">
			<!-- 定义数据表格中的工具栏容器 -->
			<div id="toolbar">
				<table>
					<tr>
						<shiro:hasPermission name="resource:add">
							<td>
								<a class="easyui-linkbutton" id="addResource" data-options="iconCls:'icon-add'">添加</a>
							</td>
						</shiro:hasPermission>
						<shiro:hasPermission name="resource:update">
							<td>
								<a class="easyui-linkbutton" id="updateResource" data-options="iconCls:'icon-edit'">修改</a>
							</td>
						</shiro:hasPermission>
						
						<shiro:hasPermission name="resource:delete">
							<td>
								<a class="easyui-linkbutton" id="deleteResource" data-options="iconCls:'icon-remove'">删除</a>
							</td>
						</shiro:hasPermission>
						<td>&nbsp;<font id="tip" color="red"></font></td>
						
					</tr>
				</table>
			</div>
			
			<!-- 数据表格 -->
			<table id="resource_datagrid">
			</table>
		</div>
	</body>
</html>
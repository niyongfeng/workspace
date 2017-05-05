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
				$("#fixedarea_datagrid").datagrid({
					toolbar: "#toolbar", // 工具栏
					border : false, // 不需要边框
					fitColumns : false, // 列填充父容器
					fit : true, // 自适应父容器
					singleSelect : true, // 是否单行选中
					rownumbers : true, // 显示行号
					url : "${path}/basic/selectFixedArea.jspx", // 数据表格需要请求的URL 数据格式: {} json格式
					columns : [[ // 列的相关信息(表头)
					
					   {field : "id", title : "编号", width : 50},
					   {field : "name", title : "定区名称", width : 120},  
					   {field : "staff_name", title : "取派员", width : 80, formatter : function(value, rowData){
						   return rowData.staff.name;
					   }},
					   {field : "phone", title : "联系电话", width : 120, formatter : function(value, rowData){
						   return rowData.staff.phone;
					   }},
					   {field : "station", title : "所属单位", width : 200, formatter : function(value, rowData){
						   return rowData.staff.station;
					   }}
					]],
					pagination : true, // 显示分页工具栏
					pageList : [5,10,15],  // 初始化页面大小选择列表(每页显示的记录条数)
					pageSize : 5, // 设置初始化页面时，一页显示15条记录
					pageNumber: 1,  // 设置初始化页面时，当前页码为1
					onClickRow : function(index, row){ // 监听行的点击事件
						<shiro:hasPermission name="fixedarea:relation">
						// index : 行的索引号
						// row : 一行数据 {}
						/** 获取定区id */
						var fixedAreaId = row.id;
						
						/** ############# 分区数据表格 ############### */
						$("#subArea_datagrid").datagrid({
							border : false, // 不需要边框
							fitColumns : true, // 列填充父容器
							fit : true, // 自适应父容器
							rownumbers : true, // 显示行号
							url : "${path}/basic/relationSubArea.jspx?fixedArea.id=" + fixedAreaId, // 数据表格需要请求的URL 数据格式: {} json格式
							columns : [[ // 列的相关信息(表头)
							   {field : "id", title : "编号"},
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
							]]
						});
						
						/** ############# 客户数据表格 ############### */
						$("#customer_datagrid").datagrid({
							border : false, // 不需要边框
							fitColumns : true, // 列填充父容器
							fit : true, // 自适应父容器
							rownumbers : true, // 显示行号
							url : "${path}/basic/selectRelationCustomer.jspx?fixedArea.id=" + fixedAreaId, // 数据表格需要请求的URL 数据格式: {} json格式
							columns : [[ // 列的相关信息(表头)
							   {field : "id", title : "编号"},
							   {field : "name", title : "姓名", width : 30},  
							   {field : "phone", title : "手机号码", width : 30},
							   {field : "station", title : "所属单位", width : 30},
							   {field : "address", title : "联系地址", width : 50},
							   {field : "opera", title : "操作",formatter : function(value,rowData){
								   return "<a href='javascript:;' onclick='deleteRelationCustomerFn("+ rowData.id +")'><img src='${path}/js/easyui/themes/icons/cancel.png'/></a>";
							   }}
							]]
						});
						</shiro:hasPermission>
					}
				});
				
				/** 删除定区关联的客户 */
				window.deleteRelationCustomerFn = function(id){
					$.messager.confirm("确认提示","您确定要解除关联吗？",function(r){
						if (r){
							$.post("${path}/basic/deleteRelationCustomer.jspx",{customerId : id},
									function(data,status){
								if (status == "success"){
									if (data == 1){
										$("#tip").text("解除关联成功！");
										$("#customer_datagrid").datagrid("reload");
									}else{
										$("#tip").text("解除关联失败！");
									}
								}
							},"json");
						}
					});
				}
				
				/** 为添加定区按钮绑定点击事件 */
				$("#addFixedArea").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成Dialog */
					divDialog.dialog({
						title : "添加定区", // 标题
						width : 370, // 宽度
						height : 290, // 高度
						collapsible : true, // 可折叠
						modal : true, // 模态窗口
						onClose : function(){ // 关闭窗口
							/** 让数据表格重新加载数据 */
							$("#fixedarea_datagrid").datagrid("reload");
						}
					});
					/** 创建iframe */
					$("<iframe id='iframe' style='width:100%;height:295px;' frameborder='0'></iframe>")
					  .attr("src", "${path}/basic/showAddFixedArea.jspx") // 设置属性
					  .appendTo(divDialog);
				});
				
				/** 为修改按钮绑定点击事件 */
				$("#updateFixedArea").click(function(){
					/** 获取定区选中的行 rows: [{id:1,name:'',remark:''},{}] */
					var rows = $("#fixedarea_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要修改的行！","warning");
					}else if (rows.length == 1){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "修改定区", // 标题
							width : 460, // 宽度
							height : 220, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 让数据表格重新加载数据 */
								$("#fixedarea_datagrid").datagrid("reload");
							}
							
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:245px;' frameborder='0'></iframe>")
						  .attr("src", "${path}/basic/showUpdateFixedArea.jspx?fixedarea.fixedareaId=" + rows[0].fixedareaId) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("警告信息","修改定区时，只能选择一行！","warning");
					}
				});
				/** 为删除按钮绑定点击事件 */
				$("#deleteFixedArea").click(function(){
					/** 获取定区选中的行 */
					var rows = $("#fixedarea_datagrid").datagrid("getSelections");
					if (rows.length == 0){
						$.messager.alert("警告信息","请选择要删除的行！","warning");
					}else{
						$.messager.confirm("确认信息", "您确定要删除吗？", function(r){
							if (r){
								/** 定义数组封装定区主键id的值 */
								var fixedareaIds = new Array();
								for (var i = 0; i < rows.length; i++){
									fixedareaIds.push(rows[i].fixedareaId);
								}
								/** 异步请求删除定区 */
								$.post("${path}/basic/deleteFixedArea.jspx",{fixedareaIds : fixedareaIds.join(",")},function(data, status){
									if (status == "success"){
										// data : 1 代表删除成功 0 删除失败
										$("#tip").text(data == 1 ? "删除成功！" : "删除失败！");
										if (data == 1){
											/** 让数据表格重新加载数据 */
											$("#fixedarea_datagrid").datagrid("reload");
										}
									}
								},"json");
							}
						});
					}
				});
				
				/** 为关联客户按钮绑定点击事件 */
				$("#relationCustomer").click(function(){
					/** 获取用户选中的一行 row : {} */
					var row = $("#fixedarea_datagrid").datagrid("getSelected");
					if (row){
						/** 创建div */
						var divDialog = $("<div style='overflow:hidden;'/>");
						/** 把div转化成Dialog */
						divDialog.dialog({
							title : "关联客户", // 标题
							width : 650, // 宽度
							height : 350, // 高度
							collapsible : true, // 可折叠
							modal : true, // 模态窗口
							onClose : function(){
								/** 让数据表格重新加载数据 */
								$("#customer_datagrid").datagrid("reload");
							}
						});
						/** 创建iframe */
						$("<iframe style='width:100%;height:100%' frameborder='0'></iframe>")
						  .attr("src", "${path}/basic/showRelationCustomer.jspx?fixedArea.id=" + row.id) // 设置属性
						  .appendTo(divDialog);
					}else{
						$.messager.alert("提示信息","请选择需要关联的定区！","info");
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
					
					<!-- 判断定区是否有添加的权限 -->
					<shiro:hasPermission name="fixedarea:add">
						<td>
							<a class="easyui-linkbutton" id="addFixedArea" data-options="iconCls:'icon-add'">添加</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断定区是否有修改的权限 -->
					<shiro:hasPermission name="fixedarea:update">
						<td>
							<a class="easyui-linkbutton" id="updateFixedArea" data-options="iconCls:'icon-edit'">修改</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断定区是否有删除的权限 -->
					<shiro:hasPermission name="fixedarea:delete">
						<td>
							<a class="easyui-linkbutton" id="deleteFixedArea" data-options="iconCls:'icon-remove'">删除</a>
						</td>
					</shiro:hasPermission>
					<!-- 判断定区是否有关联的权限 -->
					<shiro:hasPermission name="fixedarea:relation">
						<td>
							<a class="easyui-linkbutton" id="relationCustomer" data-options="iconCls:'icon-sum'">关联客户</a>
						</td>
					</shiro:hasPermission>
					<td>&nbsp;<font id="tip" color="red"></font></td>
				</tr>
			</table>
		</div>
		
		<!-- 中间区域 -->
		<div data-options="region:'center',border:false">
			<!-- 数据表格 -->
			<table id="fixedarea_datagrid">
			</table>
		</div>
		
		<shiro:hasPermission name="fixedarea:relation">
			<!-- 南部区域 -->
			<div data-options="region:'south',height:218,border:false">
				<!-- 选项卡容器 -->
				<div class="easyui-tabs" data-options="border:false,fit:true">
					<!-- 分区信息 选项卡-->
					<div data-options="title:'分区信息',iconCls:'icon-mini-edit'">
						<!-- 数据表格 -->
						<table id="subArea_datagrid">
						</table>
					</div>
					
					<!-- 客户信息 选项卡-->
					<div data-options="title:'客户信息',iconCls:'icon-mini-edit'">
						<!-- 数据表格 -->
						<table id="customer_datagrid">
						</table>
					</div>
				</div>
			</div>
		</shiro:hasPermission>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>发货单录入</title>
		<link rel="shortcut icon" type="image/x-icon" href="${path}/logo.ico"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/default.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<style type="text/css">
			/** easyui.css: 1363行改行高 */
			.datagrid-row {
  				height: 30px;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				/** 数据表格属性 */
				$("#grid").datagrid({
				    border : false, // 是否添加边框
				    fitColumns:true, // 列的宽度自动填充
					toolbar : "#toolbar",   // 工具栏
					fit:true, // 填充父容器
					pagination : true, // 显示分页条
					url : "${path}/handlecenter/selectSendGoodsBill.jspx", // 请求URL
					rownumbers : true, // 显示行数量
					pageList : [5,10,15], // 显示数量列表
					pageSize : 10, // 每页显示数量
					singleSelect : true, // 只能选单行
					columns : [[ // 指定列
						{field : "id", title : "编号"},
						{field : "receiverName",title : "收件人姓名", editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"收件人姓名不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}}, 
						{field : "receiverPhone",title : "收件人手机号码", editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"收件人手机号码不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "receiverAddress",title : "收件人地址", width:100, editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"收件人地址不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "feeNum",title : "计费件数", editor :{
							type : 'numberbox', // 编辑类型
							options : {required : true, missingMessage:"计费件数不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}}, 
						{field : "actlWeight",title : "实际重量", editor :{
							type : 'numberbox', // 编辑类型
							options : {required : true, missingMessage:"实际重量不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}}, 
						{field : "weight",title : "重量",editor :{
							type : 'numberbox', // 编辑类型
							options : {required : true, missingMessage:"重量不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "volumn",title : "体积",editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"体积不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}}, 
						{field : "floadreqr",title : "配置要求",editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"配置要求不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "senderName",title : "寄件人姓名",editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"寄件人姓名不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "senderPhone",title : "寄件人手机号码",editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"寄件人手机号码不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}},  
						{field : "senderAddress",title : "寄件人地址",width:100,editor :{
							type : 'textbox', // 编辑类型
							options : {required : true, missingMessage:"寄件人地址不能为空！",tipPosition:'top'}  // 指定编辑类型对应的属性
						}}
					]],
					onAfterEdit : function(index, row){ // 在用户完成编辑一行的时候触发
						// index : 行的索引号
						// row: 行中的数据 
						console.log(row);
						$.post("${path}/handlecenter/saveOrUpdateSendGoodsBill.jspx",row,function(data,status){
							if (status == "success"){
								$.messager.alert("提示信息",data == 1 ? "同步成功！" : "同步失败！","info");
								if (data == 1){
									$("#grid").datagrid("reload");
								}
							}
						},"json");
					}
				});
				
				/** 为新增按钮绑定点击事件 */
				$("#addSgBill").click(function(){
					/** datagrid追加新的一行(appendRow) */
					$("#grid").datagrid("appendRow",  {});
					/** 获取所有的行 */
					var rows = $("#grid").datagrid("getRows");
					/** 开启编辑哪一行  (beginEdit开始编辑行) */
					$("#grid").datagrid("beginEdit",rows.length - 1);
					/** 让这一行选中 */
					$("#grid").datagrid("selectRow",rows.length - 1);
					
					
				});
				/** 为删除按钮绑定点击事件 */
				$("#deleteSgBill").click(function(){
					/** 获取选中的行 */
					var row = $("#grid").datagrid("getSelected");
					if (row){
						if (row.id){ // 删除数据库表中的数据
							
						}else{
							/** 获取指定行的索引号 */
							var index = $("#grid").datagrid("getRowIndex", row);
							/** 删除行 */
							$("#grid").datagrid("deleteRow", index);
						}
					}else{
						$.messager.alert("提示信息","请选择要删除的行！","info");
					}
				});
				
				/** 为保存按钮绑定点击事件 */
				$("#saveSgBill").click(function(){
					/** 获取选中的行 */
					var row = $("#grid").datagrid("getSelected");
					if (row){
						/** 获取指定行的索引号 */
						var index = $("#grid").datagrid("getRowIndex", row);
						/** 结束编辑行 */
						$("#grid").datagrid("endEdit", index);
						/** 取消选中指定的行 */
						$("#grid").datagrid("unselectRow", index);
					}else{
						$.messager.alert("提示信息","请选择要保存的行！","info");
					}
				});
				
				/** 为修改按钮绑定点击事件 */
				$("#updateSgBill").click(function(){
					/** 获取选中的行 */
					var row = $("#grid").datagrid("getSelected");
					if (row){
						/** 获取指定行的索引号 */
						var index = $("#grid").datagrid("getRowIndex", row);
						/** 开始编辑行 */
						$("#grid").datagrid("beginEdit", index);
						/** 指定列不可编辑 */
						var fields = ["receiverName","receiverPhone","receiverAddress"];
						for (var i = 0; i < fields.length; i++){
							/** 获取指定行中指定列的编辑器对象 */
							var ed = $('#grid').datagrid('getEditor', {index:index,field: fields[i]});
							/** ed.target: dom元素 */
							$(ed.target).textbox("disable");
						}
						
					}else{
						$.messager.alert("提示信息","请选择要修改的行！","info");
					}
				});
				
				/** 为取消按钮绑定点击事件 */
				$("#cancelSgBill").click(function(){
					/** 获取选中的行 */
					var row = $("#grid").datagrid("getSelected");
					if (row){
						/** 获取指定行的索引号 */
						var index = $("#grid").datagrid("getRowIndex", row);
						/** 取消编辑行 */
						$("#grid").datagrid("cancelEdit", index);
						/** 取消选中指定的行 */
						$("#grid").datagrid("unselectRow", index);
					}else{
						$.messager.alert("提示信息","请选择要取消的行！","info");
					}
				});
			});
		</script>	
	</head>
	
	<body class="easyui-layout">
	
		<!-- 工具栏 -->
		<div id="toolbar">
			<table>
				<tr>
					<!-- 判断是否有添加资源权限 -->
					<shiro:hasPermission name="sgbill:add">
						<td>
							<a href="javascript:;" class="easyui-linkbutton" 
								data-options="iconCls:'icon-add'" id="addSgBill">新增</a>
						</td>
						<td><div class="dialog-tool-separator"></div></td>	
					</shiro:hasPermission>
					<!-- 判断是否有修改资源权限 -->
					<shiro:hasPermission name="sgbill:update">	
						<td>
							<a href="javascript:;" class="easyui-linkbutton" 
								data-options="iconCls:'icon-edit'" id="updateSgBill">修改</a>
						</td>
						<td><div class="dialog-tool-separator"></div></td>
					</shiro:hasPermission>
					<!-- 判断是否有删除资源权限 -->
					<shiro:hasPermission name="sgbill:delete">
						<td>
							<a href="javascript:;" class="easyui-linkbutton" 
								data-options="iconCls:'icon-remove'" id="deleteSgBill">删除</a>
					  	</td>
					  	<td><div class="dialog-tool-separator"></div></td>
				  	</shiro:hasPermission>
				  	<!-- 判断是否有审批资源权限 -->
					<shiro:hasPermission name="sgbill:check">
						<td>
							<a href="javascript:;" class="easyui-linkbutton" 
								data-options="iconCls:'icon-edit'" id="checkSgBill">审批</a>
					  	</td>
					  	<td><div class="dialog-tool-separator"></div></td>
				  	</shiro:hasPermission>
				  		<td>
							<a href="javascript:;" class="easyui-linkbutton"
								data-options="iconCls:'icon-save'" id="saveSgBill">保存</a>
					  	</td>
					  	<td><div class="dialog-tool-separator"></div></td>
					  	<td>
							<a href="javascript:;" class="easyui-linkbutton"
								data-options="iconCls:'icon-no'" id="cancelSgBill">取消</a>
					  	</td>
				  		<td>&nbsp;<font color="red" id="tip"></font></td>
				  </tr>
			</table>
		</div>
		
		<!-- 数据展示 -->
		<div data-options="region:'center',border:false">
			<table id="grid"></table>
		</div>
		
	</body>
</html>
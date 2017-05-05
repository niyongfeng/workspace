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
		<link rel="stylesheet" type="text/css" href="${path}/css/default.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
			$(function(){
				
				/** 异步加载定区数据 */
				$.getJSON("${path}/basic/loadFixedArea.jspx", function(data, status){
					if (status == "success"){
						// data:[{"name":"东圃分点","id":1},{"name":"白石洲分点","id":2}]
						$("#fixedAreaSelect").combobox({
							valueField : "id",
							textField: "name",
							data : data,
							value : data[0].id,
							editable : false,
							panelHeight : 100
						});
					}
				});
				
				/** 为添加按钮绑定点击事件 */
				$("#submitBtn").click(function(){
					
					/** 获取表单，开启校验 */
					var validate = $("#subAreaForm").form("enableValidation") // 启用验证
					               			    .form("validate");// 做校验 true:通过  false: 不通过
					if (validate){
						/** 获取combobox组件的value */
						var regionId = $("#regionSelect").combobox("getValue");
						/** 获取combobox组件中的数据[{id:1, name:''},{}] */
						var data = $("#regionSelect").combobox("getData");
						/** 把data数组转化成一个新数组  (新的数组中存放id值)*/
						var idArr = $.map(data, function(item){
							// item : {id:1, name:''}
							return item.id;
						});
						/** 判断regionId是不是区域中的id */
						if ($.inArray(regionId, idArr) > -1){
							/** 
							 * 异步添加分区 
							 * 第一个参数：请求URL
							 * 第二个参数：请求参数 key=value&key=value | {key:value,key:value}
							 * 第三个参数：回调函数
							 * 第四个参数：服务器响应回来的数据类型
							 */
							 var params = $("#subAreaForm").serialize(); // 把表单序列化成get请求参数字符串
							 $.post("${path}/basic/addSubArea.jspx",params,function(data,status){
								// status : success、error 状态码
								// data : 响应数据 {}、[]、[{},{}]、1、true $.parseJSON() 1或0
								if (status == "success"){
									$("#tip").text(data == 1 ? "添加成功！" : "添加失败！");
									if (data == 1){
										$("#resetBtn").trigger("click");
									}
								}
							 },"json");
						}else{
							/** 清空combobox中的值 */
							$("#regionSelect").combobox("clear")
							                  .combobox("reload");
							$.messager.alert("提示信息", "请选择区域！", "info");
						}
					}
					
				});
				
				/** 为重置按钮绑定点击事件 */
				$("#resetBtn").click(function(){
					$("#subAreaForm").form("reset") // 重置
					             .form("disableValidation"); // 禁用验证 
				});
			});
			
		</script>
	</head>
	<body>
		<form id="subAreaForm" class="easyui-form"  data-options="novalidate:true">
			<table align="center" cellpadding="3" style="padding-top: 2px;">
				<tr>
					<td>选择区域：</td>
					<td><input type="text" id="regionSelect" name="subArea.region.id" class="easyui-combobox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'请选择区域！',
										  valueField : 'id',
										  textField : 'name',
										  mode : 'remote', 
										  url : '${path}/basic/loadRegion.jspx'"/></td>
				</tr>
				<tr>
					<td>关键字：</td>
					<td><input type="text" name="subArea.addressKey" class="easyui-textbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'关键字不能为空！'"/></td>
				</tr>
				<tr>
					<td>起始号：</td>
					<td><input type="text" name="subArea.startNum" class="easyui-numberbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'起始号不能为空！'"/></td>
				</tr>
				<tr>
					<td>终止号：</td>
					<td><input type="text" name="subArea.endNum" class="easyui-numberbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'终止号不能为空！'"/></td>
				</tr>
				<tr>
					<td>单双号：</td>
					<td><input type="text" name="subArea.single" class="easyui-combobox"
					        style="width:258px;"
							data-options="valueField:'id',
										  textField:'name',
										  value : 0,
										  panelHeight : 80,
										  editable : false,
										  data:[{id:0,name:'单双号'},
										  	    {id:1,name:'单号'},
										  	    {id:2,name:'双号'}]"/></td>
				</tr>
				<tr>
					<td>位置信息：</td>
					<td><input type="text" name="subArea.position" class="easyui-textbox"
					        style="width:258px;"
							data-options="required:true,
										  tipPosition:'bottom',
										  missingMessage:'位置信息不能为空！'"/></td>
				</tr>
				<tr>
					<td>关联定区：</td>
					<td><input id="fixedAreaSelect" type="text" name="subArea.fixedArea.id" 
							style="width:258px;"/></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<a class="easyui-linkbutton" id="submitBtn" data-options="iconCls:'icon-ok'">添加</a>
						<a class="easyui-linkbutton" id="resetBtn" data-options="iconCls:'icon-no'">重置</a>
						&nbsp;<font id="tip" color="red"></font>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
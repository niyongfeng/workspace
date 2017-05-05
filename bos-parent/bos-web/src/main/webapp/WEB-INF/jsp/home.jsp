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
		<script type="text/javascript" src="${path}/js/easyui/jquery.portal.js"></script>
		<script type="text/javascript">
			$(function(){
				
				/** 定义面板参数数组(json数组) */
				var panels = [{    
				    title: '公告栏', // 标题  
				    height: 228, // 高度
				    closable: false,  // 是否可以关闭   
				    href : "${path}/portal/gonggao.jspx", // 内容
				    collapsible: true  // 是否可以伸缩
				},{    
				    title: '预警信息', // 标题  
				    height: 228, // 高度
				    closable: false,  // 是否可以关闭   
				    href : "${path}/portal/yujing.jspx", // 内容
				    collapsible: true  // 是否可以伸缩
				},{    
				    title: '代办事宜', // 标题  
				    height: 228, // 高度
				    closable: false,  // 是否可以关闭   
				    href : "${path}/portal/daiban.jspx", // 内容
				    collapsible: true  // 是否可以伸缩
				},{    
				    title: '系统BUG反馈', // 标题  
				    height: 228, // 高度
				    closable: false,  // 是否可以关闭   
				    href : "${path}/portal/bug.jspx", // 内容
				    collapsible: true  // 是否可以伸缩
				}];
				
				/** 初始化门户拖拽组件 */
				$("#portal_div").portal({
					border : false, // 是否有边框
					fit : true // 是否自动填充父容器
				});
				
				
				/** 循环面板参数的json数组 */
				for (var i = 0; i < panels.length; i++){
					/** 创建div,把div追加到body */
					var div = $("<div/>").appendTo(document.body);
					/** 把div转化成面板 */
					div.panel(panels[i]);
					/** 添加面板 */
					$("#portal_div").portal("add", {
						panel : div,  // 添加的面板对象。
						columnIndex  : (i % 2) //插入的列索引
					});
				}
				
				/** 监听窗口大小是否发生改变的事件 */
				$(window).resize(function(){
					/** 重新调整门户拖拽组件的宽度与高度 */
					$("#portal_div").portal("resize");
					/** 重新调整数据表格组件的宽度与高度 */
					$(".easyui-datagrid").datagrid("resize");
				});
				
				
			});
		</script>
	</head>
	<body class="easyui-layout">
		<!-- 定义门户拖拽组件容器 -->
		<div id="portal_div" style="width:100%;height:100%;">
			<!-- 定义div作为门户拖拽组件的列数 (两列) -->   
		    <div style="width:50%"></div>   
		    <div style="width:50%"></div>   
		</div>  

	</body>
</html>
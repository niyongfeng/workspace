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
		<link rel="stylesheet" type="text/css" href="${path}/js/ztree/metroStyle/metroStyle.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css"/>
		<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${path}/js/jquery-timer-1.0.js"></script>
		<script type="text/javascript" src="${path}/js/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
		
			/** 定义ztree全局的设置信息 */
			var settings = {
				data : { // 配置生成树的数据部分
					simpleData : {
						enable : true // 开启简单json数据格式
					}
				},
				callback : { // 事件部分
					onClick : function(event, treeId, treeNode){ // 为树节点绑定点击事件
						// event: 事件对象  
						// treeId: 树节点id
						// treeNode: 树节点对象
						/** 判断选项卡是否存在 */
						var exists = $("#tabs").tabs("exists", treeNode.name);
						/** 存在 */
					    if (exists){
					    	/** 选中存在的选项卡 */
					    	$("#tabs").tabs("select", treeNode.name);
					    }else{ // 不存在
							/** 动态添加新的选项卡 */
							$("#tabs").tabs("add",{
								title : treeNode.name, // 标题
								iconCls : "icon-mini-edit", // 图标
								content : '<iframe width="100%" height="100%" src="${path}'+ treeNode.href +'" frameborder="0"></iframe>', // 内容
								closable : true // 是否可以关闭
							});
					    }
					}
				}
			};
			
			/** 监听文档加载完 */
			$(function(){
				/** 显示系统运行时间 */
				$("#timer").runtime();
				
				/** 在右下角弹出一个消息框 */
				$.messager.show({
					title : '', // 标题
					width : 230, // 宽度
					height : 230, // 高度
					msg : '<img src="${path}/barcode.jspx"/>', // 消息
					timeout : 10000 // 10秒后自动关闭
				});
				
				/** 异步请求生成当前用户的菜单 */
				$.ajax({
					url : "${path}/loadUserMenu.jspx",
					type : "post",
					dataType : "json",
					async : true,
					success : function(data){// 请求成功
						// data: {}
						/**
						[{"title" : "系统管理", "subMenu" : [
							{"id": 1, "pId" : 0, "name" : "用户管理", "href" : "/identity/showSelectUser.jspx"},
							{"id": 2, "pId" : 0, "name" : "角色管理", "href" : "/identity/showSelectRole.jspx"}]}, ...]
						 */
						$.each(data, function(i){
							// this : {title : "", subMenus : [{},{}]}
							/** 创建ul */
							var ul = $("<ul/>").attr("id", "tree_" + i)
								.addClass("ztree");
						    /** 
						     * 初始化ztree树
							 * 第一个参数: 树容器jquery对象
							 * 第二个参数：全局的设置信息 {}
							 * 第三个参数：树节点的数组[{},{}]
							 */
							$.fn.zTree.init(ul, settings, this.subMenu);
							
							/** 获取折叠组件，添加折叠选项卡 */
							$("#accordion_menu").accordion("add",{
								title : this.title, // 标题
								content : ul, // 内容
								iconCls:'icon-mini-add', // 图标
								selected : i == 1 // 指定第一个折叠选项卡选中
								
							});
						});
					},
					error : function(){
						$.messager.alert("错误提示", "网络出现异常！", "error");
					}
				});
				
				/** 为退出系统按钮绑定点击事件 */
				$("#logoutBtn").click(function(){
					$.messager.confirm("提示信息", "亲，您确定要退出吗？", function(r){
						if (r){
							window.location.href = "${path}/logout.jspx";
						}
					});
				});
				
				/** 为修改密码按钮绑定点击事件 */
				$("#updatePwdBtn").click(function(){
					/** 创建div */
					var divDialog = $("<div style='overflow:hidden;'/>");
					/** 把div转化成dialog */
					divDialog.dialog({
						title : "修改密码", // 标题
						width : 330, // 宽度
						height : 180, // 高度
						modal : true // 模态窗口
					});
					/** 创建iframe子窗口 */
					$("<iframe width='100%' height='100%' frameborder='0'/>")
					  .prop("src", "${path}/showUpdatePwd.jspx")
					  .appendTo(divDialog);
				});
				
				/** 为联系管理员绑定点击事件 */
				$("#qq").click(function(){
					$("#qqIframe").attr("src", "tencent://message/?uin=350884961&Site=xxx&menu=yes");
				});
			});
		</script>
		
	</head>
	<body class="easyui-layout">
		
		<!-- 北部区域 -->
		<div data-options="region:'north',height:70,border:false"
			style="background:url('images/topbg.gif')">
			<div style="position:absolute;right:15px;top:10px;font-size:12px;color:#fff;">
			<strong>${session_user.name }</strong>&nbsp;欢迎您，
				<span id="timer"> </span>
			</div>
			
			<div style="position:absolute; right:15px; top:35px; ">
				<!-- 菜单按钮 -->
				<a class="easyui-menubutton" 
					data-options="menu:'#help_menu',iconCls:'icon-help'">控制面板</a>
			</div>
			<!-- 定义div作为菜单 -->
			<div id="help_menu">
				<div id="updatePwdBtn" data-options="iconCls:'icon-lock'">修改密码</div>
				<div id="qq" data-options="iconCls:'icon-man'">联系管理员</div>
				<div class="menu-sep"></div>   
				<div id="logoutBtn" data-options="iconCls:'icon-clear'">退出系统</div>
			</div>
		</div>
		
		<!-- 西部区域 -->
		<div data-options="region:'west',width:168,iconCls:'icon-man',split:true" 
				title="BOS-菜单导航">
			<!-- 定义折叠容器组件 fit:true 自适应父容器高度 -->
			<div id="accordion_menu" class="easyui-accordion" data-options="border:false,fit:true">
				
			</div>
		</div>
		
		<!-- 中间区域 -->
		<div data-options="region:'center'">
			<!-- 定义div作为选项卡的容器 -->
			<div id="tabs" class="easyui-tabs" data-options="border:false,fit:true">
				<!-- 消息中心(选项卡) -->
				<div iconCls="icon-tip" title="消息中心">
					<!-- 子窗口 -->
					<iframe width="100%" height="100%" src="${path}/home.jspx" frameborder="0"></iframe>
				</div>
				
			</div>
		</div>
		
		<!-- 南部区域 -->
		<div data-options="region:'south',height:30,border:false"
			style="padding-top:5px;background-color:#E6E6FA;">
			<table style="width:100%; border-collapse: collapse;">
				<tr>
					<td style="width: 280px;">
						<div style="color:#999;font-size:11px;">
							© 2003-2016 传智播客  - 版权所有    
						</div>
					</td>
					<td>
						<span style="background:url(images/online.png) no-repeat left;padding-left:18px;font-size:11px;color:#445588;">登录人数：${login_user_count}</span>
					</td>
				</tr>
			</table>
		</div>
		
		<!-- 定义iframe作为弹出QQ聊天的对话框的子窗口 -->
		<iframe id="qqIframe" style="display:none"></iframe>
	</body>
</html>
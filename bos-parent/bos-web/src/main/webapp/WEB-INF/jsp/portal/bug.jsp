<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/** 功能相对独立，应该单独放置 */
	$("#bug_form").form({  
		url : "post.html",  
		onSubmit : function(){  
			if($("#bug_c").val() == ""){
				$.messager.alert("提示信息","内容太少!", "warning");	
				return false;
			}
		}, 
		success : function(data){  
			$.messager.alert("提示信息","提交成功！", "warning");	
			$('#bug_c').val("");
		}  
	});   
</script>
<div style="padding:5px;">
	<div style="margin-bottom:8px;">
		您的意见会让系统做得更好！<br/>
	</div>
	<form id="bug_form" method="post">
		<textarea name="bug_c" id="bug_c" style="width:420px;height:110px;"
			style="border:solid 3px #E2E2E2;line-height:16px; padding:5px;"></textarea>
		<br/>
		<div style="margin-top:5px;">
			<a href="javascript:void(0);" onclick="$('#bug_form').submit();"
				id="bug_form_but" class="easyui-linkbutton" 
				data-options="iconCls:'icon-ok'">提交</a>
		</div>
	</form>
</div>
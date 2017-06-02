<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/view/header.jsp"%>


<!-- Sidebar Menu -->
<%@ include file="/view/menu.jsp"%>
<!-- /.sidebar-menu -->

</section>
<!-- /.sidebar -->
</aside>

<style>
table.dataTable.display tbody tr.selected {
	background-color: #acbad4;
}
</style>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 1000px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel"></h4>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary"
					onclick='confirmData(this);'>确定</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>




<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			用户 <small>新 增</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> 用户管理</a></li>
			<li class="active">新 增</li>
		</ol>
	</section>



	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">

				<div class="box">
					<!-- /.box-header -->
					<div class="box-body">

						<div class="box box-success">

							<div class="box box-primary">

								<form role="form">
									<!-- text input -->
									<div class="form-group">
										<label>用户名</label> <input type="text" id="userName"
											class="form-control" placeholder="请输入 ...">
									</div>
									<div class="form-group">
										<label>密码</label> <input type="text" id="password"
											class="form-control" placeholder="请输入 ...">
									</div>
									<div class="form-group">
										<label>用户显示名</label> <input type="text" id="userDspName"
											class="form-control" placeholder="请输入 ...">
									</div>
									<div class="form-group">
										<label>郵箱</label> <input type="text" id="email"
											class="form-control" placeholder="请输入 ...">
									</div>
									<div class="form-group">
										<label>用户电话号码</label> <input type="text" id="phone"
											class="form-control" placeholder="请输入 ...">
									</div>

									<div class="form-group">
										<label>性别</label> <select class="form-control"
											name="sex" id="sex" onchange="showMsg(this)">
											<option value="男">男</option>
											<option value="女">女</option>
										</select>
									</div>

									<div class="box-footer">
										<button type="button" class="btn btn-primary"
											onClick="submitForm();">提交</button>
									</div>
								</form>

							</div>


						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
	</section>
	<!-- /.content -->




</div>
<!-- /.content-wrapper -->

<%@ include file="/view/footer.jsp"%>




<script>

function submitForm() {

var data=new Object();
    data.userName=$("#userName").val();
    data.userDspName=$("#userDspName").val();
    data.email=$("#email").val();
    data.phone=$("#phone").val();
    data.sex=$("#sex").val();
    data.password=$("#password").val();

var datafstr=JSON.stringify(data);
var requestData = datafstr;

$.ajax({
	url: '/xiaohoo-api/rest/1/userinformation/save/',
	type: 'POST',
	data: "para="+encodeURIComponent(requestData),
	async: true,
	cache: false,
	// contentType: false,
	contentType: 'application/x-www-form-urlencoded',
	processData: false,
	success: function (responseStr) {
	    alert("保存成功!");
	},
	error: function (responseStr) {
		alert("error:" + JSON.stringify(responseStr));
	}
});


}

</script>




</html>

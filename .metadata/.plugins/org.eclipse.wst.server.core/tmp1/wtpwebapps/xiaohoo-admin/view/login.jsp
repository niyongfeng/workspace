<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>xiaohoo后台管理</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/xiaohoo-admin/page/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/xiaohoo-admin/page/plugins/font-awesome-4.6.3/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/xiaohoo-admin/page/plugins/ionicons-2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/xiaohoo-admin/page/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/xiaohoo-admin/page/plugins/iCheck/square/blue.css">

  <![endif]-->
</head>

<body class="hold-transition login-page" style="background-color:#1f313a; background-image: url(/page/dist/img/wallpaper-screen.jpg);" >
<div class="login-box">
  <div class="login-logo" style="color:#f1ecec;">
    <b>校乎</b>后台管理
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">请登录</p>

    <form action="/woo-api/user/login" method="post">
      <div class="form-group has-feedback">
        <input type="text" id="username" class="form-control" value="123" placeholder="用户名/手机号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" id="password" class="form-control" value="1234561" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
            <label id="login_msg">
            </label>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="loginbutton" onclick='login();' class="btn btn-primary btn-block btn-flat">登 录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="/xiaohoo-admin/page/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/xiaohoo-admin/page/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/xiaohoo-admin/page/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
     $("body").keydown(function() {
         if (event.keyCode == "13") {//keyCode=13是回车键
         	login();
         }
     });
    
  });
  
  
function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	
	var data="{\"userName\":\""+username+"\",\"password\":\""+password+"\"}";
	$.ajax({
	    url: '/xiaohoo-api/rest/v1/administrator/login',
	    type: 'POST',
	    data: "para="+data,
	    async: true,
	    cache: false,
	    contentType: 'application/x-www-form-urlencoded',
	    processData: false,  
	    beforeSend: function(XMLHttpRequest){
	    	$('#login_msg').text("登录中......");
     	},
	    success: function (responseStr) {
	    	if(responseStr.res==0) {
	    		$('#login_msg').text("登录成功!");
	    		var user = responseStr.data.record.userName;
	    		var userId = responseStr.data.record.uid;
	    		var permission = responseStr.data.record.permission;
	    		user = encodeURI(user);
	    		userId = encodeURI(userId);
	    		var url="/xiaohoo-admin/view/session.jsp?user=" + user + "&userId=" + userId + "&permission=" + permission;
	    		location.href = url;
	    	}else{
	    		$('#login_msg').text(responseStr.message);
	    	}
	    	
	    },  
	    error: function (responseStr) {
	   	 alert("error:" + JSON.stringify(responseStr));
	    }
	});

}
  

</script>
</body>
</html>

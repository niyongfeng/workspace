<%--
  Created by IntelliJ IDEA.
  User: yangyuming
  Date: 2017/4/14
  Time: 上午10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/header.jsp" %>


<!-- Sidebar Menu -->
<%@ include file="/view/menu.jsp" %>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">

                </h4>
            </div>
            <div class="modal-body">


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick='confirmData(this);'>
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">

                </h4>
            </div>
            <div class="modal-body">


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick='confirmData(this);'>
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            管理员
            <small>新 增</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 管理员管理</a></li>
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
                                <div class="box-header with-border">
                                    <h3 class="box-title">填写管理员信息</h3>
                                </div>

                                <form>
                                    <div class="form-group has-feedback">
                                        <input type="text" id="username" class="form-control" placeholder="用户名">
                                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="text" id="email" class="form-control" placeholder="Email">
                                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" id="password" class="form-control" placeholder="密码">
                                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <input type="password" id="retype" class="form-control" placeholder="确认密码">
                                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                                    </div>
                                    <div class="form-group has-feedback">
                                        <select class="form-control" name="categoryId" id="permission"
                                                onchange="showMsg(this)">
                                            <option selected disabled hidden>选择管理员权限</option>
                                            <option value="0">浏览</option>
                                            <option value="1">修改</option>
                                            <option value="2">删除</option>
                                        </select>
                                    </div>
                                    <div class="box-footer">
                                        <button type="button" id="btn_register" class="btn btn-primary">提交
                                        </button>
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

<%@ include file="/view/footer.jsp" %>


<script>

    $('#btn_register').click(function () {
        var pwd = $('#password').val();
        var user = $('#username').val();
        var email = $('#email').val();

        if (user == "") {
            $('#username').attr({
                "value": "",
                "placeholder": "用户名不能为空"
            });
            $('#username').focus();
            return false;
        }

        if (user.length < 3 || user.length > 20) {
            $('#username').attr({
                "value": "",
                "placeholder": "长度不符合要求，必须为3-20位"
            });
            $('#username').focus();
            return false;
        }

        var pattern = /^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z]+\.)+[a-zA-Z]{2,3}$/;
        if (!pattern.test(email) && email != "") {
            $('#email').val("");
            $('#email').attr({
                "placeholder": "email格式不正确"
            });
            $('#email').focus();
            return false;
        }

        if (pwd == "") {
            $('#password').val("");
            $('#password').attr({
                "placeholder": "密码不能为空"
            });
            $('#password').focus();
            return false;
        }

        var pattern = /^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*$/;
        if (!pattern.test(pwd)) {
            $('#password').val("");
            $('#password').attr({
                "placeholder": "只能由字母或数字组成"
            });
            $('#password').focus();
            return false;
        }

        if (pwd.length < 4 || pwd.length > 12) {
            $('#password').val("");
            $('#password').attr({
                "placeholder": "长度不符合要求，必须为4-12位"
            });
            $('#password').focus();
            return false;
        }


        if (pwd != $("#retype").val()) {
            $('#password').val("");
            $('#retype').val("");
            $('#password').attr({
                "placeholder": "两次输入不一致"
            });
            $('#password').focus();
            return false;
        }

        submitForm();
    })


    function submitForm() {
        var data = new Object();
        data.userName = $("#username").val();
        data.password = $("#password").val();
        data.permission = $("#permission").val();

        var datafstr = JSON.stringify(data);
        var requestData = datafstr;

        $.ajax({
            url: '/xiaohoo-api/rest/1/administrator/add/',
            type: 'POST',
            data: "para=" + encodeURIComponent(requestData),
            async: true,
            cache: false,
            // contentType: false,
            contentType: 'application/x-www-form-urlencoded',
            processData: false,
            success: function (responseStr) {
                //                window.location.href = '/xiaohoo-admin/view/admin/adminList.jsp';
            },
            error: function (responseStr) {
//                    alert("error:" + JSON.stringify(responseStr));
                //                error:{"readyState":0,"status":0,"statusText":"error"}
            }
        });
        alert("保存成功!");
        window.location.href = '/xiaohoo-admin/view/admin/adminList.jsp';
    }

</script>


</html>


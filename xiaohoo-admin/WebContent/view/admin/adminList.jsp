<%--
  Created by IntelliJ IDEA.
  User: yangyuming
  Date: 2017/4/12
  Time: 上午11:19
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/view/header.jsp" %>

<!-- Sidebar Menu -->
<%@ include file="/view/menu.jsp" %>
<!-- /.sidebar-menu -->
</section>
<!-- /.sidebar -->
</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            管理员
            <small>列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 管理员管理</a></li>
            <li class="active">账户</li>
        </ol>
    </section>



    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">

                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">

                        <a class="btn btn-primary btn-lg" href="/xiaohoo-admin/view/admin/adminAdd.jsp"> 新 增  </a>
                        <br><br>

                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="delete_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">
                                            删除管理员
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        确定删除吗
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary" onclick='deleteData(this);' id="mbid">
                                            确定
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>

                        <div class="modal fade" id="permission_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                        <h4 class="modal-title">修改管理员权限</h4>
                                    </div>
                                    <div class="modal-body">
                                        <select class="form-control" name="categoryId" id="permission"
                                                onchange="showMsg(this)">
                                            <option selected disabled hidden>选择权限</option>
                                            <option value="0">浏览</option>
                                            <option value="1">修改</option>
                                            <option value="2">删除</option>
                                        </select>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                        </button>
                                        <button type="button" class="btn btn-primary" onclick='modifyPermission(this);' id="mbid2">
                                            确定
                                        </button>
                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>

                        <table id="tableobject" class="table table-bordered table-striped" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>用户名</th>
                                <th>权限</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                        </table>
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

    $(document).ready(function() {

        $('#tableobject').DataTable( {

            "oLanguage": {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                },
                "sZeroRecords": "没有检索到数据",
                "sProcessing":   "加载中...",
                "sLoadingRecords": "加载中..."
            },

            "searching":false,
            "aoColumnDefs": [
                { "sWidth": "15%", "aTargets": [ 0 ] },
                { "sWidth": "15%", "aTargets": [ 1 ] },
                { "sWidth": "15%", "aTargets": [ 2 ] },
                { "sWidth": "20%", "aTargets": [ 3 ] },
                { "sWidth": "20%", "aTargets": [ 4 ] },
                { "sWidth": "20%", "aTargets": [ 5 ] },
                {
                    "targets": [2],
                    "data": "uid",
                    "render": function(data, type, full) { // 返回自定义内容
                        permission_list = ['浏览','修改','删除'];
                        return permission_list[full.permission];
                    }
                },
                {
                    "targets": [5], // 目标列位置，下标从0开始
                    "data": "uid",
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<div class='btn-group' style = 'width:100%'>" +
                                "<button type='button' style = 'width:50%' class='btn btn-default' data-toggle='modal' data-target='#permission_modal' onclick='transferData2(" + full.uid + ");'>权限</button>" +
                                "<button type='button' style = 'width:50%' class='btn btn-danger btn-flat' data-toggle='modal' data-target='#delete_modal' onclick='transferData(" + full.uid + ");'>删除</button>" +
                                "</div>";
                    }
                }
            ],

            "ajax": {
                "url": "/xiaohoo-api/rest/v1/administrator/list/0/100",
                "type": "GET",
                "dataSrc": function ( json ) {
                    return json.data.administrator;
                }
            },

            "columns":[
                { "data": "uid" },
                { "data": "userName" },
                { "data": "permission" },
                { "data": "createTime" },
                { "data": "updateTime" }
            ]

        } );

    } );


    function transferData(id) {
        $('#mbid').val(id);
    }

    function transferData2(id) {
        $('#mbid2').val(id);
    }

    function deleteData(obj) {
        var id = $('#mbid').val();
        $.ajax({
            url: '/xiaohoo-api/rest/v1/administrator/delete/'+ id,
            type: 'GET',
            async: true,
            cache: false,
            processData: false,
            success: function (responseStr) {
                ShowSuccess("删除成功!");
                $('#delete_modal').modal('hide')
                $('#tableobject').DataTable().clear().draw().ajax.reload();
            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });
    }

    function modifyPermission(obj) {
        var data=new Object();
        data.uid = $('#mbid2').val();
        data.permission = $('#permission').val();

        var datafstr = JSON.stringify(data);
        var requestData = datafstr;

        $.ajax({
            url: '/xiaohoo-api/rest/1/administrator/modify/',
            type: 'POST',
            data: "para=" + encodeURIComponent(requestData),
            async: true,
            cache: false,
            // contentType: false,
            contentType: 'application/x-www-form-urlencoded',
            processData: false,
            success: function (responseStr) {
                ShowSuccess("修改成功!");
                $('#permission_modal').modal('hide')
                $('#tableobject').DataTable().clear().draw().ajax.reload();
            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });
    }


</script>

</html>

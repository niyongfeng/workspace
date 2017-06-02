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
            新闻
            <small>列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 新闻管理</a></li>
            <li class="active">新闻</li>
        </ol>
    </section>



    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">

                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">

                        <a class="btn btn-primary btn-lg" href="/xiaohoo-admin/view/news/newsAdd.jsp"> 新 增  </a>
                        <br><br>

                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                            &times;
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">

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

                        <table id="tableobject" class="table table-bordered table-striped" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>标题</th>
                                <th>作者</th>
                                <th>分类</th>
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
                { "sWidth": "30%", "aTargets": [ 0 ] },
                { "sWidth": "10%", "aTargets": [ 1 ] },
                { "sWidth": "10%", "aTargets": [ 2 ] },
                { "sWidth": "15%", "aTargets": [ 3 ] },
                { "sWidth": "15%", "aTargets": [ 4 ] },
                { "sWidth": "10%", "aTargets": [ 5 ] },
                {
                    "targets": [0], // 目标列位置，下标从0开始
                    "data": "nid", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<a href='/xiaohoo-admin/view/news/newsEdit.jsp?id=" + full.nid + "'>"+data+"</a>";
                    }
                },
                {
                    "targets": [5], // 目标列位置，下标从0开始
                    "data": "nid", // 数据列名
                    "render": function(data, type, full) { // 返回自定义内容
                        return "<button type='button' class='btn btn-block btn-danger btn-flat' data-toggle='modal' data-target='#myModal' onclick='transferData(" + full.nid + ");'>删除</button>";
                    }
                }
            ],

            "ajax": {
                "url": "/xiaohoo-api/rest/v1/news/list/0/100",
                "type": "GET",
                "dataSrc": function ( json ) {
                    return json.data.news;
                }
            },

            "columns":[
                { "data": "title" },
                { "data": "author" },
                { "data": "categoryId" },
                { "data": "updateTime" },
                { "data": "createTime" },
                { "data": "nid" }
            ]

        } );

    } );


    function transferData(id) {
        $('#mbid').val(id);
    }

    function deleteData(obj) {
        var id = $('#mbid').val();
        $.ajax({
            url: '/xiaohoo-api/rest/v1/news/delete/'+id,
            type: 'GET',
            async: true,
            cache: false,
            processData: false,
            success: function (responseStr) {
                ShowSuccess("删除成功!");
                $('#myModal').modal('hide')
                $('#tableobject').DataTable().clear().draw().ajax.reload();
            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });
    }


</script>

</html>

/**
 * Created by Javy on 2017/4/18.
 */
function showWebSafe() {
    $('.webSafe').toggle();
}
function getWebSafe() {
    $('.webSafe #WebSafeTable').DataTable( {

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
            { "sWidth": "5%", "aTargets": [ 0 ] },
            { "sWidth": "15%", "aTargets": [ 1 ] },
            { "sWidth": "6%", "aTargets": [ 2 ] },
            { "sWidth": "10%", "aTargets": [ 3 ] },
            { "sWidth": "10%", "aTargets": [ 4 ] },
            { "sWidth": "20%", "aTargets": [ 5 ] },
            { "sWidth": "10%", "aTargets": [ 6 ] },

            { "sWidth": "10%", "aTargets": [ 7 ] },
            {
                "targets": [7], // 目标列位置，下标从0开始
                "data": "nid", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button type='button' class='btn btn-block btn-danger btn-flat' data-toggle='modal' data-target='#deleteSafeCert' onclick='transferWebData(" +full.id+","+ full.webId + ");'>删除</button>";
                }
            },
            {
                "targets": [3], // 目标列位置，下标从0开始
                "data": "logo", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<img height='90px' width='100px' src=' " + full.logo + "'/>";
                }
            }
        ],

        "ajax": {
            "url": "/xiaohoo-api/rest/v1/platSupport/websafe/0/40/" +  $("#id").val(),
            "type": "GET",
            "dataSrc": function ( json ) {
                return json.data.record;
            }
        },

        "columns":[
            { "data": "id" },
            { "data": "name" },
            { "data": "type" },
            { "data": "logo" },
            { "data": "score" },
            { "data": "updateTime" },
            { "data": "createTime" },
            { "data": "webId" }
        ]

    } );

}


function transferWebData(recordId,webId) {
    $('.webSafe #recordid').val(recordId);

    $('.webSafe #webid').val(webId);
}

function deleteWebCert(obj) {
    var  safeRecordId= $('.webSafe #recordid').val();
    var   webId= $('.webSafe #webid').val();
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/websafe/delete/'+ safeRecordId +'/' + webId,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("删除成功!");
            $('.webSafe #deleteSafeCert').modal('hide');
            $('.webSafe #WebSafeTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function addWebCert(obj) {
    var platId = $('#id').val();
    var data=new Object();
    data.name = $(".webSafe #name").val();
    data.type = $(".webSafe #type").val();
    if(data.name == "" || data.type == ""){
        alert("名字和类型不能为空");
        return;
    }
    data.score = $(".webSafe #score").val();
    data.logo = $(".webSafe .logo").find("#formimage").attr("src");//img
    var requestData=JSON.stringify(data);
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/websafe/add/'+ platId ,
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("添加成功!");
            $('#addWebSafe').modal('hide');
            $('.webSafe #WebSafeTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
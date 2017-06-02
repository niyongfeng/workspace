/**
 * Created by Javy on 2017/4/18.
 */
function showTagList() {
    $('.platformTag').toggle();
}
function getTagListData(id) {
    fillTagNotIncludeOption();
    $('.platformTag #TagTable').DataTable( {

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
            { "sWidth": "20%", "aTargets": [ 0 ] },
            { "sWidth": "20%", "aTargets": [ 1 ] },
            { "sWidth": "20%", "aTargets": [ 2 ] },
            { "sWidth": "20%", "aTargets": [ 3 ] },
            { "sWidth": "20%", "aTargets": [ 4 ] },
            {
                "targets": [4], // 目标列位置，下标从0开始
                "data": "nid", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button type='button' class='btn btn-block btn-danger btn-flat' data-toggle='modal' data-target='#myModal' onclick='transferTagData(" + full.id + ");'>删除</button>";
                }
            }
        ],

        "ajax": {
            "url": "/xiaohoo-api/rest/v1/platSupport/platformRelTag/0/40/" + $('#id').val(),
            "type": "GET",
            "dataSrc": function ( json ) {
                return json.data.record;
            }
        },

        "columns":[
            { "data": "type" },
            { "data": "name" },
            { "data": "updateTime" },
            { "data": "createTime" },
            { "data": "id" }
        ]

    } );

}

function fillTagNotIncludeOption() {
    var platid = $('#id').val();
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/tagListNotInclude/0/40/'+ platid,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $("#addPlatRelTagModal #newPlatRelTag").empty();
            $("#addPlatRelTagModal #newPlatRelTag").append("<option value=0>请选择</option>");
            for (var one in responseStr.data.record)
            {
                var text = responseStr.data.record[one].name;
                var value = responseStr.data.record[one].id;
                $("#addPlatRelTagModal #newPlatRelTag").append("<option value="+value+">"+text+"</option>");
            }
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
function transferTagData(id) {
    $('.platformTag #mbid').val(id);
}

function deletePlatRelTag(obj) {
    var tagid = $('.platformTag #mbid').val();
    var platid = $('#id').val();
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/deletePlatRelTag/'+ platid +'/' + tagid,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("删除成功!");
            $('.platformTag #myModal').modal('hide');
            $('.platformTag #TagTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function addPlatRelTag(obj) {
    var tagid = $("#addPlatRelTagModal #newPlatRelTag").val();
    if(tagid == 0){
        alert("请选择一个标签");
        return;
    }
    var platid = $('#id').val();
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/addPlatRelTag/'+ platid +'/' + tagid,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("添加成功!");
            $('#addPlatRelTagModal').modal('hide');
            $('.platformTag #TagTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
/**
 * Created by Javy on 2017/4/22.
 */
function showStockholderList() {
    $('.stockholder').toggle();
}
function getStockholderList(id) {
    $('.stockholder #StockholderTable').DataTable( {

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
            { "sWidth": "10%", "aTargets": [ 0 ] },
            { "sWidth": "20%", "aTargets": [ 1 ] },
            { "sWidth": "5%", "aTargets": [ 2 ] },
            { "sWidth": "20%", "aTargets": [ 3 ] },
            { "sWidth": "20%", "aTargets": [ 4 ] },
            { "sWidth": "20%", "aTargets": [ 5 ] },
            { "sWidth": "20%", "aTargets": [ 6 ] },

            {
                "targets": [6], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button type='button' data-width='30px' data-bar-Spacing='10px' class='btn  btn-info  btn-flat' data-toggle='modal' data-target='#editStockholder' onclick='transferStockholder(" + JSON.stringify(full) + ")'>编辑</button>" +
                        "<button type='button'  class='btn  btn-danger btn-flat' data-width='30px' data-toggle='modal' data-target='#deleteStockholder' style='margin-left: 10px' onclick='transferStockholderId(" + full.id + ")'>删除</button>";
                }
            }
        ],

        "ajax": {
            "url": "/xiaohoo-api/rest/v1/company/stockholder/list/0/40/" + $('#companyId').val(),
            "type": "GET",
            "dataSrc": function ( json ) {
                return json.data.record;
            }
        },

        "columns":[
            { "data": "name" },
            { "data": "type" },
            { "data": "occupiesCompared" },
            { "data": "position" },
            { "data": "updateTime" },
            { "data": "createTime" },
            { "data": "id" }
        ]

    } );

}


function transferStockholderId(id) {
    $(".stockholder #delete").val(id);
}
function transferStockholder(full) {
    var div = $(".stockholder .editStockholder");
    div.find("#id").val(full.id);
    div.find("#name").val(full.name);
    div.find("#type").val(full.type);
    div.find("#position").val(full.position);
    div.find("#certificateType").val(full.certificateType);
    div.find("#occupiesCompared").val(full.occupiesCompared);
    div.find("#certificate").val(full.certificate);
    div.find("#registeredCapital").val(full.registeredCapital);
    div.find("#des").val(full.des);
}

function deleteStockholder(obj) {
    var businessmanId = $('.stockholder #delete').val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/stockholder/delete/'+ businessmanId,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("删除成功!");
            $('.stockholder #deleteStockholder').modal('hide');
            $('.stockholder #StockholderTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function addStockholder(obj) {
    var div = $(".stockholder .addStockholder");
    var data=new Object();
    data.name = div.find("#name").val();
    data.companyId = $("#companyId").val();
    data.type =div.find("#type").val();
    data.position =div.find("#position").val();
    data.certificateType =div.find("#certificateType").val();
    data.occupiesCompared =div.find("#occupiesCompared").val();
    data.certificate =div.find("#certificate").val();
    data.registeredCapital = div.find("#registeredCapital").val();
    data.des = div.find("#des").val();
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/stockholder/add/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("添加成功!");
            $('.stockholder #addStockholder').modal('hide');
            $('.stockholder #StockholderTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function editStockholder(obj) {
    var div = $(".stockholder #editStockholder");
    var data=new Object();
    data.id = div.find("#id").val();
    data.name = div.find("#name").val();
    data.type =div.find("#type").val();
    data.position =div.find("#position").val();
    data.certificateType =div.find("#certificateType").val();
    data.occupiesCompared =div.find("#occupiesCompared").val();
    data.certificate =div.find("#certificate").val();
    data.registeredCapital = div.find("#registeredCapital").val();
    data.des = div.find("#des").val();
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/stockholder/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("保存成功!");
            $('.stockholder #editStockholder').modal('hide');
            $('.stockholder #StockholderTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
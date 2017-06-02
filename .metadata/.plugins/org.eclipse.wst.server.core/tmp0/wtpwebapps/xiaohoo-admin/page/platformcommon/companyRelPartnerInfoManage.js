/**
 * Created by Javy on 2017/4/22.
 */
function showPartnerlist() {
    $('.partner').toggle();
}
function getPartnerData(id) {
    $('.partner #PartnerTable').DataTable( {

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
            { "sWidth": "3%", "aTargets": [ 0 ] },
            { "sWidth": "20%", "aTargets": [ 1 ] },
            { "sWidth": "20%", "aTargets": [ 2 ] },
            { "sWidth": "20%", "aTargets": [ 3 ] },
            { "sWidth": "20%", "aTargets": [ 4 ] },
            { "sWidth": "20%", "aTargets": [ 5 ] },

            {
                "targets": [5], // 目标列位置，下标从0开始
                "data": "nid", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button type='button' data-width='30px' data-bar-Spacing='10px' class='btn  btn-info  btn-flat' data-toggle='modal' data-target='#editPartnerModal' onclick='transferPartnerData2(" + JSON.stringify(full) + ")'>编辑</button>" +
                        "<button type='button'  class='btn  btn-danger btn-flat' data-width='30px' data-toggle='modal' data-target='#deleteModal' style='margin-left: 10px' onclick='transferPartnerData(" + full.id + ")'>删除</button>";
                }
            }
        ],

        "ajax": {
            "url": "/xiaohoo-api/rest/v1/company/partner/detail/" + $('#companyId').val(),
            "type": "GET",
            "dataSrc": function ( json ) {
                return json.data.record;
            }
        },

        "columns":[
            { "data": "id" },
            { "data": "name" },
            { "data": "style" },
            { "data": "updateTime" },
            { "data": "createTime" },
            { "data": "id" }
        ]

    } );

}


function transferPartnerData(id) {
    $(".partner #delete").val(id);
}
function transferPartnerData2(full) {
    $(".partner #editPartnerModal #edit").val(full.id);
    $(".partner #editPartnerModal #name").val(full.name);
    $(".partner #editPartnerModal #style").val(full.style);
}
function deletePartner(obj) {
    var partnerRecordId = $('.partner #delete').val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/partner/delete/'+ partnerRecordId,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("删除成功!");
            $('.partner #deleteModal').modal('hide');
            $('.partner #PartnerTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function addPartner(obj) {
    var div = $("#addPartnerModal");
    var data=new Object();
    data.companyId = $("#companyId").val();
     data.name = div.find("#name").val();
     data.style = div.find( "#style").val();
    if(data.name === null || data.style === null){
        alert("输入信息不完整");
        return;
    }
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/partner/add/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("添加成功!");
            $('.partner #addPartnerModal').modal('hide');
            $('.partner #PartnerTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function editPartner(obj) {
    var div = $("#editPartnerModal");
    var data=new Object();
    data.id = div.find("#edit").val();
    data.name = div.find("#name").val();
    data.style = div.find( "#style").val();
    if(data.name === null || data.style === null){
        alert("输入信息不完整");
        return;
    }
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/partner/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("保存成功!");
            $('.partner #editPartnerModal').modal('hide');
            $('.partner #PartnerTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
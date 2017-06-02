/**
 * Created by Javy on 2017/4/22.
 */
function showBusinessmanList() {
    $('.businessman').toggle();
}
function getBusinessmanList(id) {
    $('.businessman #BusinessmanTable').DataTable( {

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
            { "sWidth": "20%", "aTargets": [ 6] },
            { "sWidth": "20%", "aTargets": [ 7 ] },

            {
                "targets": [7], // 目标列位置，下标从0开始
                "data": "id", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<button type='button' data-width='30px' data-bar-Spacing='10px' class='btn  btn-info  btn-flat' data-toggle='modal' data-target='#editBusinessman' onclick='transferBusinessDate2(" + JSON.stringify(full) + ")'>编辑</button>" +
                        "<button type='button'  class='btn  btn-danger btn-flat' data-width='30px' data-toggle='modal' data-target='#deleteBusinessman' style='margin-left: 10px' onclick='transferBusinessDate(" + full.id + ")'>删除</button>";
                }
            },
            {
                "targets": [2], // 目标列位置，下标从0开始
                "data": "imgDir", // 数据列名
                "render": function(data, type, full) { // 返回自定义内容
                    return "<img height='90px' width='90px' src=' " + full.imgDir + "'/>";
                }
            }
        ],

        "ajax": {
            "url": "/xiaohoo-api/rest/v1/company/businessman/list/0/40/" + $('#companyId').val(),
            "type": "GET",
            "dataSrc": function ( json ) {
                return json.data.record;
            }
        },

        "columns":[
            { "data": "name" },
            { "data": "post" },
            { "data": "imgDir" },
            { "data": "sex" },
            { "data": "age" },
            { "data": "updateTime" },
            { "data": "createTime" },
            { "data": "id" }
        ]

    } );

}


function transferBusinessDate(id) {
    $(".businessman #delete").val(id);
}
function transferBusinessDate2(full) {
    var div = $(".businessman .editBusinessman");
    div.find("#id").val(full.id);
    div.find("#name").val(full.name);
    div.find("#hasProfessionalCertificate").val(full.hasProfessionalCertificate);
    div.find("#workExperience").val(full.workExperience);
    div.find("#hasManagementWork").val(full.hasManagementWork);
    div.find("#professionalCertificate").val(full.professionalCertificate);
    div.find("#enterpriseField").val(full.enterpriseField);
    div.find("#schoolType").val(full.schoolType);
    div.find("#enterpriseType").val(full.enterpriseType);
    div.find("#schoolType2").val(full.schoolType2);
    div.find("#school").val(full.school);
    div.find("#post").val(full.post);
    div.find("#age").val(full.age);
    div.find("#img").val(full.img);
    div.find(".imgDir #formimage").attr("src",full.imgDir);
    div.find("#education").val(full.education);
    div.find("#sex").val(full.sex);
    div.find("#des").val(full.des);
    div.find("#school2").val(full.school2);
    div.find("#other").val(full.other);

}
function deleteBusinessman(obj) {
    var businessmanId = $('.businessman #delete').val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/businessman/delete/'+ businessmanId,
        type: 'POST',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            ShowSuccess("删除成功!");
            $('.businessman #deleteBusinessman').modal('hide');
            $('.businessman #BusinessmanTable').DataTable().clear().draw().ajax.reload();
            fillTagNotIncludeOption();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function addBusinessman(obj) {
    var div = $(".businessman .addBusinessman");
    var data=new Object();
    data.cid = $("#companyId").val();
    data.name = div.find("#name").val();
    data.hasProfessionalCertificate =div.find("#hasProfessionalCertificate").val();
    data.workExperience = div.find("#workExperience").val();
    data.hasManagementWork = div.find("#hasManagementWork").val();
    data.professionalCertificate = div.find("#professionalCertificate").val();
    data.enterpriseField = div.find("#enterpriseField").val();
    data.schoolType =div.find("#schoolType").val();
    data.enterpriseType =div.find("#enterpriseType").val();
    data.schoolType2 = div.find("#schoolType2").val();
    data.school = div.find("#school").val();
    data.post = div.find("#post").val();
    data.age = div.find("#age").val();
    data.img = div.find("#img").val();
    data.imgDir = div.find(".imgDir #formimage").attr("src");
    data.education = div.find("#education").val();
    data.sex = div.find("#sex").val();
    data.des = div.find("#des").val();
    data.school2 = div.find("#school2").val();
    data.other = div.find("#other").val();
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/businessman/add/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("添加成功!");
            $('.businessman #addBusinessman').modal('hide');
            $('.businessman #BusinessmanTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

function editBusinessman(obj) {
    var div = $(".businessman #editBusinessman");
    var data=new Object();
    data.id = div.find("#id").val();
    data.cid = $("#companyId").val();
    data.name = div.find("#name").val();
    data.hasProfessionalCertificate =div.find("#hasProfessionalCertificate").val();
    data.workExperience = div.find("#workExperience").val();
    data.hasManagementWork = div.find("#hasManagementWork").val();
    data.professionalCertificate = div.find("#professionalCertificate").val();
    data.enterpriseField = div.find("#enterpriseField").val();
    data.schoolType =div.find("#schoolType").val();
    data.enterpriseType =div.find("#enterpriseType").val();
    data.schoolType2 = div.find("#schoolType2").val();
    data.school = div.find("#school").val();
    data.post = div.find("#post").val();
    data.age = div.find("#age").val();
    data.img = div.find("#img").val();
    data.imgDir = div.find(".imgDir #formimage").attr("src");
    data.education = div.find("#education").val();
    data.sex = div.find("#sex").val();
    data.des = div.find("#des").val();
    data.school2 = div.find("#school2").val();
    data.other = div.find("#other").val();
    var requestData=JSON.stringify(data);

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/businessman/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            alert("保存成功!");
            $('.businessman #editBusinessman').modal('hide');
            $('.businessman #BusinessmanTable').DataTable().clear().draw().ajax.reload();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
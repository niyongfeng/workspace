/**
 * Created by Javy on 2017/4/18.
 */

function showCompanyStructure() {
    if($(".companyStructure").is(":hidden")){
        //当前是hide状态

        getCompanyStructure();
        $('.companyStructure').toggle();
    }else{
        //当前是show状态
        $('.companyStructure').toggle();
    }
}
function getCompanyStructure(id) {
    var id = $("#companyId").val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/structure/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".companyStructure #id").val(responseStr.data.record.id);
            $(".companyStructure #companyStruc").val(responseStr.data.record.companyStruc);
            $(".companyStructure #creditInstitution").val(responseStr.data.record.creditInstitution);
            $(".companyStructure #staffNuk").val(responseStr.data.record.staffNuk);
            $(".companyStructure #branchNum").val(responseStr.data.record.branchNum);
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".companyStructure button").click(function () {
    var data=new Object();
    data.companyStruc = $(".companyStructure #companyStruc").val();
    data.creditInstitution = $(".companyStructure #creditInstitution").val();
    data.staffNuk = $(".companyStructure #staffNuk").val();
    data.id = $(".companyStructure #id").val();
    data.branchNum = $(".companyStructure #branchNum").val();

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/structure/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.companyStructure').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})


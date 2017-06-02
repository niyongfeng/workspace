/**
 * Created by Javy on 2017/4/20.
 */

function showPlatformWeb() {
    var id = $("#id").val();

    if($(".platformWeb").is(":hidden")){
        //当前是hide状态
        getPlatformWebInfo(id);
        $('.platformWeb').toggle();
    }else{
        //当前是show状态
        $('.platformWeb').toggle();
    }
}

function getPlatformWebInfo(id) {
    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/platWeb/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {

            $(".platformWeb #id").val(responseStr.data.record.id);
            $(".platformWeb #description").val(responseStr.data.record.description);
            $(".platformWeb #webUrl").val(responseStr.data.record.webUrl);
            $(".platformWeb #logoUrl").val(responseStr.data.record.logoUrl);
            $(".platformWeb #name").val(responseStr.data.record.name);
            $(".platformWeb #date").val(responseStr.data.record.date);
            $(".platformWeb #companyType").val(responseStr.data.record.companyType);
            $(".platformWeb #companyName").val(responseStr.data.record.companyName);
            $(".platformWeb #ICP").val(responseStr.data.record.icp);

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".platformWeb button").click(function () {
    var data=new Object();
    data.id = $(".platformWeb #id").val();
    data.description = $(".platformWeb #description").val();
    data.webUrl = $(".platformWeb #webUrl").val();
    data.logoUrl = $(".platformWeb #logoUrl").val();
    data.name = $(".platformWeb #name").val();
    data.date = $(".platformWeb #date").val();
    data.companyType = $(".platformWeb #companyType").val();
    data.companyName = $(".platformWeb #companyName").val();
    data.icp = $(".platformWeb #ICP").val();

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/edit/platweb/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.platformWeb').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})

/**
 * Created by Javy on 2017/4/21.
 */

function showPlatApp() {
    if($(".platApp").is(":hidden")){
        //当前是hide状态
        getPlatAppInfo();
        $('.platApp').toggle();
    }else{
        //当前是show状态
        $('.platApp').toggle();
    }
}
function getPlatAppInfo(id) {
    var id = $("#id").val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/platapp/detail/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platApp #id").val(responseStr.data.record.id);
            $(".platApp #name").val(responseStr.data.record.name);
            $(".platApp #androidAddress").val(responseStr.data.record.androidAddress);
            $(".platApp #iosAddress").val(responseStr.data.record.iosAddress);
            $(".platApp").find(".androidCodeUrl #formimage").attr("src",responseStr.data.record.androidCodeUrl);//img
            $(".platApp").find(".iosCodeUrl #formimage").attr("src",responseStr.data.record.iosCodeUrl);//img
            $(".platApp").find(".logo #formimage").attr("src",responseStr.data.record.logo);//img
            var isIos = $('.platApp input:radio[name="isIos"]');
            for(var i=0; i<isIos.length; i++){
                if(isIos[i].value == responseStr.data.record.isIos) isIos[i].checked = true;
            }
            var isAndroid = $('.platApp input:radio[name="isAndroid"]');
            for(var i=0; i<isAndroid.length; i++){
                if(isAndroid[i].value == responseStr.data.record.isAndroid) isAndroid[i].checked = true;
            }
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".platApp .update button").click(function () {
    var data=new Object();
    data.id = $(".platApp #id").val();
    data.name = $(".platApp #name").val();
    data.androidAddress = $(".platApp #androidAddress").val();
    data.iosAddress = $(".platApp #iosAddress").val();
    data.androidCodeUrl = $(".platApp .androidCodeUrl").find("#formimage").attr("src");//img
    data.iosCodeUrl = $(".platApp .iosCodeUrl").find("#formimage").attr("src");//img
    data.logo = $(".platApp .logo").find("#formimage").attr("src");//img
    data.isIos = $('.platApp input:radio[name="isIos"]:checked').val();
    data.isAndroid = $('.platApp input:radio[name="isAndroid"]:checked').val();

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/platapp/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.platApp').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})


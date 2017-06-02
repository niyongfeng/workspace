/**
 * Created by Javy on 2017/4/21.
 */

function showPlatContact() {

    if($(".platContact").is(":hidden")){
        //当前是hide状态
        getPlatContactInfo();
        $('.platContact').toggle();
    }else{
        //当前是show状态
        $('.platContact').toggle();
    }
}
function getPlatContactInfo() {
    var id = $("#id").val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/platcontact/detail/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platContact #id").val(responseStr.data.record.id);
            $(".platContact #address").val(responseStr.data.record.address);
            $(".platContact #fax").val(responseStr.data.record.fax);
            $(".platContact #weibo").val(responseStr.data.record.weibo);
            $(".platContact #phone400").val(responseStr.data.record.phone400);
            $(".platContact #email").val(responseStr.data.record.email);
            $(".platContact #phone").val(responseStr.data.record.phone);
            $(".platContact").find("#formimage").attr("src",responseStr.data.record.wechat);//img
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".platContact .update button").click(function () {
    var data=new Object();
    data.id = $(".platContact #id").val();
    data.address = $(".platContact #address").val();
    data.fax = $(".platContact #fax").val();
    data.weibo = $(".platContact #weibo").val();
    data.phone400 = $(".platContact #phone400").val();
    data.email = $(".platContact #email").val();
    data.phone = $(".platContact #phone").val();
    data.wechat = $(".platContact").find("#formimage").attr("src");//img

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/platSupport/platcontact/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.platContact').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})


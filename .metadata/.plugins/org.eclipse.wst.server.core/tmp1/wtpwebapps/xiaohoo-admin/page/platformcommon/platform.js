/**
 * Created by Javy on 2017/4/18.
 */

function showPlatform() {
    var id = $("#id").val();
    if($(".platform").is(":hidden")){
        //当前是hide状态
        getPlatFormBasicInfo(id);
        $('.platform').toggle();
    }else{
        //当前是show状态
        $('.platform').toggle();
    }
}

function getPlatFormBasicInfo(id) {

    fillProvinceOption();
    fillStateOption();
    fillCompanyOption();
    $.ajax({
        url: '/xiaohoo-api/rest/1/platform/detail/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {

            $(".platform #id").val(responseStr.data.platform.id);
            $(".platform #name").val(responseStr.data.platform.name);
            $(".platform #type").val(responseStr.data.platform.type);
            $(".platform #nameBefore").val(responseStr.data.platform.nameBefore);
            $(".platform #state").val(responseStr.data.platform.state);
            $(".platform").find("#formimage").attr("src",responseStr.data.platform.icon);//img
            $(".platform #startTime").val(responseStr.data.platform.startTime);
            $(".platform #endTime").val(responseStr.data.platform.endTime);
            $(".platform #province").val(responseStr.data.platform.province);
            $(".platform #company").val(responseStr.data.platform.company);
            var province = $(".platform #province").val();
            if(province != null)fillCityOption();
            $(".platform #city").val(responseStr.data.platform.city);

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
function fillProvinceOption() {
    $.ajax({
        url: '/xiaohoo-api/province/plist/0/40',
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platform #province").empty();
            $(".platform #province").append("<option value=0>请选择</option>");
            for (var one in responseStr.data.province)
            {
                var text = responseStr.data.province[one].name;
                var value = responseStr.data.province[one].id;
                $(".platform #province").append("<option value="+value+">"+text+"</option>");
            }

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}


function fillStateOption() {
    $.ajax({
        url: '/xiaohoo-api/rest/v1/platSupport/stateList/0/10',
        type: 'GET',
        async: false,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platform #state").empty();
            $(".platform #state").append("<option value=0>请选择</option>");
            for (var one in responseStr.data.record)
            {
                var text = responseStr.data.record[one].description;
                var value = responseStr.data.record[one].id;
                $(".platform #state").append("<option value="+value+">"+text+"</option>");
            }

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
function fillCompanyOption() {
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/list/0/10000',
        type: 'GET',
        async: false,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platform #company").empty();
            $(".platform #company").append("<option value=0>请选择</option>");
            for (var one in responseStr.data.company)
            {
                var text = responseStr.data.company[one].name;
                var value = responseStr.data.company[one].id;
                $(".platform #company").append("<option value="+value+">"+text+"</option>");
            }

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}
function fillCityOption() {
    var provinceId = $('.platform #province').val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/city/' + provinceId,
        type: 'GET',
        async: false,
        cache: false,
        processData: false,
        success: function (responseStr) {
            $(".platform #city").empty();
            $(".platform #city").append("<option value=0>请选择</option>");
            for (var one in responseStr.data.city)
            {
                var text = responseStr.data.city[one].name;
                var value = responseStr.data.city[one].id;
                $(".platform #city").append("<option value="+value+">"+text+"</option>");
            }

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".platform .update button").click(function () {
    var data=new Object();
    data.id = $(".platform #id").val();
    data.name = $(".platform #name").val();
    data.type = $(".platform #type").val();
    data.nameBefore = $(".platform #nameBefore").val();
    data.state = $(".platform #state").val();
    data.icon = $(".platform").find("#formimage").attr("src");//img
    data.startTime = $(".platform #startTime").val();
    data.endTime = $(".platform #endTime").val();
    data.province = $(".platform #province").val();
    data.company = $(".platform #company").val();
    data.city = $(".platform #city").val();

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/platform/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.platform').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})




//////////////////////////////////////img upload////////////////////////////////////
var getImgName = function (){
        var array = "ABCDEFGHIJKMNPQRSTUVWXYZ".split ("");
        var str = "";
        var reg = /^\d$/;
        var now = new Date;
        var m = now.getMonth () + 1;
        var d = now.getDate();
        var hour = now.getHours();
        var minute = now.getMinutes();
        m = reg.test(m) ? "0" + m : m;
        d = reg.test(d) ? "0" + d : d;
        hour = reg.test(hour) ? "0" + hour : hour;
        minute = reg.test(minute) ? "0" + minute : minute;
        str += now.getFullYear().toString() + m.toString() + d.toString() + hour.toString() + minute.toString();
        for ( var i = 0; i < 6; i++)
        {
            str += array[Math.floor (Math.random () * array.length)];
        }
        return str;
    };

    function copyDiv(){
        var imgdiv = $('body').contents().find('#imgdiv');
        var imgdivCopy = imgdiv.clone(true);
        imgdivCopy.attr('id',"imgdivcopy");
        imgdivCopy.attr('style',"display:block;");
        $('#imgdivpre').append(imgdivCopy);
    }
    function delDiv(object){
        $(object).parent().parent().remove();
    }


    function uploadFile(object) {
        var imgdiv = $(object).parent().parent().parent();
        imgdiv.find("#formimage").attr('src',"/xiaohoo-admin/page/giphy.gif");


        var files = imgdiv.find("#imageform_file").prop('files');

        var filename = getImgName();
        var filetype = files[0].type;
        var filesize = files[0].size;
        imgdiv.find("#imageform_key").val(filename);

        $.ajax({
            type : "get",
            url : "/xiaohoo-api/rest/1/qiniu/getUpToken",
            async : false,
            success : function(result) {
                imgdiv.find("#token").val(result.data);
            }
        });
        var formData = new FormData(imgdiv.find("#imageform")[0]);

        $.ajax({
            url: 'http://upload.qiniu.com' ,
            type: 'POST',
            data: formData,
            async: true,
            cache: false,
            contentType: false,
            processData: false,
            success: function (responseStr) {
            	alert(responseStr.key);
                imgdiv.find("#formimage").attr('src',"http://onnttczrz.bkt.clouddn.com/" + responseStr.key);
                imgdiv.find("#orginimage").attr('href',"http://onnttczrz.bkt.clouddn.com/" + responseStr.key);
                imgdiv.find("#imgname").text("地址:  http://onnttczrz.bkt.clouddn.com/" + responseStr.key);
                imgdiv.find("#imgtype").text("类型:  " + filetype);
                imgdiv.find("#imgsize").text("大小:  " + filesize + " bytes");

            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });
    }
    
///////////////////////////////////////img upload////////////////////////////////////
    
    


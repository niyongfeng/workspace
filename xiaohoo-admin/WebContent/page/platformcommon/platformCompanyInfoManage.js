/**
 * Created by Javy on 2017/4/18.
 */

function showCompanyInfo() {

    if($(".company").is(":hidden")){
        //当前是hide状态
        getCompanyInfo();
        $('.company').toggle();
    }else{
        //当前是show状态
        $('.company').toggle();
    }
}
function getCompanyInfo(id) {
    var id = $("#companyId").val();
    $.ajax({
        url: '/xiaohoo-api/rest/1/company/detail/' + id,
        type: 'GET',
        async: true,
        cache: false,
        processData: false,
        success: function (responseStr) {

            $(".company #businessScope").val(responseStr.data.record.businessScope);
            $(".company #registeredCapitalChange").val(responseStr.data.record.registeredCapitalChange);
            $(".company #name").val(responseStr.data.record.name);
            $(".company #id").val(responseStr.data.record.id);
            $(".company #type").val(responseStr.data.record.type);
            $(".company #artificialPerson").val(responseStr.data.record.artificialPerson);
            $(".company #taxImg").val(responseStr.data.record.taxImg);
            $(".company #registrationAuthority").val(responseStr.data.record.registrationAuthority);
            $(".company #businessLicence").val(responseStr.data.record.businessLicence);
            $(".company #openingDate").val(responseStr.data.record.openingDate);
            $(".company #licenceImg").val(responseStr.data.record.licenceImg);
            $(".company #registeredCapital").val(responseStr.data.record.registeredCapital);
            $(".company #contributedCapital").val(responseStr.data.record.contributedCapital);
            $(".company #registeredAddress").val(responseStr.data.record.registeredAddress);
            $(".company #approvedDate").val(responseStr.data.record.approvedDate);
            $(".company #taxRegistrationNum").val(responseStr.data.record.taxRegistrationNum);
            $(".company #institutionalFramework").val(responseStr.data.record.institutionalFramework);
            $(".company #institutionalImg").val(responseStr.data.record.institutionalImg);
            var hasAnnualReport = $('.company input:radio[name="hasAnnualReport"]');
            for(var i=0; i<hasAnnualReport.length; i++){
                if(hasAnnualReport[i].value == responseStr.data.record.hasAnnualReport) hasAnnualReport[i].checked = true;
            }

        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });
}

$(".company button").click(function () {
    var data=new Object();
    data.businessScope = $(".company #businessScope").val();
    data.registeredCapitalChange = $(".company #registeredCapitalChange").val();
    data.name = $(".company #name").val();
    data.id = $(".company #id").val();
    data.type = $(".company #type").val();
    data.artificialPerson = $(".company #artificialPerson").val();
    data.taxImg = $(".company #taxImg").val();
    data.registrationAuthority = $(".company #registrationAuthority").val();
    data.businessLicence = $(".company #businessLicence").val();
    data.openingDate = $(".company #openingDate").val();
    data.licenceImg = $(".company #licenceImg").val();
    data.registeredCapital = $(".company #registeredCapital").val();
    data.contributedCapital = $(".company #contributedCapital").val();
    data.registeredAddress = $(".company #registeredAddress").val();
    data.approvedDate = $(".company #approvedDate").val();
    data.taxRegistrationNum = $(".company #taxRegistrationNum").val();
    data.institutionalFramework = $(".company #institutionalFramework").val();
    data.institutionalImg = $(".company #institutionalImg").val();
    data.hasAnnualReport = $('.company input:radio[name="hasAnnualReport"]:checked').val();

    var datafstr=JSON.stringify(data);
    var requestData = datafstr;

    $.ajax({
        url: '/xiaohoo-api/rest/1/company/edit/',
        type: 'POST',
        data: "para="+encodeURIComponent(requestData),
        async: true,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        processData: false,
        success: function (responseStr) {
            ShowSuccess("保存成功!");
            $('.company').toggle();
        },
        error: function (responseStr) {
            alert("error:" + JSON.stringify(responseStr));
        }
    });

})


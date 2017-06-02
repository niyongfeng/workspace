<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/view/header.jsp"%>


<!-- Sidebar Menu -->
<%@ include file="/view/menu.jsp" %>
<!-- /.sidebar-menu -->

</section>
<!-- /.sidebar -->
</aside>

<style>
    table.dataTable.display tbody tr.selected {
        background-color: #acbad4;
    }
</style>

<!-- 模态框（Modal） -->
<div  class="modal fade"  id="myModal" tabindex="-1" role="dialog"  aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">

                </h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick='confirmData(this);' >
                    确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>




<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            平台文章
            <small>新 增</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 平台管理</a></li>
            <li class="active">新 增</li>
        </ol>
    </section>



    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-xs-12">

                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">

                        <div class="box box-success">

                            <div class="box-header with-border">
                                <h3 class="box-title">第一步:上传新闻图片(1)</h3>
                            </div>

                            <div id="imgdivpri" class="row">
                                <div id="imgpri">
                                    <div class="col-md-2 form-group">
                                        <label for="exampleInputFile">图片(建议上传750*380比例)</label><br>
                                        <form id="imageform" method="post" enctype="multipart/form-data">
                                            <input id="imageform_key" name="key" type="hidden">
                                            <input name="x:xiaohoo" type="hidden" value="xiaohoo">
                                            <input id="token" name="token" type="hidden" value="">
                                            <input id="imageform_file" name="file" type="file" />
                                            <input name="accept" type="hidden" />
                                        </form>
                                        <div class="box-footer">
                                            <button type="button" class="btn btn-primary" onClick="uploadFile(this);">上传</button>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <a href="" data-lightbox="example-1" id="orginimage">
                                            <img id="formimage" src="" width="250" height="250" alt="750*380" />
                                        </a>
                                        <p class="help-block" id="imgname"></p>
                                        <p class="help-block" id="imgtype"></p>
                                        <p class="help-block" id="imgsize"></p>
                                    </div>
                                </div>
                            </div>

                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">第二步:填写内容</h3>
                                </div>

                                <form role="form">
                                    <!-- text input -->
                                    <div class="form-group">
                                        <label>新闻标题</label>
                                        <input type="text" id="title" class="form-control" placeholder="请输入 ...">
                                    </div>
                                    <div class="form-group">
                                        <label>新闻摘要</label>
                                        <input type="text" id="abstracts" class="form-control" placeholder="请输入 ...">
                                    </div>
                                    <div class="form-group">
                                        <label>新闻作者</label>
                                        <input type="text" id="author" class="form-control" placeholder="请输入 ...">
                                    </div>
                                    <div class="form-group">
                                        <label>新闻来源</label>
                                        <input type="text" id="sourceSite" class="form-control" placeholder="请输入 ...">
                                    </div>

                                    <div class="form-group">
                                        <label>新闻类别</label>
                                        <select class="form-control" name="categoryId" id="categoryId" onchange="showMsg(this)">

                                            <option value="1">政策</option>
                                            <option value="2">平台</option>
                                            <option value="3">数据</option>
                                            <option value="4">观点</option>
                                            <option value="5">曝光台</option>
                                            <option value="6">理财</option>
                                            <option value="6">研究</option>
                                            <option value="6">国外</option>
                                            <option value="6">首页滚动</option>
                                        </select>
                                    </div>

                                    <!-- textarea -->
                                    <div class="form-group">
                                        <label>新闻内容</label>
                                        <textarea class="form-control" id="content" rows="15" placeholder="请输入 ..."></textarea>
                                    </div>

                                    <div class="box-footer">
                                        <button type="button" class="btn btn-primary" onClick="submitForm();">提交</button>
                                    </div>
                                </form>

                            </div>


                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
    </section>
    <!-- /.content -->




</div>
<!-- /.content-wrapper -->

<%@ include file="/view/footer.jsp"%>




<script>

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
                imgdiv.find("#formimage").attr('src',"http://7xwpgg.com1.z0.glb.clouddn.com/" + responseStr.key);
                imgdiv.find("#orginimage").attr('href',"http://7xwpgg.com1.z0.glb.clouddn.com/" + responseStr.key);
                imgdiv.find("#imgname").text("地址:  http://7xwpgg.com1.z0.glb.clouddn.com/" + responseStr.key);
                imgdiv.find("#imgtype").text("类型:  " + filetype);
                imgdiv.find("#imgsize").text("大小:  " + filesize + " bytes");

            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });
    }



    function submitForm() {

        var data=new Object();
        data.title=$("#title").val();
        data.abstracts=$("#abstracts").val();
        data.author=$("#author").val();
        data.sourceSite=$("#sourceSite").val();
        data.categoryId=$("#categoryId").val();
        data.content=$("#content").val();
        // 图片
        dataf.icon=$("#imgpri").find("#formimage").attr('src');

        var datafstr=JSON.stringify(data);
        var requestData = datafstr;

        $.ajax({
            url: '/xiaohoo-api/rest/1/news/add/',
            type: 'POST',
            data: "para="+encodeURIComponent(requestData),
            async: true,
            cache: false,
            contentType: 'application/x-www-form-urlencoded',
            processData: false,
            success: function (responseStr) {
                alert("保存成功!");
            },
            error: function (responseStr) {
                alert("error:" + JSON.stringify(responseStr));
            }
        });


    }

</script>




</html>
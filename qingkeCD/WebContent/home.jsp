<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.qingke.pojo.Dictionary"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
html,body{padding:0; margin:0;}
.d2{
position:relative;
width:800px;
/*height:180px;*/
text-align:center;
line-height:40px;
margin:0 auto;
}
</style>
<title>轻课词典</title>
</head>
<body>
<div class="d2">
<h1>轻课词典</h1>
<hr>
<a href="upload.html">上传文件</a>
<!-- <form action="SearchServlet" > -->
<br/>
<input name="word" type="text" style="width:200px;height:30px;font-size:17px;" placeholder = "请输入单词"></input>

<!-- <button type="submit" style="width:100px;height:30px;font-size:17px;">搜索</button> -->
<div id="words"></div>
<br/>

<!-- </form> -->
</div>
<script type="text/javascript" src="javascripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
		console.log(1);
		$("input[name='word']").bind("input propertychange",function(){
			var word = $("input[name='word']").val();
 			if(word.length == 0){
 			return false;
 		};
		/* function fiter(){  //监控为onchange时 用这种方法
 			var word = $("input[name='word']").val();
 			if(word.length == 0){
 			return false;
 		}; 
 		//一种
 		/* $.get("search?word="+word,function(data){
 			var array = eval("("+data+")");
 			if(array.length == 0) {
 				$("#words").append("<p>no dic</p>");
 			}
 			$("#words").empty();
 			for(var i = 0;i < array.length;i++){
 				console.log(array[i]);
 				$("#words").append("<p>"+array[i].word+":"+array[i].description+"</p>");
 			}
 		}); */
 		//第二种
 		/*  $.get("search?word="+word,function(data){
 			if(data.length == 0) {
 				$("#words").append("<p>no dic</p>");
 			}
 			<!--清空标签内的内容-->
 			$("#words").empty();
 			<!--遍历数组并把每一个元素添加到words标签内-->
 			for(var i = 0;i < data.length;i++){
 				console.log(data[i]);
 				$("#words").append("<p>"+data[i].word+":"+data[i].description+"</p>");
 			}
 		},'json');  */
 		 $.ajax({ 
 			url:"SearchServlet",
 			type:"GET",
 			data:{word:word},
 			dataType:"json",
 			async:false,
 			success: function(data){
 				if(data.length == 0) {
 					$("#words").append("<p>no dic</p>");
 	 			}
 	 			<!--清空标签内的内容-->
 	 			$("#words").empty();
 	 			<!--遍历数组并把每一个元素添加到words标签内-->
 	 			for(var i = 0;i < data.length;i++){
 	 				console.log(data[i]);
 	 				$("#words").append("<p>"+data[i].word+":"+data[i].description+"</p>");
 	 			}
 			}
 		}); 
 	});
</script>
</body>
</html>
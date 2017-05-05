/**
 * 
 */

var pcount = 0
var pageIndex = 0; // 页面索引初始值
var pageSize = 10; // 每页显示条数初始化，修改显示条数，修改这里即可
function loadData() {
	$.ajax({
		type : "get",
		url : "teacherMyVolunteerActivityServlet",
		async : false,
		cache : false,
		success : function(data, textStatus) {
			var json = eval('(' + data + ')');
			pcount = json.length
		},
		error : function() {
			console.log("ajax失败！");
			return 0;
		}
	});
}
function select() {
	var reg = new RegExp('\\d+');
	var id = reg.exec(window.location.search)[0];
	$.ajax({
		type : "get",
		url : 'teacherUpdateVolunteerActivityId',
		data : $.param({
			id : id
		}),
		cache : false, // 提交两个参数：pageIndex(页面索引)，pageSize(显示条数)
		success : function(data) {
			var json = eval('(' + data + ')');
			console.log(json);
			$("input[name='id']").val(json.id);
			$("input[name='activity_time']").val(json.activity_time);
			$("textarea[name = 'description']").val(json.description);
			$("input[name='address']").val(json.address);
			$("select[name='status']").val(json.status);
			$("input[name ='number']").val(json.number);
		}
	});
}
function deleteChair(e) {
	var id = e.parents('td').prev().text();
	$.ajax({
		type : "post",
		url : 'ManDeleteVolunteerActivity',
		data : $.param({
			id : id
		}),
		cache : false, // 提交两个参数：pageIndex(页面索引)，pageSize(显示条数)
		success : function(data) {
			if ($.trim(data) == "OK") {
				e.parents('tr').hide();
				alert("删除成功");
				location.reload(false);
				// parent.location.reload();
			} else {
				return false;
			}
		}
	});
}
$(function() {
	loadData();
	InitTable(0); // Load事件，初始化表格数据，页面索引为0（第一页）
	// 分页，PageCount是总条目数，这是必选参数，其它参数都是可选
	$("#Pagination").pagination(pcount, {
		callback : PageCallback, // PageCallback() 为翻页调用次函数。
		prev_text : "« 上一页",
		next_text : "下一页 »",
		items_per_page : pageSize,
		num_edge_entries : 2, // 两侧首尾分页条目数
		num_display_entries : 6, // 连续分页主体部分分页条目数
		current_page : pageIndex, // 当前页索引
	});
	// 翻页调用
	function PageCallback(index, jq) {
		InitTable(index);
	}
	// 请求数据
	function InitTable(pageIndex) {
		$
				.ajax({
					type : "get",
					url : 'teacherMyVolunteerActivityServlet?pageIndex='
							+ pageIndex + "&pageSize=" + pageSize, // 提交到一般处理程序请求数据
					cache : false, // 提交两个参数：pageIndex(页面索引)，pageSize(显示条数)
					success : function(data) {
						// 移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）
						console.log("开始渲染数据");
						console.log("pageIndex:" + pageIndex);
						console.log("pageSize:" + pageSize);
						console.log(data);
						// 将返回的数据追加到表格
						$(".table tr:gt(0)").remove();
						var json = eval('(' + data + ')');
						for (var i = 0; i < json.length; i++) {
							var val = json[i];
							var s = "失效";
							if (val.status == 1) {
								s = "有效";
							}
							var str = "<tr><td>"
									+ (json.length - i)
									+ "</td><td>"
									+ val.activity_time
									+ "</td><td>"
									+ val.description
									+ "</td><td>"
									+ val.number
									+ "</td><td>"
									+ val.address
									+ "</td><td>"
									+ val.credit
									+ "</td><td>"
									+ s
									+ "</td><td style=\"display:none;\">"
									+ val.id
									+ "</td><td><a href=\"teacherVolunteerActivityManage.jsp?id=" + val.id + "\"role=\"button\" data-toggle=\"modal\"><i class=\"icon-pencil\"></i></a>&nbsp;&nbsp<a href=\"#\" role=\"button\" data-toggle=\"modal\" onclick='deleteChair($(this))'><i class=\"icon-remove\"></i></a>&nbsp;&nbsp<a href=\"stunum.jsp?id="
									+ val.id
									+ "\"role=\"button\" data-toggle=\"modal\"><i class=\"icon-hand-up\"></i></a></td></tr>";

							$("#myVolunteerActivityList").after(str);
						}
						;
					}
				});
	}
});
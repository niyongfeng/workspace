/**
 * jQuery工具插件
 */
(function($){
	/** 添加对象方法 (把表单中参数转化成json格式)
	 * {"user.name" : "", "user.phone" : ""}
	 *  */
	$.fn.form2JSON = function(){
		/** 
		 * this:表单对应的jQuery对象 
		 * [{name: 'input元素的name属性值', value: 'input元素的value属性值'},{}]
		 * [{name: 'user.name', value : '李'}]
		 *  [Object { name="user.name",  value="李"},
		 *   Object { name="user.phone",  value="136"},
		 *   Object { name="user.dept.id",  value="1"}]
		 */
		var formArr = this.serializeArray();
		/** 定义数组封装json的key与value */
		var jsonArr = new Array();
		/** 循环数组 */
		$.each(formArr, function(){
			// i : 索引号
			// this == item: 数组元素 { name="user.name",  value="李"}
			// "user.name" : ""
			jsonArr.push('"' + this.name + '" : "' + this.value + '"');
		});
		return $.parseJSON("{" + jsonArr.join(",") + "}");
	};
})(jQuery);
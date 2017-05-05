/**
 * 自定义easyui验证规则
 * @author leesiuwah
 * @version 1.0
 */
(function($){
	/** 自定义验证规则 */
	$.extend($.fn.validatebox.defaults.rules, {    
	    equals: {
	        validator: function(value, param){  // 验证的函数
	        	// value : 当前文本框中的值
	        	// param : ['#password'] 参数数组
	            return value == $(param[0]).val();    
	        },    
	        message: '两次密码不一致！'   // 提示信息
	    },
	    phone: {
	        validator: function(value){  // 验证的函数
	        	// value : 当前文本框中的值
	            return /^1[3|5|7|8]\d{9}$/.test(value);
	        },    
	        message: '手机号码格式不正确！'   // 提示信息
	    },
	    regex : {
	    	validator: function(value, param){  // 验证的函数
	        	// value : 当前文本框中的值
	    		// param[0] : \d{6}
	    		var reg = new RegExp("^"+ param[0] + "$");
	            return reg.test(value);
	        },    
	        message: '格式不正确！'   // 提示信息
	    }
	});  
})(jQuery);
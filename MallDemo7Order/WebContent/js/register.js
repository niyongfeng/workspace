//不再需要了，用了bootstrap了
function submitform() {
	var loginName = $("form #loginName").val();
	var password = $("form #password").val();
	if(isStringEmpty(loginName)  || isStringEmpty(password)) {
		alert("用户名和密码不能为空");
		event.stopPropagation();
		return false;
	}
}
function isStringEmpty(str) {
	if(str == null) return true;
	if(str == undefined) return true;
	if(str == "") return true;
	return false;
}
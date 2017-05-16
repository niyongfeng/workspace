function addToCart(productId) {
	$.ajax({
		url: webContextPath + "/servlet/addcart.do?pid=" + productId,
		method: "GET",
		dataType: "json",
		error: function(xhr, status, error) {
			alert(status + " " + error);
		},
		success: function(data) {
			if(data.code != "200") {
				alert("Error:" + data.message);
			} else {
				var number = data.number;
				$("div.top span#cartnumber").text(number);
			}
		}
	});
}
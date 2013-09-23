function selectCity(value) {
	var url = "ajax!city";
	var params = {provinceId : value};
	$.post(url, params, function(data){
		var jsonObject = eval("(" + data + ")");
		$("#city").html(jsonObject.str);
	}, 'json');
}
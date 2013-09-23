function selectCity(value) {
	var url = "ajax!city";
	var params = {provinceId : value};
	$.post(url, params, function(data){
		var jsonObject = eval("(" + data + ")");
		$("#city").html(jsonObject.str);
		$("#city").selectmenu( "refresh", true );
		var city = $("#city").children('option:selected').val();
	    selectArea(city);
	}, 'json');
}

function selectArea(value) {
	var url = "ajax!area";
	var params = {cityId : value};
	$.post(url, params, function(data){
		var jsonObject = eval("(" + data + ")");
		$("#area").html(jsonObject.str);
		$("#area").selectmenu( "refresh", true );
	}, 'json');
}

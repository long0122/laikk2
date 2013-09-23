function showCustomStorage() {
		$("#customStorageDiv").show();
}

function hideCustomStorage() {
	$("#customStorageDiv").hide();
}
function showCustomAdd() {
	$("#customAdd").toggle();
}

function showCustomEdit(id,value) {
	hideCustomStorage() ;
	$("#customEditForm").attr("action","./ajax!customStorageEdit?customCategoryId="+id);
	$("#customStorageEditName").val(value);
	$("#customStorageEditDiv").show();
}


function hideCustomEdit() {
	$("#customStorageEditDiv").hide();
}


function validateCustom() {
	var customStorageName = $("#customStorageName").val();
	if (customStorageName == '') {
		showMessage("请填写分类名称");
		$("#customStorageName").focus();
	} else {
		formSubmit('customForm');
	}
}

// add form
var options = {
	beforeSubmit : showRequest, // pre-submit callback
	success : showResponse,// post-submit callback
	dataType : 'json'
	// other available options:
	// url: url // override for form's 'action' attribute
	// type: type // 'get' or 'post', override for form's 'method' attribute
	// dataType: null // 'xml', 'script', or 'json' (expected server response
	// type)
	// clearForm: true // clear all form fields after successful submit
	// resetForm: true // reset the form after successful submit

	// $.ajax options can be used here too, for example:
	// timeout: 3000
};
$('#customForm').ajaxForm(options);
//attach handler to form's submit event
$('#customForm').submit(function() {
			// submit the form
			$(this).ajaxSubmit();
			// return false to prevent normal browser submit and page navigation
			return false;
		});
function showRequest() {
	pageLoading();
}

function showResponse(msg) {
	var jsonObject = eval("(" + msg + ")");
	if (jsonObject.str != "suc") {
		pageLoading_hide();
		showMessage(jsonObject.msg);
		 $("#customStorageName").val("");
		 $("#customStorageName").focus();
		return false;
	} else {
		pageLoading_hide();
		//showMessage(jsonObject.msg);
		alert(jsonObject.msg);
		//hideCustomStorage();
		refresh();
	}
}

//edit form

function validateCustomEdit() {
	var customStorageName = $("#customStorageEditName").val();
	if (customStorageName == '') {
		showMessage("请填写分类名称");
		$("#customStorageEditName").focus();
	} else {
		formSubmit('customEditForm');
	}
}
var optionsEdit = {
		beforeSubmit : showRequest, // pre-submit callback
		success : showResponseEdit,// post-submit callback
		dataType : 'json'
		// other available options:
		// url: url // override for form's 'action' attribute
		// type: type // 'get' or 'post', override for form's 'method' attribute
		// dataType: null // 'xml', 'script', or 'json' (expected server response
		// type)
		// clearForm: true // clear all form fields after successful submit
		// resetForm: true // reset the form after successful submit

		// $.ajax options can be used here too, for example:
		// timeout: 3000
	};
$('#customEditForm').ajaxForm(optionsEdit);
//attach handler to form's submit event
$('#customEditForm').submit(function() {
			// submit the form
			$(this).ajaxSubmit();
			// return false to prevent normal browser submit and page navigation
			return false;
		});

function showResponseEdit(msg) {
	var jsonObject = eval("(" + msg + ")");
	if (jsonObject.str != "suc") {
		pageLoading_hide();
		showMessage(jsonObject.msg);
		 $("#customStorageEditName").val("");
		 $("#customStorageEditName").focus();
		return false;
	} else {
		pageLoading_hide();
		//showMessage(jsonObject.msg);
		alert(jsonObject.msg);
		//hideCustomStorage();
		refresh();
	}
}

//function goToStoragIndex() {
//	// go to index
//	if ($.mobile.ajaxEnabled) {
//		// ajax href
//		$.mobile.changePage("./main/unit!gotoStorageEdit");
//	} else {
//		// non-ajax href
//		window.location.href = "./main/unit!gotoStorageEdit";
//	}
//}
function refresh(){
	window.location.reload();
}
function formSubmit(formid) {
	$("#" + formid).submit();
	pageLoading();
}


function customDel(id){
	var url = "./ajax!customStorageDel";
	var params = {customCategoryId : id};
	$.post(url, params, function(data){
		var jsonObject = eval("(" + data + ")");
		alert(jsonObject.msg);
		refresh();
	}, 'json');
}

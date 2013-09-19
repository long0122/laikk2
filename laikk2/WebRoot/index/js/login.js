function showLogin() {
	$("#loginDiv").show();
}

function hideLogin() {
	$("#loginDiv").hide();
}

//var isSave = 0;
function validate() {
	var uname = $("#username").val();
	var pwd = $("#password").val();
	if (uname == '') {
		showMessage("请填写用户名");
		$("#username").focus();
	} else if (pwd == '') {
		showMessage("请填写密码");
		$("#password").focus();
	} else {
		formSubmit('loginForm');
	}
	//isSave = $('input[name=saveRadio][checked]').val();
}


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
$('#loginForm').ajaxForm(options);
// attach handler to form's submit event
$('#loginForm').submit(function() {
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
		 $("#password").val("");
		 $("#password").focus();
		return false;
	} else {
		pageLoading_hide();
//		if (isSave == 1) {
//			var uname = $("#username").val();
//			var pwd = $("#password").val();
//			saveLoginInfo(uname, pwd)
//		}
		
		// alertDialogWithClickAction("#loginPage", "登陆成功!", "点击'确定'返回主页",
		
		// goToIndex
		goToIndex();
	}
}

function goToIndex() {
	// go to index
	if ($.mobile.ajaxEnabled) {
		// ajax href
		$.mobile.changePage("./main/index");
	} else {
		// non-ajax href
		window.location.href = "./main/index";
	}
}
function formSubmit(formid) {
	$("#" + formid).submit();
	pageLoading();
}
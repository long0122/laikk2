//$(document).ready(function() {
//	$("a").bind("click", function() {
//				pageLoading()
//			});
//	});
	
function errpic(thepic) {
	thepic.src = "../index/images/no_pic.png" 
}

function pageLoading() {
	// $.mobile.pageLoading();
	$.mobile.showPageLoadingMsg();
}

function pageLoading_hide() {
	// $.mobile.pageLoading(true);
	$.mobile.hidePageLoadingMsg();
}

/**
 * show message
 * 
 * @param {}
 *            msg
 */
function showMessage(msg) {
	// show message
	$("<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h2>&nbsp;&nbsp;&nbsp;&nbsp;"
			+ msg + "&nbsp;&nbsp;&nbsp;&nbsp;</h2></div>").css({
				"display" : "block",
				"opacity" : 0.96,
				"top" : $(window).scrollTop() + 100
			}).appendTo($.mobile.pageContainer).delay(800).fadeOut(400,
			function() {
				$(this).remove();
			});
}

function showMyDialog(dialogId) {
	$.mobile.changePage("#" + dialogId);
}
/*
function alertDialog(obj,title,subTitle) {
	$(obj).simpledialog({
				'mode' : 'bool',
				'prompt' :title,
				'subTitle':subTitle,
				'cleanOnClose':true,
				'useModal' : true,
				'buttons' : {
					'确定' : {
						click : function() {
							
						}
					}
				}
			});
}
*/
function alertDialog(obj,content) {
	$(obj).simpledialog({
				'mode' : 'bool',
				'prompt' :'',
				'subTitle':content,
				'cleanOnClose':true,
				'useModal' : true,
				'buttons' : {
					'确定' : {
						click : function() {
							
						}
					}
				}
			});
}

function alertDialogWithClickAction(obj,title,subTitle,okAction) {
	$(obj).simpledialog({
				'mode' : 'bool',
				'prompt' :title,
				'subTitle':subTitle,
				'cleanOnClose':true,
				'useModal' : true,
				'buttons' : {
					'确定' : {
						click : okAction
					}
				}
			});
}


function goToCMain(value) {
	if (value != '0') {
		var basePath = $('#basePath').val();
		var path = basePath + "main/index!cMain?cId=" + value;
		if ($.mobile.ajaxEnabled) {
			$.mobile.changePage(path);
		} else {
			window.location.href = path;
		}
	}
}

function saveLoginInfo(uname, pwd) {
	if (window.localStorage) {
		localStorage.login_uname = uname;
		localStorage.login_pwd = pwd;
	} else {
		alert('抱歉，您的浏览器不支持保存登陆信息');
	}

}
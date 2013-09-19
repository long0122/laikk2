<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="./global.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		${meta_view}
		<title>${session_title}</title>
		<meta name="Keywords" content="${meta_keywords}" />
		<meta name="Description" content="${meta_description}" />
	</head>
	<!--  onLoad="setup()" -->
	<body>
		<div data-role="page" id="msgPage" class="page">
		<a href="${basePath}" class="logo" style="margin-top: 15px;margin-bottom: -15px"><img src="${basePath}index/images/logo.png"></a>
			<div class="res_login">
				<span>${msg_title}<a href="#"><img
							src="${basePath}index/images/icon_register.png"> </a> </span>
			</div>
			<div data-role="content" style="margin-left: 10px">
				<p style="margin: 10px 0 10px 10px">
					${msg_content}
				</p>
				<p>
					<a href="${msg_url}" data-ajax="false">&lt;&lt;返回</a>
				</p>
			</div>



			<%@ include file="./footer.jsp"%>
		</div>
	</body>
</html>

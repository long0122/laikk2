<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'center.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
-->
</style>
		<style>
.navPoint {
	COLOR: white;
	CURSOR: hand;
	FONT-FAMILY: Webdings;
	FONT-SIZE: 9pt
}
</style>
		<script>
	function switchSysBar() {
		var locate = location.href.replace('center.jsp', '');
		var ssrc = document.all("img1").src.replace(locate, '');
		if (ssrc == "images/main_18.gif") {
			document.all("img1").src = "admin/images/main_18_1.gif";
			document.all("frmTitle").style.display = "none"
		} else {
			document.all("img1").src = "admin/images/main_18.gif";
			document.all("frmTitle").style.display = ""
		}
	}
</script>

	</head>

	<body>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed;">
			<tr>
				<td width="173" id=frmTitle noWrap name="fmTitle" align="center"
					valign="top">
					<c:if test="${userAdmin.role.code == '01'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/manageLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
					<c:if test="${userAdmin.role.code == '02'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/technologyLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
					<c:if test="${userAdmin.role.code == '03'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/cityLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
					<c:if test="${userAdmin.role.code == '04'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/columnLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
					<c:if test="${userAdmin.role.code == '05'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/entryLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
					<c:if test="${userAdmin.role.code == '06'}">
						<iframe name="I1" height="100%" width="180"
							src="admin/menu/unitLeft.html" border="0" frameborder="0"
							scrolling="auto"></iframe>
					</c:if>
				</td>
				<td width="8" valign="middle" background="admin/images/main_12.gif"
					onclick=switchSysBar()>
					<span class="navPoint"><img src="admin/images/main_18.gif"
							name="img1" width=8 height=52 id=img1>
					</span>
				</td>
				<td align="center" valign="top">
					<iframe name="I2" height="100%" width="100%" border="0"
						frameborder="0" src="admin/welcome/welcome.html"></iframe>
				</td>
				<td width="4" align="center" valign="top"
					background="images/main_20.gif"></td>
			</tr>
		</table>
	</body>
</html>

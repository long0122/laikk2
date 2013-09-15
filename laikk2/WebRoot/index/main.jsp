<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		${meta_view}
		<title>${session_title }</title>
		<meta name="Keywords" content="来看看，移动商城-来看看商城网" />
		<meta name="Description" content="来看看网站是一家专门从事移动互联网内容提供商.内容覆盖全国大部分一,二线城市,实时提供当地生活相关的酒店,餐饮,娱乐,汽车,房产,婚庆,教育,电器,装修,影院等10多个栏目,条理清晰,内容简洁,便于移动用户浏览的专业性网站." />
	</head>
	<body>
		<div data-role="page" id="mainPage" data-theme="${theme_page}">
			Unit:
			<c:forEach items="${unitList}" var="u">
						<li>
							${u.name}
						</li>
					</c:forEach>
					
					
		</div>
	</body>
</html>

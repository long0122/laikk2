<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function toggleShadow(id){
	$("#"+id).toggleClass("shadow");
}
</script>
<div data-role="header" data-theme="${theme_header}">
	<h1>laikankan.cn</h1>
	<div class="switch">
	<a href="${basePath}main/province!provinceList"  data-role="button" data-theme="b" data-mini="true" data-icon="arrow-d" data-iconpos="right">切换城市</a>
	<!--<c:if test="${userIndex==null}">
			<a href="${basePath}login!toLogin"><img id="headerLoginImg"
					src="${basePath}index/images/header_login.png"
					onclick="toggleShadow('headerLoginImg')" />
			</a>&nbsp;&nbsp;
	</c:if> <c:if test="${userIndex!=null}">
			<a href="${basePath}main/index!toMenu"><img id="headerMenuImg"
					src="${basePath}index/images/header_menu.png"
					onclick="toggleShadow('headerMenuImg')" />
			</a>&nbsp;&nbsp;
	</c:if> <a href="${basePath}main/search!toSearch"><img id="headerSearchImg"
				src="${basePath}index/images/header_search.png"
				onclick="toggleShadow('headerSearchImg')" />
	</a>-->
	
	&nbsp;&nbsp; </div>
</div>
<!-- /header -->


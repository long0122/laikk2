<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path_ = request.getContextPath();
	String basePath_ = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path_ + "/";
%>

<!-- verson:1.1.0-->
<link href="<%=basePath_%>index/jquery-mobile/jquery.mobile.theme-1.0.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath_%>index/jquery-mobile/jquery.mobile.structure-1.0.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath_%>index/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=basePath_%>index/jquery-mobile/jquery-1.6.4.min.js" type="text/javascript"></script>
<script src="<%=basePath_%>index/js/init.js" type="text/javascript"></script>
<script src="<%=basePath_%>index/jquery-mobile/jquery.mobile-1.0.min.js" type="text/javascript"></script>

<!-- my js -->
<script src="<%=basePath_%>index/js/global.js"></script> 



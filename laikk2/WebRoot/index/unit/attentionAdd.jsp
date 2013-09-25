<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../global/global.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		${meta_view}
		<title>${session_title}</title>
		<meta name="Keywords" content="${meta_keywords}" />
		<meta name="Description" content="${meta_description}" />
	</head>
	<body>
		<div data-role="page" id="attAddPage" class="com_pany page">
			<script type="text/javascript">
			$("#attAddPage").live("pageshow", function() {
				
			});
		</script>
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					添加关注
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>

			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
					<div id="addDiv">
						<ul data-role="listview"   data-filter="true" data-filter-placeholder="检索关键字" data-inset="true">
						<c:forEach items="${attUnits}" var="u">
							<li><a href="${basePath}main/unit!attentionAdd?id=${u.id}"  onclick="return confirm('您确定添加${u.name }为关注企业吗?')">${u.name }</a></li>
						</c:forEach>
	   
						</ul>
					</div>
					已关注企业：
					<c:forEach items="${attentions}" var="att">
						${att.attUnit.name}
					</c:forEach>
					
				</div>
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>

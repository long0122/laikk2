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
		<div data-role="page" id="adCustomListPage" class="com_pany page">
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					商品列表
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>

			<div class=" com_pany_li">

			<div data-role="content">
				<ul class="product">
				<c:forEach items="${advertisementList}" var="a">
					<li>
						<a href="#"><span><img
									src="${basePath}${a.picture}" onerror="errpic(this)"> <em>${a.title}</em>
						</span>
							<div class="product_list">
								<span>编辑 删除</span>
							</div>
							<div class="cl"></div>
						</a>
					</li>
				</c:forEach>
					<div class="cl"></div>
				</ul>
				<div class="res_btn">
									<input type="submit" value="加载更多"> 
								</div>
			</div>
			
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>

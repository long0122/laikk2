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
		<div data-role="page" id="storageEditPage"
			class="com_pany page category category_li">
			<script type="text/javascript"
				src="${basePath}index/js/storageEdit.js"></script>
			<script type="text/javascript">
	$("#storageEditPage").live("pageshow", function() {
		$("#customStorageBt").click(function(){
			showCustomStorage() ;
			});
		
		$("#customCloseBt").click(function(){
			hideCustomStorage() ;
			});
		$("#customAddBt").click(function(){
			showCustomAdd() ;
			});
		
	});
</script>
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					仓库管理
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>
			<div class="com_pany_li">
				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
					<div class="width94">
						<div class="goods_top">
							<span class="fl"><a href="${basePath}main/ad!gotoAdd">商品录入</a>&nbsp;&nbsp;
								<a href="${basePath}main/ad!gotoCustomAdd">自定义商品录入</a> </span><a
								href="#" class="fr" id="customStorageBt">分类管理</a>
							<div class="cl"></div>
						</div>
						<div>
							<h3>
								<strong>在仓商品</strong><span> <c:if
										test="${!empty advertisementList}">
										<a href="${basePath}main/ad!storageAdEditList" data-ajax="false"><strong>点击查看更多 >></strong>
										</a>
									</c:if>
								</span>
							</h3>
							<ul>
								<c:forEach items="${advertisementList}" var="ad">
									<li>
										${ad.title}
										<span> <a href="${basePath}main/ad!gotoEdit?adType=1&id=${ad.id}"><img
													src="${basePath}index/images/icon_2.png">
										</a> <a href="javascript:window.location.href='${basePath}main/ad!del?id=${ad.id}'"  onclick="return confirm('您确定删除吗?')"><img src="${basePath}index/images/icon_3.png">
										</a> </span>
									</li>
								</c:forEach>

								<c:if test="${empty advertisementList}">
									<li>
										暂无相关信息
									</li>
								</c:if>

							</ul>
						</div>
						<div>

							<strong>自定义分类</strong>

							<div data-role="collapsible-set">
								<c:forEach items="${customCategoryList}" var="c">
									
										<h3>
										<!--  
											<c:if test="${!empty c.advertisements}">
												<a href="#">${c.name}(${fn:length(c.advertisements)})</a>
											</c:if>
											<c:if test="${empty c.advertisements}">${c.name}(${fn:length(c.advertisements)})</c:if>
											-->
											<a href="${basePath}main/ad!customEditList?customStorage=${c.id}" data-ajax="false">${c.name}(${fn:length(c.advertisements)})</a>
										</h3>
								
								</c:forEach>
							</div>
						</div>

					</div>
				</div>
				<%@ include file="../global/footer.jsp"%>
			</div>

			<!-- 分类管理 -->
			<div class="customer" style="top: 30%; display: none"
				id="customStorageDiv">
				<h1>
					添加分类
				</h1>
				<div>
					<dl>
						<dt>
							<span><a href="#" id="customAddBt">添加分类<img
										src="${basePath}index/images/icon.png"> </a>
							</span>
							<span><a href="#" id="customCloseBt">关闭</a>
							<img src="${basePath}index/images/icon_1.png">
							</span>
							<div class="cl"></div>
						</dt>

						<dd id="customAdd" style="display: none">
							<form action="${basePath}ajax!customStorageAdd" method="post"
								id="customForm" data-ajax="false">
								<input type="text" name="customStorageName"
									id="customStorageName" placeholder="分类名称" />
								<input type="button" value="确定" onclick="validateCustom()" />
							</form>
							<div class="cl"></div>
						</dd>

						<dd>
							<c:forEach items="${customCategoryList}" var="c">
								<p>
									<span>${c.name}</span>
									<a href="javascript:customDel(${c.id})"
										onclick="return confirm('删除分类将删除该分类下的所有商品，确定删除${c.name}吗?')"><img
											src="${basePath}index/images/icon_3.png">
									</a>
									<a href="#" onclick="showCustomEdit(${c.id},${c.name})"><img
											src="${basePath}index/images/icon_2.png"
											style="margin: 0 6px 0 0;">
									</a>


								</p>
								<div class="cl"></div>
							</c:forEach>

							<!-- 
							<p>
								<span>红石榴果蔬市场</span>
								<a href="#"><img src="${basePath}index/images/icon_2.png"
										style="margin: 0 6px 0 0;">
									<img src="${basePath}index/images/icon_3.png">
								</a>
							</p>
							
							<div class="cl"></div>
						 -->
						</dd>
					</dl>
				</div>
			</div>

			<!-- 分类修改-->
			<div class="customer" style="top: 30%; display: none"
				id="customStorageEditDiv">
				<h1>
					修改分类
				</h1>
				<div>
					<dl>
						<dt>
							<span><a href="#" onclick="hideCustomEdit()">关闭</a>
							<img src="${basePath}index/images/icon_1.png">
							</span>
							<div class="cl"></div>
						</dt>

						<dd id="customEdit">
							<form action="${basePath}ajax!customStorageAdd" method="post"
								id="customEditForm" data-ajax="false">
								<input type="text" name="customStorageName"
									id="customStorageEditName" placeholder="分类名称" />
								<input type="button" value="确定" onclick="validateCustomEdit()" />
							</form>
							<div class="cl"></div>
						</dd>


					</dl>
				</div>
			</div>


		</div>

	</body>
</html>

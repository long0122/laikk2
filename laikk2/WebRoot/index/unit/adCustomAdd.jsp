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
		<div data-role="page" id="adCustomAddPage" class="com_pany page">
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					商品录入
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>

			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
					<form id="adAddForm" action="${basePath}main/ad!customAdd" method="post"
						enctype="multipart/form-data" data-ajax="false">
						<div class="width94">
							<div class="company_sum">
								<dl>
									<dt>
										产品名称
									</dt>
									<dd>
										<input type="text" name="title">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
								<dt>
									商户产品分类
								</dt>
								<dd>
									<select name="customStorage">
										<c:forEach items="${customCategoryList}" var="c">
										<option value="${c.id}">
											${c.name}
										</option>
										</c:forEach>
									</select>
								</dd>
								<div class="cl"></div>
							</dl> 
								<dl>
									<dt>
										产品介绍
									</dt>
									<dd>
										<textarea name="content"></textarea>
									</dd>
									<div class="cl"></div>
								</dl>

								<dl style="width: 50%; float: left;">
									<dt>
										原价
									</dt>
									<dd style="width: 70%; display: inline-block">
										<input type="text" name="price">
									</dd>
									￥
									<div class="cl"></div>
								</dl>
								<dl style="width: 50%; float: left;">
									<dt>
										折扣价
									</dt>
									<dd style="width: 70%; display: inline-block">
										<input type="text" name="pricePro">
									</dd>
									￥
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										添加图片：
									</dt>
									<dd>
										<input type="file" name="picture">
									</dd>
									<div class="cl"></div>
								</dl>

								<div class="cl"></div>
								<div class="res_btn">
									<input type="submit" value="提交"> 
								</div>
								
								<div class="res_red">
									<span>*</span>为必填选项，如需帮助可查看
									<a href="#">帮助说明</a>
								</div>
							</div>
						</div>
					</form>
				</div>
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>

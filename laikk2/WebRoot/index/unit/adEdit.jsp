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
					商品编辑
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>

			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
					<form id="adAddForm" action="${basePath}main/ad!edit" method="post"
						enctype="multipart/form-data" data-ajax="false">
						<input type="hidden" name="id" value="${advertisement.id}"/>
						<div class="width94">
							<div class="company_sum">
								<dl>
									<dt>
										产品名称
									</dt>
									<dd>
										<input type="text" name="title" value="${advertisement.title }">
									</dd>
									<div class="cl"></div>
								</dl>
							<c:if test="${adType==2}">
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
							</c:if>
								<dl>
									<dt>
										产品介绍
									</dt>
									<dd>
										<textarea name="content">${advertisement.content}</textarea>
									</dd>
									<div class="cl"></div>
								</dl>

								<dl style="width: 50%; float: left;">
									<dt>
										原价
									</dt>
									<dd style="width: 70%; display: inline-block">
										<input type="text" name="price" value="${advertisement.price}">
									</dd>
									￥
									<div class="cl"></div>
								</dl>
								<dl style="width: 50%; float: left;">
									<dt>
										折扣价
									</dt>
									<dd style="width: 70%; display: inline-block">
										<input type="text" name="pricePro"  value="${advertisement.pricePro}">
									</dd>
									￥
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										添加图片：
										<c:if test="${advertisement.picture!=null}"><span class="green">(已上传)</span>
										<a href="${basePath}${advertisement.picture}" target="_blank">点击查看</a>
										</c:if>
										<c:if test="${advertisement.picture==null}"><span class="red">(未上传)</span></c:if>
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

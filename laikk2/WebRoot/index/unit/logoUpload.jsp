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
		<div data-role="page" id="page" class="com_pany page">
			<div data-role="header">
				<a data-ajax="false" href="javascript:window.history.back()"
					data-rel="back"><img src="${basePath}index/images/back.png" />
				</a>
				<h1>
					企业Logo上传
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>
			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>

					<div class="width94">
						<form id="unitLogoUploadForm" action="${basePath}main/unit!logoUpload"
							method="post" enctype="multipart/form-data" data-ajax="false">
							<div class="company_sum">
								<dl>
									<dt>
										企业Logo：
										<c:if test="${unitIndex.logo!=null}"><span class="green">(已上传)</span>
										<a href="${basePath}${unitIndex.logo}" target="_blank">点击查看</a>
										</c:if>
										<c:if test="${unitIndex.logo==null}"><span class="red">(未上传)</span></c:if>
									</dt>
									<dd>
										<input type="file" name="logo">
									</dd>
									<div class="cl"></div>
								</dl>

								<div class="res_btn">
									<input type="submit" value="上传"> 
								</div>

							</div>
						</form>
						
					</div>
				</div>
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>

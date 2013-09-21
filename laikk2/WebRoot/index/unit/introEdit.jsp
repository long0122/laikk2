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
					编辑
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>
			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
					<form id="unitIntroEditForm"
						action="${basePath}main/unit!introEdit" method="post"
						enctype="multipart/form-data" data-ajax="false">
						<div class="width94">
							<p class="company_text">
								企业简介
							</p>
							<div class="company_sum">
								<dl>
									<dt>
										企业名称
									</dt>
									<dd>
										<input type="text" name="name" value="${unitIndex.name}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										所属行业
									</dt>
									<dd>
										<select name="">
											<option value="${userIndex.category.id}">
												${userIndex.category.name }
											</option>
											<c:forEach items="${categoryList}" var="cInfo">
												<optgroup label="${cInfo.category.name}">
													<c:if test="${!empty cInfo.childrenList}">
														<c:forEach items="${cInfo.childrenList}" var="c">
															<option value="${c.id }">
																${c.name}
															</option>
														</c:forEach>

													</c:if>

												</optgroup>
											</c:forEach>

										</select>
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										企业简介
									</dt>
									<dd>
										<textarea name="intro">${unitIndex.intro}</textarea>
									</dd>
									<div class="cl"></div>
								</dl>

								<dl>
									<dt>
										联系电话
									</dt>
									<dd>
										<input type="text" name="telephone"
											value="${unitIndex.telephone}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										QQ
									</dt>
									<dd>
										<input type="text" name="qq" value="${unitIndex.qq}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										传真
									</dt>
									<dd>
										<input type="text" name="fax" value="${unitIndex.fax}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										固定电话
									</dt>

									<dd>
										<input type="text" name="phone" value="${unitIndex.phone}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										地址
									</dt>
									<dd>
										<input type="text" name="addr" value="${unitIndex.addr}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										电子邮件
									</dt>
									<dd>
										<input type="text" name="email" value="${unitIndex.email}">
									</dd>
									<div class="cl"></div>
								</dl>
								<dl>
									<dt>
										企业图片(非logo)
										<c:if test="${unitIndex.unitImg!=null}">
											<span class="green">(已上传)</span>
											<a href="${basePath}${unitIndex.unitImg}" target="_blank">点击查看</a>
										</c:if>
										<c:if test="${unitIndex.unitImg==null}">
											<span class="red">(未上传)</span>
										</c:if>
									</dt>
									<dd>
										<input type="file" name="unitImg">

									</dd>
									<div class="cl"></div>
								</dl>
								<div class="res_btn">
									<input type="submit" value="确定">

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

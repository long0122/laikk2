<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="./global/global.jsp"%>
<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		${meta_view}
		<title>${session_title}</title>
		<meta name="Keywords" content="${meta_keywords}" />
		<meta name="Description" content="${meta_description}" />
	</head>
	<!--  onLoad="setup()" -->
	<body>
		<div data-role="page" id="regPage" class="page">
					<script type="text/javascript">
	$("#regPage").live("pageshow", function() {
		//setup();
	});
</script>

			<div class="home_top">
				<img src="${basePath}index/images/advert.jpg">
				<div>
					<a href="#"> &nbsp;</a><a href="#" class="on"> &nbsp;</a><a
						href="#"> &nbsp;</a><a href="#"> &nbsp;</a>
					<div class="cl"></div>
				</div>
			</div>
			<div data-role="content">
				<!-- search -->
				<%@ include file="./global/search.jsp"%>
			</div>
			<div class="res_login">
				<span>企业注册<a href="#"><img
							src="${basePath}index/images/icon_register.png"> </a> </span>
			</div>
				<form id="unitAddForm" action="${basePath}main/unit!add" method="post"  enctype="multipart/form-data">
			<div class="res_text">
				<dl>
					<dt>
						<input type="text" name="username" placeholder="用户名">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>
						<input type="password" name="password" placeholder="密码">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>
						<input type="password" name="password2" placeholder="确认密码">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>
					
						<input type="text" placeholder="企业名称" name="name" >
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>企业logo:
						<input type="file" name="file"><br/>
					<input type="file" name="logo" id="logo"/>
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<!-- 
				<dl>
					<dt>公众平台二维码:
					<input type="file" name="public2dBarcode">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>企业二维码:
					<input type="file" name="unit2dBarcode">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
					<dl>
					<dt>企业营业执照:
					<input type="file" name="busLicense">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				 -->
					<!-- 
				<dl class="res_upload">
					<dt>
						<input type="text" placeholder="企业logo" name="logo" >
						<div class="cl"></div>
					</dt>
					<dd>
						<input type="file" value="浏览" class="res_file">
						<span>浏览</span>
					</dd>
					<dd>
						<input type="button" value="上传">
					</dd>
					<div class="cl"></div>
				</dl>
				<dl class="res_upload">
					<dt>
						<input type="text" placeholder="公众平台二维码" name="public2dBarcode" >
						<div class="cl"></div>
					</dt>
					<dd>
						<input type="file" value="浏览" class="res_file">
						<span>浏览</span>
					</dd>
					<dd>
						<input type="button" value="上传">
					</dd>
					<div class="cl"></div>
				</dl>
			
				<dl class="res_upload">
					<dt>
						<input type="text" placeholder="企业二维码" name="unit2dBarcode">
						<div class="cl"></div>
					</dt>
					<dd>
						<input type="file" value="浏览" class="res_file">
						<span>浏览</span>
					</dd>
					<dd>
						<input type="button" value="上传">
					</dd>
					<div class="cl"></div>
				</dl>
				<dl class="res_upload">
					<dt>
						<input type="text" placeholder="企业营业执照" name="busLicense">
						<div class="cl"></div>
					</dt>
					<dd>
						<input type="file" value="浏览" class="res_file">
						<span>浏览</span>
					</dd>
					<dd>
						<input type="button" value="上传">
					</dd>
					<div class="cl"></div>
				</dl>
				 -->
				<dl>
					<dt>
						<input type="text" placeholder="身份证" name="idCard">
						<span class="red">*</span>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl>
					<dt>
						<select name="category">
							<option value="-1">
								商户分类
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
					</dt>
					<div class="cl"></div>
				</dl>
				<dl style="width: 46%;" class="fl">
					<dt>
						<select id="s1">
							<option value="">
								省份
							</option>
						</select>
					</dt>
					<div class="cl"></div>
				</dl>
				<dl style="width: 46%;" class="fr">
					<dt>
						<select id="s2" name="city">
							<option value="">
								地级市
							</option>
						</select>
					</dt>
					<div class="cl"></div>
				</dl>
				<div class="cl"></div>
				<dl>
					<p style="font-size: 0.8em;">
						套餐选择：
					</p>
					<ul class="discount member_dis">
						<li>
							<a href="#" class="dis_first"><img
									src="${basePath}index/images/member_pic.png">
								<p>
									VIP
								</p> </a>
						</li>
						<li>
							<a href="#"><img src="${basePath}index/images/member_pic.png">
								<p>
									VIP
								</p> </a>
						</li>
						<div class="cl"></div>
					</ul>
					<ul class="discount member_dis">
						<li>
							<a href="#" class="dis_first"><img
									src="${basePath}index/images/member_pic.png">
								<p>
									VIP
								</p> </a>
						</li>
						<li>
							<a href="#"><img src="${basePath}index/images/member_pic.png">
								<p>
									VIP
								</p> </a>
						</li>
						<div class="cl"></div>
					</ul>
				</dl>
				<div class="res_btn">
					<input type="submit" value="注册">
				</div>
				<div class="res_red">
					<span>*</span>为必填选项，如需帮助可查看
					<a href="#">帮助说明</a>
				</div>
			</div>
			</form>
			<%@ include file="./global/footer.jsp"%>
		</div>
	</body>
</html>

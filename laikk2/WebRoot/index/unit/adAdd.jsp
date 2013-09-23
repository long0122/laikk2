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
		<div data-role="page" id="adAddPage" class="com_pany page">
			<script type="text/javascript">
	$("#adAddPage").live("pageshow", function() {
		$("#bt1").click(function() {
			$("#adAddForm").attr("action", "${basePath}main/ad!add?state=0");
			$("#adAddForm").submit();
		});
		$("#bt2").click(function() {
			$("#adAddForm").attr("action", "${basePath}main/ad!add?state=1");
			$("#adAddForm").submit();
		});
		$("#bt3").click(function() {
			$("#adAddForm").attr("action", "${basePath}main/ad!add?state=2");
			$("#adAddForm").submit();
		});
	});
</script>
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
					<form id="adAddForm" action="" method="post"
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
								<!-- <dl>
								<dt>
									产品分类
								</dt>
								<dd>
									<select name="">
										<option>
											商户分类
										</option>
										<option>
											商户分类
										</option>
									</select>
								</dd>
								<div class="cl"></div>
							</dl> -->
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
								<ul class="discount member_dis entering">
									<li>
										<a href="#" class="dis_first" id="bt1"><img
												src="${basePath}index/images/member_pic.png">
											<p>
												上传到仓库
											</p> </a>
									</li>
									<li>
										<a href="#" id="bt2"><img
												src="${basePath}index/images/member_pic.png">
											<p>
												上传到全部
											</p> </a>
									</li>
									<li class="last">
										<a href="#" class="dis_last" id="bt3"><img
												src="${basePath}index/images/member_pic.png">
											<p>
												上传到折扣
											</p> </a>
									</li>
									<div class="cl"></div>
								</ul>
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

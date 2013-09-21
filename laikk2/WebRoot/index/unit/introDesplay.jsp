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
					企业简介
				</h1>
				<a href="#"><img src="${basePath}index/images/category.png">
				</a>
			</div>
			<div class=" com_pany_li">

				<div data-role="content">
					<%@ include file="./global/unitHeader.jsp"%>
	 <div class="width94">
    <div class="company_logo"><img src="${basePath}${unitIndex.unitImg}">
      <p>${unitIndex.intro}</p>
      <div class="tel"><span>${unitIndex.telephone}</span></div>
      <p>电话：${unitIndex.phone}<br>QQ：${unitIndex.qq}<br>电子邮件：${unitIndex.email}<br>传真：${unitIndex.fax}<br>地址：${unitIndex.addr}</p>
    </div>
  </div>
				</div>
				<%@ include file="../global/footer.jsp"%>
			</div>
		</div>
	</body>
</html>

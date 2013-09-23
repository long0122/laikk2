<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<script src="js/prototype.lite.js" type="text/javascript"></script>
		<script src="js/moo.fx.js" type="text/javascript"></script>
		<script src="js/moo.fx.pack.js" type="text/javascript"></script>
		<title>无标题文档</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

-->
#container {
	width: 167px;
}

H1 {
	font-size: 12px;
	margin: 0px;
	width: 167px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;
}

H1 a {
	display: block;
	width: 167px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgs.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}

.content {
	width: 167px;
	height: 26px;
}

.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}

.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 167px;
	padding-left: 0px;
}

.MM {
	width: 167px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px, 0px, 0px, 0px);
}

.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 167px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 167px;
	text-decoration: none;
}

.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 167px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 167px;
	text-decoration: none;
}
</style>
	</head>

	<body>
		<table width="173" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed;">
			<tr>
				<td style="width: 4px; background-image: url(images/main_16.gif)">
					&nbsp;
				</td>
				<td width="169" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" background="images/main_11.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">


									<div id="container">
										<h1 class="type">
											<a href="javascript:void(0)">注册用户管理</a>
										</h1>
										<div class="content">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td>
														<img src="images/menu_topline.gif" width="167" height="5" />
													</td>
												</tr>
											</table>
											<ul class="MM">
												<li>
													<a href="<%=basePath%>user" target="I2">用户管理</a>
												</li>
												<li>
													<a href="<%=basePath%>admin/success.jsp?url=aaa" target="I2">success</a>
												</li>
											</ul>
										</div>
									</div>

									<h1 class="type">
										<a href="javascript:void(0)">网站常规管理</a>
									</h1>
									<div class="content">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<img src="images/menu_topline.gif" width="167" height="5" />
												</td>
											</tr>
										</table>
										<ul class="MM">
											<li>
												<a href="http://www.865171.cn" target="I2">基本设置</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">邮件设置</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">广告设置</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">114增加</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">114管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">联系方式</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">汇款方式</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">增加链接</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="I2">管理链接</a>
											</li>
										</ul>
									</div>
									<h1 class="type">
										<a href="javascript:void(0)">栏目分类管理</a>
									</h1>
									<div class="content">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<img src="images/menu_topline.gif" width="167" height="5" />
												</td>
											</tr>
										</table>
										<ul class="MM">
											<li>
												<a href="http://www.865171.cn" target="main">信息分类</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">信息类型</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">资讯分类</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">地区设置</a>
											</li>
											<li>
												<a target="main" href="http://www.865171.cn">市场联盟</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商家类型</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商家星级</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商品分类</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商品类型</a>
											</li>
										</ul>
									</div>
									<h1 class="type">
										<a href="javascript:void(0)">栏目内容管理</a>
									</h1>
									<div class="content">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<img src="images/menu_topline.gif" width="167" height="5" />
												</td>
											</tr>
										</table>
										<ul class="MM">
											<li>
												<a href="http://www.865171.cn" target="main">信息管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">张贴管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">增加商家</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">管理商家</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">发布资讯</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">资讯管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">市场联盟</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">名片管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商城管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商品管理</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商城留言</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">商城公告</a>
											</li>
										</ul>
									</div>

									<h1 class="type">
										<a href="javascript:void(0)">其它参数管理</a>
									</h1>
									<div class="content">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<img src="images/menu_topline.gif" width="167" height="5" />
												</td>
											</tr>
										</table>
										<ul class="MM">
											<li>
												<a href="http://www.865171.cn" target="main">管理设置</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">主机状态</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">攻击状态</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">登陆记录</a>
											</li>
											<li>
												<a href="http://www.865171.cn" target="main">运行状态</a>
											</li>
										</ul>
									</div>
								</div>
								<script type="text/javascript">
	var contents = document.getElementsByClassName('content');
	var toggles = document.getElementsByClassName('type');

	var myAccordion = new fx.Accordion(toggles, contents, {
		opacity : true,
		duration : 400
	});
	myAccordion.showThisHideOpen(contents[0]);
</script>





								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>


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
<div class=" com_pany_li">
  <div class="home_top"><img src="${basePath}index/images/advert.jpg">
    <div><a href="#"> &nbsp;</a><a href="#" class="on"> &nbsp;</a><a href="#"> &nbsp;</a><a href="#"> &nbsp;</a>
      <div class="cl"></div>
    </div>
  </div>
  <div data-role="content">
  <%@ include file="./global/unitHeader.jsp"%>
    
    <div class="width94">
    <ul class="discount member_dis">
      <li><a href="${basePath}main/unit!gotoIntroEdit" class="dis_first"><div><img src="${basePath}index/images/icon_member10.png"></div>
        <p>企业简介</p>
        </a></li>
      <li><a href="company_job.html"><div><img src="${basePath}index/images/icon_member5.png"></div>
        <p>招聘</p>
        </a></li>
      <li class="last"><a href="product-all.html" class="dis_last"><div><img src="${basePath}index/images/icon_member3.png"></div>
        <p>全部商品</p>
        </a></li>
      <li><a href="stencil.html" class="dis_first"><div><img src="${basePath}index/images/icon_member11.png"></div>
        <p>选择模版</p>
        </a></li>
      <li><a href="company_fc.html"><div><img src="${basePath}index/images/icon_member4.png"></div>
        <p>企业风采</p>
        </a></li>
      <li class="last"><a href="company-summary_on.html" class="dis_last"><div><img src="${basePath}index/images/icon_member12.png"></div>
        <p>基本信息</p>
        </a></li>
        <li><a href="#" class="dis_first"><div><img src="${basePath}index/images/icon_member13.png"></div>
        <p>添加关注</p>
        </a></li>
      <li><a href="company-customer.html"><div><img src="${basePath}index/images/icon_member14.png"></div>
        <p>添加客户</p>
        </a></li>
      <li class="last"><a href="goods.html" class="dis_last"><div><img src="${basePath}index/images/icon_member6.png"></div>
        <p>我的仓库</p>
        </a></li>
        <li><a href="company-active.html" class="dis_first"><div><img src="${basePath}index/images/icon_member15.png"></div>
        <p>申请活动</p>
        </a></li>
      <li><a href="company-summary_on.html"><div><img src="${basePath}index/images/icon_member16.png"></div>
        <p>形象照片</p>
        </a></li>
      <li class="last"><a href="#" class="dis_last"><div><img src="${basePath}index/images/icon_member17.png"></div>
        <p>升级套餐</p>
        </a></li>
        <li><a href="${basePath}main/unit!gotoBarcodeUpload" class="dis_last"><div><img src="${basePath}index/images/icon_member13.png"></div>
        <p>二维码上传</p>
        </a></li>
      <div class="cl"></div>
    </ul>
     </div>
  </div>
  <%@ include file="../global/footer.jsp"%>
</div>
</div>
	</body>
</html>

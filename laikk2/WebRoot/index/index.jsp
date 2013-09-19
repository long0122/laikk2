<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="./global/global.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<div data-role="page" id="page" class="page">
  <div class="home_top"><img src="${basePath}index/images/advert.jpg">
    <div><a href="#"> &nbsp;</a><a href="#" class="on"> &nbsp;</a><a href="#"> &nbsp;</a><a href="#"> &nbsp;</a>
      <div class="cl"></div>
    </div>
  </div>
  <div data-role="content"> 
 <%@ include file="./global/search.jsp"%> 
    <div style="padding:26px 0;">
      <div class="ui-grid-c ui-top-icon">
        <div class="ui-block-a"><span><a href="category.html"><img src="${basePath}index/images/index_home1.png"></a></span></div>
        <div class="ui-block-b"><span><a href="#" onclick="showLogin()"><img src="${basePath}index/images/index_home2.png"></a></span></div>
        <div class="ui-block-c"><span><a href="${basePath}main/index!gotoReg"><img src="${basePath}index/images/index_home3.png"></a></span></div>
        <div class="ui-block-d"><a href="city.html"><img src="${basePath}index/images/index_home4.png"></a></div>
      </div>
      <div class="ui-grid-c">
        <div class="ui-block-a"><a href="category.html">商品分类</a></div>
        <div class="ui-block-b"> <c:if test="${userIndex==null}"><a href="#" onclick="showLogin()">登录</a></c:if>
        <c:if test="${userIndex!=null}"><a href="${basePath}main/unit!unitIndex">企业管理</a></c:if>
        </div>
        <div class="ui-block-c"><c:if test="${userIndex==null}"><a href="${basePath}main/index!gotoReg">免费注册</a></c:if>
         <c:if test="${userIndex!=null}"><a href="${basePath}main/login!logoutIndex"  data-ajax="false" onclick="return confirm('您确定注销吗?')">注销登录</a></c:if>
        </div>
        <div class="ui-block-d"><a href="city.html">代理加盟</a></div>
      </div>
    </div>
    <p class="look">看看大家都在看什么？</p>
    <div class="ui-grid-a">
      <div class="ui-block-a ui-purple">
        <div><span class="look_first"><em>41</em>%</span><span>的人去唱KTV</span>
          <div class="cl"></div>
        </div>
      </div>
      <div class="ui-block-b ui-green">
        <div><span class="look_first"><em>20</em>%</span><span>的人去了游乐园</span>
          <div class="cl"></div>
        </div>
      </div>
      <div class="ui-block-a ui-pink">
        <div><span class="look_first"><em>17</em>%</span><span>的人去健身</span>
          <div class="cl"></div>
        </div>
      </div>
      <div class="ui-block-b ui-red">
        <div><span class="look_first"><em>15</em>%</span><span>的人去吃甜品饮料</span>
          <div class="cl"></div>
        </div>
      </div>
    </div>
    <div class="index_class"><span>今日折扣</span><a href="product.html" class="fr">更多折扣</a>
      <div class="cl"></div>
    </div>
    <ul class="discount">
      <li><a href="#" class="dis_first"><img src="${basePath}index/images/discount_pic1.png">
        <p>美食</p>
        </a></li>
      <li><a href="#"><img src="${basePath}index/images/discount_pic2.png">
        <p>女装</p>
        </a></li>
      <li><a href="#"><img src="${basePath}index/images/discount_pic3.png">
        <p>母婴</p>
        </a></li>
      <li><a href="#" class="dis_last"><img src="${basePath}index/images/discount_pic1.png">
        <p>美食</p>
        </a></li>
      <li><a href="#" class="dis_first"><img src="${basePath}index/images/discount_pic1.png">
        <p>美食</p>
        </a></li>
      <li><a href="#"><img src="${basePath}index/images/discount_pic2.png">
        <p>女装</p>
        </a></li>
      <li><a href="#"><img src="${basePath}index/images/discount_pic3.png">
        <p>母婴</p>
        </a></li>
      <li><a href="#" class="dis_last"><img src="${basePath}index/images/discount_pic1.png">
        <p>美食</p>
        </a></li>
      <div class="cl"></div>
    </ul>
    <div class="index_class"><span>推荐商家</span>
      <div class="cl"></div>
    </div>
    <div class="seller_tab"><a href="#" class="on">&nbsp;</a><a href="#">&nbsp;</a><a href="#">&nbsp;</a><div class="cl"></div></div>
    <ul class="seller">
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic1.png"></span></a></li>
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic2.png"></span></a></li>
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic3.png"></span></a></li>
      <li><a href="#" class="last"><span><img src="${basePath}index/images/seller_pic4.png"></span></a></li>
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic1.png"></span></a></li>
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic2.png"></span></a></li>
      <li><a href="#"><span><img src="${basePath}index/images/seller_pic3.png"></span></a></li>
      <li><a href="#" class="last"><span><img src="${basePath}index/images/seller_pic4.png"></span></a></li>
      <li><a href="#" class="three_last"><span><img src="${basePath}index/images/seller_pic1.png"></span></a></li>
      <li><a href="#" class="three_last"><span><img src="${basePath}index/images/seller_pic2.png"></span></a></li>
      <li><a href="#" class="three_last"><span><img src="${basePath}index/images/seller_pic3.png"></span></a></li>
      <li><a href="#" class="last three_last"><span><img src="${basePath}index/images/seller_pic4.png"></span></a></li>
      <div class="cl"></div>
    </ul>
  </div>
  <%@ include file="./global/footer.jsp"%>
</div>
	</body>
</html>

<%@ page language="java" pageEncoding="utf-8"%>

<div class="nav_bottom">
    <div class="nav_bottom_li">
      <div class="fl">
      <c:if test="${userIndex==null}"><a href="#" onclick="showLogin()">登录</a></c:if>
        <c:if test="${userIndex!=null}"><a href="${basePath}main/login!logoutIndex"  data-ajax="false" onclick="return confirm('您确定注销吗?')">注销登录</a></c:if>
      <span class="pipe">|</span><a href="${basePath}main/index!gotoReg">免费注册</a><span class="pipe">|</span><a href="#">客户端下载</a></div>
      <a class="fr" href="#">返回顶部</a>
      <div class="cl"></div>
    </div>
  </div>
  <div class="nav_bott"><a href="${basePath}"><span><img src="${basePath}index/images/bot_nav.png"><em>首页</em></span></a><a href="category.html"><span><img src="${basePath}index/images/bot_nav1.png"><em>分类</em></span></a><a href="#"><span><img src="${basePath}index/images/bot_nav2.png"><em>品牌</em></span></a><a href="product-all.html" class="last"><span><img src="${basePath}index/images/bot_nav.png"><em>购物</em></span></a><div class="cl"></div></div>
  <div class="bottom"><a href="#">普通版</a><span class="pipe">|</span><a href="#" class="on">触屏版</a><span class="pipe">|</span><a href="#">电脑版</a><span class="pipe">|</span><a href="#">微信</a>
  <p>Copyright &copy;2013 鲁B5-20080000</p>
  </div>
  
  
    <%@ include file="./login.jsp"%>
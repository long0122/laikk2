<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <div class="company"><a href="${basePath}main/unit!gotoLogoUpload"><img src="${basePath}${unitIndex.logo}" class="fl" onerror="errUnitLogoPic(this)"></a>
      <div class="fl">
        <p style="margin:0 0 9px;"><a href="${basePath}main/unit!gotoIntroDesplay" style="color:#353535; text-decoration:none; font-weight:normal;">${unitIndex.name}</a><br>
        <img src="${basePath}index/images/icon_star.png">${unitIndex.level.name}</p>
        <div class="company_date"><span>260</span><p>DAY</p></div>
        <div class="company_login"><span class="first">
        
        <a href="${basePath}main/login!logoutIndex"  data-ajax="false" onclick="return confirm('您确定注销吗?')">注销</a></span><span><a href="${basePath}main/index!gotoReg">免费注册</a></span></div><div class="cl"></div>
      </div>
      <div class="cl"></div>
    </div>

    <div style="padding:0px 0 20px;">
      <div class="ui-grid-c member_class">
        <div class="ui-block-a"><a href="#">分享</a></div>
        <div class="ui-block-b"><a href="#">关注</a></div>
        <div class="ui-block-c"><a href="#">公众平台</a></div>
        <div class="ui-block-d"><a href="#">二维码</a></div>
      </div>
    </div>


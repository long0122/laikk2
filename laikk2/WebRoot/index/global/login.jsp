<%@ page language="java" pageEncoding="utf-8"%>

<!-- login page -->
<script type="text/javascript" src="${basePath}index/jquery-mobile/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}index/js/login.js"></script>
 <div class="login" id="loginDiv" style="display: none">
 <form action="${basePath}ajax!login" method="post" id="loginForm" data-ajax="false">
    <div class="login_text"><input type="text" name="username" id="username" class="login_input" placeholder="手机号/会员名"></div>
    <div class="login_text"><input type="password" name="password" id="password" class="login_pass" placeholder="密码"></div>
    <div style="border:0px;"><input type="button" value="登录"  onclick="validate()"></div>
    <div class="pass">
    <!-- <input name="saveRadio" id="saveRadio" type="checkbox" value="1"><span class="fl">记住密码</span> --><a href="#" class="fr" onclick="hideLogin()">返回</a><a href="#" class="fr">找回密码</a><a href="${basePath}main/index!gotoReg" class="fr">免费注册</a><div class="cl"></div></div>
    <div class="cooperate"> <span>使用合作帐号登录：</span><div><a href="#" style=" border-left:1px solid #d7d7d7;"><img src="images/icon_login1.png"></a><a href="#"><img src="images/icon_login2.png"></a><a href="#"><img src="images/icon_login3.png"></a><a href="#"><img src="images/icon_login4.png"></a><div class="cl"></div></div></div>
</form>  
</div>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>来看看后台登陆界面</title>
		<LINK href="admin/login/images/Default.css" type=text/css
			rel=stylesheet>
		<LINK href="admin/login/images/xtree.css" type=text/css rel=stylesheet>
		<LINK href="admin/login/images/User_Login.css" type=text/css
			rel=stylesheet>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
	</HEAD>
	<BODY id=userlogin_body>
	<center>
		<DIV></DIV>

		<DIV id=user_login>
			<DL>
				<DD id=user_top>
					<UL>
						<LI class=user_top_l></LI>
						<LI class=user_top_c></LI>
						<LI class=user_top_r></LI>
					</UL>
					<DD id=user_main>
						<UL>
							<LI class=user_main_l></LI>
							<LI class=user_main_c>
								<DIV class=user_main_box>
									<form action="login" method="post">
										<UL>
											<LI class=user_main_text>
												用户名：
											</LI>
											<LI class=user_main_input>
												<INPUT class=TxtUserNameCssClass id=name maxLength=20
													name=name value="">
											</LI>
										</UL>
										<UL>
											<LI class=user_main_text>
												密 码：
											</LI>
											<LI class=user_main_input>
												<INPUT class=TxtPasswordCssClass id=password type=password
													name=password value="">
											</LI>
										</UL>
										<UL>
											<LI class=user_main_text>
												验证码：
											</LI>
											<LI class=user_main_input>
												<INPUT class=TxtValidateCodeCssClass type=text
													name="checkCode" size="6">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<img src="admin/login/checkCode.jsp" border=0>
											</LI>
										</UL>
								</DIV>
							</LI>
							<LI class=user_main_r>
								<span style="cursor:pointer"><INPUT class="IbtnEnterCssClass"
									type="image" src="admin/login/images/user_botton.gif"></span>
							</LI>
						</UL>
						</form>
					</DD>
				<DD id=user_bottom>
					<UL>
						<LI class=user_bottom_l></LI>
						<LI class=user_bottom_c>
							<SPAN style="MARGIN-TOP: 40px">欢迎访问来看看网站后台管理系统</SPAN>
						</LI>
						<LI class=user_bottom_r></LI>
					</UL>
				</DD>
			</DL>
		</DIV>
		<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
		<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
		<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

		<DIV></DIV>

		</center>
	</BODY>
</HTML>

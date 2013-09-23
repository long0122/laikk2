<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户列表</title>
		<link rel="stylesheet" type="text/css" href="admin/tab/css/tab.css">
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="30">
								<img src="admin/tab/images/tab_03.gif" width="15" height="30" />
							</td>
							<td background="admin/tab/images/tab_05.gif">
								<img src="admin/tab/images/311.gif" width="16" height="16" />
								<span class="STYLE4">用户列表</span>
							</td>
							<td align="right" background="admin/tab/images/tab_05.gif">
								<span class="STYLE4"><a href="system/user!toAdd"><img
											src="admin/tab/images/001.gif" width="16" height="16"
											border="0" />增加</a></span> &nbsp;&nbsp;
							</td>
							<td width="14">
								<img src="admin/tab/images/tab_07.gif" width="14" height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="admin/tab/images/tab_12.gif">
								&nbsp;
							</td>
							<td bgcolor="#F3FFEE">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#CECECE">
									<tr>
										<td height="18" background="admin/tab/images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												用户名
											</div>
										</td>
										<td width="10%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												昵称
											</div>
										</td>
										<td width="10%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												角色
											</div>
										</td>
										<td width="15%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												城市
											</div>
										</td>
										<td width="10%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												栏目
											</div>
										</td>
										<td width="5%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												状态
											</div>
										</td>
										<td width="20%" height="18"
											background="admin/tab/images/tab_14.gif" class="STYLE1">
											<div align="center" class="STYLE2">
												操作
											</div>
										</td>
									</tr>
									<s:iterator value="users" var="u">
										<tr>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													${u.username}
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													${u.nickname}
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													${u.role.name}
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
													${u.city.province.province} - ${u.city.city}
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
												${u.category.parent.name}  ${u.category.name}
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE2 STYLE1">
												<s:if test="#u.state==\"1\"">
													<font color="green">正常</font> 
												</s:if>
												<s:else>
													<font color="red">不可用</font> 
												</s:else>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF">
												<div align="center">
												<img
															src="admin/tab/images/011.gif" width="9" height="9" /><span
														class="STYLE1"> [</span><a
														href="system/user!toSee?id=${u.id}">查看</a><span
														class="STYLE1">]</span>&nbsp;&nbsp;&nbsp;&nbsp;<img
															src="admin/tab/images/010.gif" width="9" height="9" /><span
														class="STYLE1"> [</span><a
														href="system/user!deleteForSearch?userinfo.id=${u.id}" onclick="return confirm('您确定删除吗?')">删除</a><span
														class="STYLE1">]</span>
												</div>
											</td>
										</tr>
									</s:iterator>
									<s:if test="users==null||users.size==0">
											<td height="18" bgcolor="#FFFFFF" class="STYLE2" colspan="7"><div align="center" class="STYLE2 STYLE1">暂无数据...</div></td>
									</s:if>
								</table>
							</td>
							<td width="9" background="admin/tab/images/tab_16.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="29">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="29">
								<img src="admin/tab/images/tab_20.gif" width="15" height="29" />
							</td>
							<td background="admin/tab/images/tab_21.gif"
								class="STYLE2 STYLE1">

								&nbsp;
							</td>
							<td width="14">
								<img src="admin/tab/images/tab_22.gif" width="14" height="29" />
							</td>
						</tr>
					</table>


					<!-- 分页 -->
					<s:if test="users!=null&&users.size!=0">
					<form id="form3" name="form3" action="system/user!search" method="post">
						<table width="100%" height="29" border="0" class="STYLE2 STYLE1">
							<tr>
								<td width="50%" align="left">
									&nbsp;&nbsp;&nbsp;&nbsp; 共
									<s:property value="pager.rowCount" />
									条记录&nbsp;&nbsp;&nbsp;&nbsp; 第
									<s:property value="pager.pageNo" />
									/
									<s:property value="pager.pageCount" />
									页&nbsp;&nbsp;&nbsp;&nbsp;
									<span>跳转到第<s:select list="pager.pageNoIndexs"
											name="pageNoSelect"
											onchange="javascript:document.all.isTo.value='1';document.all.form3.submit();"
											value="pager.pageNo" />页 <input name="isTo" type="hidden">
									</span>
								</td>


								<td align="right">
									<span> <input name="pageNo" type="hidden"> <a
										href="javascript:document.all.pageNo.value='<s:property value="pager.firstPageNo"/>';document.all.form3.submit();"><img
												src="admin/images/first.gif" border="0" /></a>&nbsp; <a
										href="javascript:document.all.pageNo.value='<s:property value="pager.prePageNo"/>';document.all.form3.submit();"><img
												src="admin/images/back.gif" border="0" /></a>&nbsp; <a
										href="javascript:document.all.pageNo.value='<s:property value="pager.nextPageNo"/>';document.all.form3.submit();"><img
												src="admin/images/next.gif" border="0" /></a>&nbsp; <a
										href="javascript:document.all.pageNo.value='<s:property value='pager.lastPageNo'/>';document.all.form3.submit();"><img
												src="admin/images/last.gif" border="0" /></a> </span>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>

							</tr>
						</table>
					</form>
	</s:if>
					<!-- 分页 end-->
				</td>
			</tr>
		</table>
	</body>
</html>


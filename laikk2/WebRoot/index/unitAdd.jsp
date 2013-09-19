<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>企业添加</title>
		<link rel="stylesheet" type="text/css" href="admin/tab/css/tab.css" />
		<script type="text/javascript" src="js/jqm/jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="admin/js/city.js"></script>
		<!-- jquery validate -->
		<link rel="stylesheet" type="text/css" media="screen" href="admin/validate/css/cmxform.css" />
		<script src="admin/validate/jquery/jquery.js" type="text/javascript"></script>
		<script src="admin/validate/jquery/jquery.validate.js" type="text/javascript"></script>
		<script src="admin/validate/unit/unitAdd.js" type="text/javascript" charset="GBK"></script>
		<style type=text/css>
			.STYLE1 {
				FONT-FAMILY: "宋体";
				FONT-SIZE: 12px
			}
			
			.STYLE6 {
				COLOR: #ff0000
			}
			
			TD {
				FONT-FAMILY: 宋体;
				FONT-SIZE: 12px
			}
		</style>
		<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-min.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[id="kindeditor"]', {
				cssPath : '${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css',
				uploadJson : '${pageContext.request.contextPath}/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '${pageContext.request.contextPath}/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true
			});
			prettyPrint();
		});
	</script>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="30">
								<img src="admin/tab/images/tab_03.gif" width="15" height="30" />
							</td>
							<td background="admin/tab/images/tab_05.gif">
								<img src="admin/tab/images/311.gif" width="16" height="16" />
								<span class="STYLE4">企业添加</span>
							</td>
							<td align="right" background="admin/tab/images/tab_05.gif">
								&nbsp;
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
								<!-- content  -->
								<form id="unitAddForm" action="${basePath}main/unit!add" method="post"  enctype="multipart/form-data">
									<TABLE border=0 cellSpacing=0 cellPadding=1 width="100%">
										<TBODY>
											<TR>
												<TD height=8 colSpan=6></TD>
											</TR>
											<TR>
												<TD width=10>
													&nbsp;
												</TD>
												<TD bgColor=#009900 colSpan=4>
													<table border=0 cellspacing=1 cellpadding=0 width="100%">
														<tbody>
															<tr class=STYLE1 height=30 bgcolor=#ffffff>
																<td bgcolor=#EDFECF width="16%" align=right>
																	企业名称：&nbsp;&nbsp;
																</td>
																<td>
																	&nbsp;&nbsp;
																	<input type="text" name="name">
																	<font color="red">*</font>
																</td>

															</tr>
														
														
															<tr class=STYLE1 height=30 bgcolor=#ffffff>
																<td bgcolor=#EDFECF width="16%" align=right>
																	地址：&nbsp;&nbsp;
																</td>
																<td>
																	&nbsp;&nbsp;
																	<input type="text" name="address">
																	
																</td>
															</tr>
															<tr class=STYLE1 height=30 bgcolor=#ffffff>
																<td bgcolor=#EDFECF width="16%" align=right>
																	联系电话：&nbsp;&nbsp;
																</td>
																<td>
																	&nbsp;&nbsp;
																	<input type="text" name="phone">
																</td>
															</tr>
															<tr class=STYLE1 height=30 bgcolor=#ffffff>
																<td bgcolor=#EDFECF width="16%" align=right>
																	联系方式：&nbsp;&nbsp;
																</td>
																<td>
																	&nbsp;&nbsp;
																	<textarea id="kindeditor" name="contact" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
																	
																</td>
															</tr>
															<tr class=STYLE1 height=30 bgcolor=#ffffff>
																<td bgcolor=#EDFECF width="16%" align=right>
																	企业标志图片：&nbsp;&nbsp;
																</td>
																<td>
																	&nbsp;&nbsp;
																	<input type="file" name="file"><br/>
																	 <span class="STYLE6">提示：为了前台页面显示效果,请上传宽和高比例为1:1的图片</span>
																	
																</td>
															</tr>
														</tbody>
													</table>
												</TD>
												<TD width=10>
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD height=8 colSpan=6></TD>
											</TR>

											<TR>
												<TD height=5 colSpan=6></TD>
											</TR>
											<TR>
												<TD width=10>
													&nbsp;
												</TD>
												<TD class=STYLE6 colSpan=4>
													<B>&nbsp;&nbsp;其中带*号为必填项</B>
												</TD>
												<TD width=10>
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD height=5 colSpan=6></TD>
											</TR>
											<TR>
												<TD width=10>
													&nbsp;
												</TD>
												<TD colSpan=4 align=middle>
													<input value="保存 " type="submit"/>
														&nbsp;&nbsp;&nbsp; 
														<input value="返回" type="button" onclick="javascript:window.history.back()" />
												</TD>
												<TD width=10>
													&nbsp;
												</TD>
											</TR>
										</TBODY>
									</TABLE>
								</form>

								<!-- content  end -->
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
							<td background="admin/tab/images/tab_21.gif">
								&nbsp;
							</td>
							<td width="14">
								<img src="admin/tab/images/tab_22.gif" width="14" height="29" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>


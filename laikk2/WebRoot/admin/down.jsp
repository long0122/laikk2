<%@ page language="java" import="java.util.*, java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #147233;
}
-->
</style>
<%
      Calendar rightNow = Calendar.getInstance();
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
String sysdate = format.format(rightNow.getTime()); 
int week = rightNow.get(rightNow.DAY_OF_WEEK); 
String weekary[] ={"月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日"};
%>

<script language="javascript"> 
//从服务器上获取初始时间 
var currentDate = new Date(<%=new java.util.Date().getTime()%>); 
function run() 
{ 
currentDate.setSeconds(currentDate.getSeconds()+1); 
document.getElementById("dt").innerHTML = currentDate.toLocaleString();     
} 
window.setInterval("run();", 1000); 
</script> 
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="23" background="images/main_25.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="181" height="23" background="images/main_24.gif">&nbsp;</td>
        <td><div align="right" class="STYLE1">今天是：<span id="dt"></span>
        &nbsp;&nbsp;&nbsp;&nbsp;</div></td>
        <td width="25"><img src="images/main_27.gif" width="25" height="23" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>



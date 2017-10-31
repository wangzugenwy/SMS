<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>无标题文档</title>
<style>
<!--
.erro{
	background:#FFD2D2;
	color:#FFFFFF;
	margin:auto;
}
#erro{
	width:190px;
	height:120px;
	border:1px #7ECAFE solid;
	background:#D2EDFF;
	padding:10px;
	font-size:14px;
	color:#990000;
	line-height:20px;
	position:relative;
	left:-5px;
	top:-5px;
	margin:auto;
	z-index:102;
	margin:auto;
	filter:alpha(opacity=100);


}

.text_16c_black{
	font-weight:bold;
	font-size:16px;
	color:#000000;
	line-height:17px;
}
#erro_shadow{
	width:210px;
	height:140px;
	background:#999999;
	margin:auto;
	z-index:101;
margin-top:200px;

}
#div_content{
	width:100%;
	text-align:center;
	background:black;
	filter:alpha(opacity=50);
-moz-opacity:0.5;
opacity: 0.5;
 position:absolute; left:0;
right:0; top:0; bottom:0; 
z-index:99; height:100%;

}
-->
</style>
</head>

<body style="height:100%;">
<input name="text" type="text" class="erro" style="border:1px #CCCCCC solid;" />
<input name="text" type="text"  style="border:1px #CCCCCC solid; background:#F5F5F5;" />
<div id="erro_shadow">
<div id="erro">
<span class="text_16c_black">出错信息！！</span><br /><br />
·第一条信息<br />
·第二条信息<br />


<button style="width:75px; height:25px; border:0px; background:none; margin-top:20px; cursor:hand;"><img src="images/close_button.gif" width="75" height="25" border="0" style="" /></button>
</div>
</div>
<div id="div_content">

</div>
  </body>
</html>

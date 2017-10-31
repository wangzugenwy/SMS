<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.model.BookGroup" %>
<%@page import="com.model.AddressBook" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>SMS—添加通讯录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function deleteadressbook() {
	var targetForm=document.getElementById("addbookadress"); 
	//动态修改目标表单的action属性 
	targetForm.submit();
}

</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="300"><img src="images/logo.jpg" width="300" height="100" border="0" /></td>
    <td width="100%" style="background:url(images/banner_bg.jpg) left top repeat-x;">&nbsp;</td>
    <td width="477"><img src="images/banner_img.jpg" width="477" height="100" border="0" /></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(images/top_tab_bg.jpg) left top repeat-x;">
  <tr>
  <form>
    <td width="20">&nbsp;</td>
    <td width="200" align="left"><img src="images/left_top.jpg" width="200" height="35" /></td>
    <td width="80" style="padding-left:110px;" align="right" class="text_14c_black">信息搜索：</td>
    <td width="200" align="left"><input type="text" style="width:190px; border:1px #CCCCCC solid; background:#F5F5F5;" /></td>
    <td width="30" align="center"><a href="#"><img src="images/search_button.jpg" width="28" height="35" border="0" /></a></td>
    <td>&nbsp;</td>
    <td align="right" style="padding-right:10px;"><a href="servlet/UserServlet?action=cancle"><img src="images/login_out_button.gif" /></a></td>
  </form>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr valign="top">
    <td width="20">&nbsp;</td>
    <td width="200"><table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background:url(images/left_bg.jpg) left top repeat-y; padding:10px 20px;"><table width="160" border="0" cellspacing="0" cellpadding="0" id="left_navigation">
      <tr>
        <td width="30"><img src="images/left_ico02.gif" width="25" height="25" border="0" /></td>
        <td width="130"><a href="servlet/AdressBookServlet?action=getAlladress" class="a_14c_black">编写信息</a></td>
      </tr>
      <tr>
        <td><img src="images/left_ico03.gif" width="29" height="26" border="0" /></td>
        <td><a href="servlet/MessageManageServlet?status_flag=1" class="a_14c_black">发件箱</a></td>
      </tr>
      <tr>
        <td><img src="images/left_ico04.gif" width="31" height="27" border="0" /></td>
        <td><a href="servlet/MessageManageServlet?status_flag=2" class="a_14c_black">草稿箱</a></td>
      </tr>
      <tr>
        <td><img src="images/left_ico05.gif" width="24" height="28" border="0" /></td>
        <td><a href="servlet/MessageManageServlet?status_flag=3" class="a_14c_black">回收站</a></td>
      </tr>
      <tr>
        <td><img src="images/left_ico06.gif" width="29" height="28" border="0" /></td>
        <td><a href="servlet/BookGroupServlet?action=showgroup" class="a_14c_black">通讯录</a></td>
      </tr>
      <tr>
        <td valign="top" style="border:0px;"><img src="images/left_ico07.gif" width="28" height="27" border="0" /></td>
        <td class="text_14c_black" style="border:0px;">个人信息<br />
            <span class="text_14_gray1">·<a href="servlet/AreaServlet" class="a_14_gray1">修改个人资料</a><br />
              ·<a href="revised_password.jsp" class="a_14_gray1">修改密码</a></span> </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><img src="images/left_bottom.jpg" width="200" height="25" border="0" /></td>
  </tr>
</table>
</td>
<td style="width:10px;"></td>
    <td width="760" align="center" style="padding-top:20px;">
	
	<table width="455" border="0" cellpadding="0" cellspacing="0">
	<tr><td><img src="images/user_body_top.gif" width="455" height="5" border="0" /></td></tr>
	<tr><td style="background:url(images/user_body_bg.gif) left top repeat-y;" align="center" valign="top">
	<div style="text-align:left; padding:10px;" class="text_16c_black">-添加通讯录-</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="4">
	<form action="servlet/AdressBookServlet?action=addaddressbook" method="post" id="addbookadress">

  		<tr>
    <td width="90" align="right" valign="top" class="text_14c_gray1">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
    <td width="349" align="left" class="text_14_gray1"><input type="text" name="name" style="width:150px; border:1pxp #CCCCCC solid; " /></td>
  </tr>
    <tr>
    <td width="90" align="right" valign="top" class="text_14c_gray1">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
    <td width="349" align="left" class="text_14_gray1"><input type="text" name="mobile" style="width:150px; border:1pxp #CCCCCC solid; " /></td>
  </tr>
  <tr>
    <td align="right" valign="top" class="text_14c_gray1">所属分组：</td>
    <td align="left" class="text_14_gray1">
    <select style="width:100px;" name="groupid">
    								<%
			ArrayList<BookGroup> grouplist =(ArrayList<BookGroup>) session.getAttribute("grouplist");
			
			for(int i = 0; i<grouplist.size();i++){
				
				BookGroup bookgroup = grouplist.get(i);
			%>
			
	
		<option value="<%=bookgroup.getGid() %>"><%=bookgroup.getTitle() %></option>
		<%} %>
	</select>&nbsp;<span class="text_14c_blue1">[<a href="addgroup.jsp" class="a_14c_blue1">添加分组</a>]</span>
	
	</td>
  </tr>
   <tr>
    <td width="90" align="right" valign="top" class="text_14c_gray1">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
    <td width="349" align="left" class="text_14_gray1"><textarea style="width:260px; height:100px;"></textarea></td>
  </tr>
  <tr>
    <td align="right" valign="top" class="text_14c_black">&nbsp;</td>
    <td align="left"><button style="width:75px; height:25px; border:0px; background:none; cursor:hand;" onclick=""><img src="images/add_button.gif" /></button></td>
  </tr>
  </form>
</table>
</td></tr>
<tr><td><img src="images/user_body_bottom.gif" width="455" height="10" border="0" /></td></tr>

	</table>
	
	
	</td>
    <td>&nbsp;</td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="border-top:4px #CCCCCC solid; background:#F5F5F5; margin-top:20px;">
  <tr>
    <td style="padding-left:20px;" width="235" height="100" valign="middle"><img src="images/copyright_ico.gif" width="235" height="35" border="0" /></td>
    <td width="1" style="padding:0px 5px;"><img src="images/copyright_line.gif" width="1" height="90" /></td>
    <td class="text_14_gray1" style="line-height:20px;">版权文字<br />
联系信息联系信息联系信息联系信息<br />
联系信息联系信息联系信息 </td>
  </tr>
</table>

  </body>
</html>

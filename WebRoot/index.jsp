<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SMS―用户首页</title>
<link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="300"><img src="png/ss.png" width="300" height="100" border="0" /></td>
    <td width="100%" style="background:url(png/31.gif) left top repeat-x;">&nbsp;</td>
    <td width="477"><img src="png/5_1.jpeg" width="477" height="100" border="0" /></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(images/top_tab_bg.jpg) left top repeat-x;">
  <tr>
  <form >
    <td width="20">&nbsp;</td>
    <td width="400" align="left"></td>
    <td width="80"  align="right" class="text_12c_black">信息搜索：</td>
    <td width="200" align="left"><input type="text" style="width:190px; margin-top: -5px; border:1px #CCCCCC solid; background:#F5F5F5;" /></td>
    <td width="30" align="center"><a href="#"><i class="glyphicon glyphicon-search" style="text-align: left;margin-top: -7px;"></i></a></td>
    <td>&nbsp;</td>
    <td align="right" style="padding-right:10px;"><a href="servlet/UserServlet?action=cancle"><img src="images/login_out_button.gif" /></a></td>
  </form>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="20" valign="top">&nbsp;</td>
    <td width="200"><table width="200" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="background:url() left top repeat-y; padding:10px 20px;"><table width="160" border="0" cellspacing="0" cellpadding="0" id="left_navigation">
      <tr>
        <td width="30" class="glyphicon glyphicon-envelope" ></td>
        <td width="130"><a href="servlet/AdressBookServlet?action=getAlladress" class="a_14c_black">编写信息</a></td>
      </tr>
      <tr>
        <td class="glyphicon glyphicon-send"></td>
        <td><a href="servlet/MessageManageServlet?status_flag=1" class="a_14c_black">发件箱</a></td>
      </tr>
      <tr>
        <td class="glyphicon glyphicon-duplicate"></td>
        <td><a href="servlet/MessageManageServlet?status_flag=2" class="a_14c_black">草稿箱</a></td>
      </tr>
      <tr>
        <td class="glyphicon glyphicon-trash"></td>
        <td><a href="servlet/MessageManageServlet?status_flag=3" class="a_14c_black">回收站</a></td>
      </tr>
      <tr>
        <td class="glyphicon glyphicon-book"></td>
        <td><a href="servlet/BookGroupServlet?action=showgroup" class="a_14c_black">通讯录</a></td>
      </tr>
      <tr>
        <td valign="top" style="border:0px;" class="glyphicon glyphicon-user"></td>
        <td class="text_14c_black" style="border:0px;">个人信息<br />
            <span class="text_14_gray1">・<a href="servlet/AreaServlet" class="a_14_gray1">修改个人资料</a><br />
              ・<a href="revised_password.jsp" class="a_14_gray1">修改密码</a></span> </td>
      </tr>
    </table></td>
  </tr>

</table>
</td>
<td style="width:10px;"></td>
    <td width="760" align="center" valign="top" style="padding-top:20px;"><table width="405" border="0" cellspacing="0" cellpadding="0" style="margin-top:20px;">
  <tr>
    <td><img src="images/user_index_tab_top.gif" width="405" height="20" border="0" /></td>
  </tr>
  <tr>
    <td style="background:url(images/user_index_tab_bg.gif) left top repeat-y; text-align:left; padding-left:20px;"><img src="images/user_index_tab_ico.jpg" width="257" height="106" border="0" /></td>
  </tr>
    <tr>
    <td style="background:url(images/user_index_tab_bg.gif) left top repeat-y; text-align:right; padding-right:20px;" class="text_14c_blue1">・<a href="outbox.jsp" class="a_14c_blue1">进入发件箱</a>&nbsp;&nbsp;・<a href="send_message.jsp" class="a_14c_blue1">编写新信息</a></td>
  </tr>
  <tr>
    <td><img src="images/user_index_tab_bottom.gif" width="405" height="20" border="0" /></td>
  </tr>
</table>
</td>
<td>&nbsp;

</td>
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

<script src="lib/bootstrap/js/bootstrap.js"></script>

</html>

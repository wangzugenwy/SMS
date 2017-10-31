<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="com.model.BookGroup" %>
<%@page import="com.model.AddressBook" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>SMS―通讯录</title>
<link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
function deleteadressbook() {
	var targetForm=document.getElementById("deleteadress"); 
	targetForm.action = "servlet/AdressBookServlet?action=deleteadress";
	//动态修改目标表单的action属性 
	targetForm.submit();
}
function deleteGroup() {
	var targetForm=document.getElementById("deleteadress"); 
	targetForm.action = "servlet/AdressBookServlet?action=deleteGroup";
	//动态修改目标表单的action属性 
	targetForm.submit();
}
function addadressbook(){
	windows.location.href="servlet/AddServlet";
}

</script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="300"><img src="png/ss.png" width="300" height="100"
				border="0" /></td>
			<td width="100%"
				style="background:url(png/31.gif) left top repeat-x;">&nbsp;</td>
			<td width="477"><img src="png/5_1.jpeg" width="477" height="100"
				border="0" /></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="background:url(images/top_tab_bg.jpg) left top repeat-x;">
		<tr>
			<form>
				<td width="20">&nbsp;</td>
				<td width="400" align="left"></td>
				<td width="80" align="right" class="text_12c_black">信息搜索：</td>
				<td width="200" align="left"><input type="text"
					style="width:190px; margin-top: -5px; border:1px #CCCCCC solid; background:#F5F5F5;" /></td>
				<td width="30" align="center"><a href="#"><i
						class="glyphicon glyphicon-search"
						style="text-align: left;margin-top: -7px;"></i></a></td>
				<td>&nbsp;</td>
				<td align="right" style="padding-right:10px;"><a href="servlet/UserServlet?action=cancle"><img
						src="images/login_out_button.gif" /></a></td>
			</form>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20" valign="top">&nbsp;</td>
			<td width="200"><table width="200" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td style="background:url() left top repeat-y; padding:10px 20px;"><table
								width="160" border="0" cellspacing="0" cellpadding="0"
								id="left_navigation">
								<tr>
									<td width="30" class="glyphicon glyphicon-envelope"></td>
									<td width="130"><a href="servlet/AdressBookServlet?action=getAlladress"
										class="a_14c_black">编写信息</a></td>
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
									<td valign="top" style="border:0px;"
										class="glyphicon glyphicon-user"></td>
									<td class="text_14c_black" style="border:0px;">个人信息<br />
										<span class="text_14_gray1">・<a
											href="servlet/AreaServlet" class="a_14_gray1">修改个人资料</a><br />
											・<a href="revised_password.jsp" class="a_14_gray1">修改密码</a></span>
									</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
			<td style="width:10px;"></td>
			<td width="760" align="center" style="padding-top:20px;"><table
					width="740" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="470" align="center" valign="top">
						
						
						
		<form action="" method="post" id="deleteadress">
								<table width="470" border="0" cellspacing="0" cellpadding="0"
									id="address_list" style=" border-bottom:4px #7ECAFE solid;">
									<tr
										style="background:url(images/address_book_top_bg.jpg) left top repeat-x;">

										<td width="30" align="center" valign="middle"
											style="border:1px #CCCCCC solid; padding:0px; height:27px;"><input
											type="checkbox" name="checkbox" value="checkbox" /></td>
										<td width="195" align="center" valign="middle"
											class="text_14c_black"
											style="border:1px #CCCCCC solid; border-left:0px; padding:0px; height:27px;">姓名</td>
										<td width="245" align="center" valign="middle"
											class="text_14c_black"
											style="border:1px #CCCCCC solid; border-left:0px; padding:0px; height:27px;">电话号码</td>

									</tr>
									
									    <%
  ArrayList<AddressBook> addressooklist = (ArrayList<AddressBook>)session.getAttribute("addressooklist");
  for(int i = 0;i<addressooklist.size();i++){
	  AddressBook addressbook = addressooklist.get(i);
  %>
  <tr>
    <td align="center" class="text_14_gray1">
     <input type="checkbox" name="abid" value="<%=addressbook.getAbid() %>" />
    </td>
    <td align="center" class="text_14_gray1"><a href="#" class="a_14_gray1"><%=addressbook.getName() %></a></td>
    <td align="center" class="text_14_blue1"><%=addressbook.getMobile() %></td>
    
  </tr>
    <%} %>
									
									
								</table>

								<table width="397" border="0" cellspacing="0" cellpadding="0"
									style="margin-top:5px;">
									<tr>
										<td width="240" align="left" class="text_14c_black"><a
											href="#" class="a_14c_black">首页</a>&nbsp;&nbsp;<a href="#"
											class="a_14c_black">上一页</a>&nbsp;&nbsp;<a href="#"
											class="a_14c_black">下一页</a>&nbsp;&nbsp;<a href="#"
											class="a_14c_black">末页</a></td>
										<td width="69" align="left" class="text_14_black">跳转到第</td>
										<td width="54" align="left" class="text_14_black"><select
											name="select" style="width:50px;">
												<option>1</option>
												<option>2</option>
										</select></td>
										<td width="34" align="center" class="text_14_black">页</td>
									</tr>
								</table>
						

						</td>
						<td width="10">&nbsp;</td>
						<td width="260" valign="top"><table width="260" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td><img src="images/address_book_group_top.jpg"
										width="260" height="35" border="0" /></td>
								</tr>
								<tr>
									<td
										style="background:url(images/address_book_group_bg.gif) left top repeat-y; padding:5px; text-align:left; line-height:25px;"
										class="text_14c_gray1">
										<input type="checkbox" name="gid" value="0"/>&gt;&nbsp;<a href="servlet/BookGroupServlet?action=showgroup"
										class="a_14c_gray1">所有联系人</a><br />
										<%
			ArrayList<BookGroup> grouplist =(ArrayList<BookGroup>) session.getAttribute("grouplist");
			
			for(int i = 0; i<grouplist.size();i++){
				
				BookGroup bookgroup = grouplist.get(i);
			%>
			
				<input type="checkbox" name="gid" value="<%=bookgroup.getGid() %>"/>
				&gt;&nbsp;<a href="servlet/ShowBookOtherGroupServlet?gid=<%=bookgroup.getGid() %>" class="a_14c_gray1"><%=bookgroup.getTitle() %></a><br />
			
			<%} %>
										
										
									</td>
								</tr>

								<tr>
									<td
										style="background:url(images/address_book_group_bg.gif) left top repeat-y; padding:5px; text-align:left">
										<div style="width:250px; text-align:left;"
											class="text_14c_blue1">
											[<a href="addgroup.jsp" class="a_14c_blue1">添加分组</a>]&nbsp;&nbsp;[<a
												href="#" class="a_14c_blue1"><button class="a_14c_blue1" onclick="deleteGroup()">删除分组</button></a>]
										</div>

									</td>
								</tr>
								<tr>
									<td><img src="images/address_book_group_bottom.gif"
										width="260" height="10" border="0" /></td>
								</tr>
							</table>
							<div style="width:260px; padding:5px 0px; text-align:left;">
							
							
							<button style="width:100px; height:25px; background:none; border:0px; cursor:hand;" onclick="deleteadressbook()"><img src="images/address_book_button02.gif" width="100" height="25" border="0" /></button>&nbsp;&nbsp;
							<a href="servlet/AddServlet">添加联系人</a>
							</div></td>
					</tr>
				</table></td>
			<td>&nbsp;</td>
		</tr>
	</table>
	</form>
	
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="border-top:4px #CCCCCC solid; background:#F5F5F5; margin-top:20px;">
		<tr>
			<td style="padding-left:20px;" width="235" height="100"
				valign="middle"><img src="images/copyright_ico.gif" width="235"
				height="35" border="0" /></td>
			<td width="1" style="padding:0px 5px;"><img
				src="images/copyright_line.gif" width="1" height="90" /></td>
			<td class="text_14_gray1" style="line-height:20px;">版权文字<br />
				联系信息联系信息联系信息联系信息<br /> 联系信息联系信息联系信息
			</td>
		</tr>
	</table>

	<script src="lib/bootstrap/js/bootstrap.js"></script>

</body>
</html>

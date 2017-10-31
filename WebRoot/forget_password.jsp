<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SMS</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	body{
		background:url(images/r.jpg) no-repeat right top;
		

	}
	.two{
		background:url(images/j4.png) no-repeat;
		/*border: 1px solid #ccc;*/
		width: 370px;
		height: 250px;
		margin: 100px auto;
		padding-top: 60px;
		padding-left: 25px;
		z-index: 11px;
	}
	a{
        text-decoration: none;
        color: black;

    }
	a:visited{
        color: blue;
    }
    a:hover{
        color: red;
    }
</style>
</head>
<body>
	<div class="two" >
		
		<h3>-找回密码-</h3>
		<form  action ="servlet/UserServlet?action=findpassword" method = "post" class="three">
			<p>密码问题：<select name="question" >
								<option value="你童年最好的朋友">你童年最好的朋友</option>
								<option value="你父亲的名字">你父亲的名字</option>
								<option value="你最喜欢的人">你最喜欢的人</option>
								<option value="你父亲的生日">你母亲的生日</option>
								<option value="你父亲的生日">你父亲的生日</option>
								<option value="你的生日">你的生日</option>
								<option value="你最好的闺蜜">你最好的闺蜜</option>
							</select></p>
			密码答案：<input type="text" name="answer" /><br><br>
			<input type="submit" value="提交" width="75" height="25" border="0"  />
		</form>
	</div>
	
</body>
</html>

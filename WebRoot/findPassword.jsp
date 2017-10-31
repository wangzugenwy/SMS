<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SMS―找回密码</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
  <!-- <script type="text/javascript" src="js/jquery-2.1.4.min.js" ></script>  
 <script type="text/javascript">  
     function  sub(){  
       $.ajax({  
       type:"GET",  
       url:"servlet/UserServlet?action=findpassword",  
       data:{username:$("#name").val()},  
       statusCode: {404: function() {  
            alert("你的用户名是："+'${userid}'+"密码是："+"${userid}"); }  
         },      
       success:function(data,textStatus){  
       $("#sp").html(data);  
       }  
       });  
     }  
    </script>  -->
<style>
<


.erro{
	background:#FFD2D2;
	color:#FFFFFF;
	margin:auto;
}
#erro{
	width:190px;
	height:auto;
	border:1px #7ECAFE solid;
	background:#D2EDFF;
	padding:10px;
	font-size:14px;
	color:#990000;
	line-height:20px;
	margin:auto;
	z-index:102;
	top:100px;
	position:relative;
	filter:alpha(opacity=100);
-moz-opacity:0.5;
opacity: 0.5;

}

.text_16c_black{
	font-weight:bold;
	font-size:16px;
	color:#000000;
	line-height:17px;
}

#div_content{
	width:100%;
	text-align:center;
	
 position:absolute; left:0;
right:0; top:0; bottom:0; 
height:100%;


}

-->
</style>
</head>
<body style="background:url(images/body_bg.jpg) repeat-x #80CCFF; height:100%;">

<table width="450" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td><img src="images/register_tab_top.jpg" width="450" height="150" border="0" /></td>
  </tr>
  <tr>
    <form action="servlet/UserServlet?action=findpassword" method="post">
      <td style="background:url(images/register_tab_bg.jpg) left top repeat-y; padding:0px 20px; padding-top:20px;">
	  <div style="width:100%; text-align:left; padding:10px 0px;" class="text_16c_black">-找回密码-</div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="5" style="margin:10px 0px;">
  <tr>
    <td width="89" align="right" class="text_14c_gray1">账号：</td>
    
    
    <td width="301" align="left" class="text_14_gray1">${userid }</td>
  </tr>
  <tr>
    <td align="right" class="text_14c_gray1">密码：</td>
    <td align="left">${password }</td>
  </tr>
    <tr>
    <td width="89" align="right" class="text_14c_gray1"></td>
    <!-- <td width="301" align="left" class="text_14_gray1"><input type="submit" src="images/f_password_button.gif" width="75" height="25" border="0"  /></td> --> 
  	<td width="301" align="left" class="text_14_gray1"><a href="login.jsp">跳回登录页面</a></td>
  </tr>
</table>
	  </td>
    </form>
  </tr>
  <tr>
    <td><img src="images/register_tab_bottom.jpg" width="450" height="80" border="0" /></td>
  </tr>  
</table>





<center>
你的用户名是：${userid }<br>
你的密码是：${password }
</center>

</body>
</html> --%>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>SMS-找回密码</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        div{
          background:url(images/c.jpg) no-repeat;
          margin: 100px auto;
          width: 340px;
          height: 222px;
          margin-left: 30%;
         /* border: 1px solid black;*/
          padding-left: 100px;
          padding-top: 30px;
          z-index: 20;
        }
        body{
        	background:url(images/2.png) repeat-y;
        	z-index: 9;
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
<body><form action="servlet/UserServlet?action=findpassword" method="post">
      <div>
        <p>用户名：${userid }</p>
        <p>密码：${password }</p>
        <a href="login.jsp">跳回登录页面</a>
      </div>
	  </form>
      
</body>
</html>
    


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
</head>
<body style="background:url(images/4.jpg) repeat-x #80CCFF;">
  <div class="head">
         <h1>SMS</h1>
         <p>short message send</p>
  </div>
   <div class="one">
          <form action="servlet/UserServlet?action=login" method="post">
          <div class="top"><p>账号密码登录</p></div>
          <div class="container">
           <div class="form-group">
               <input type="text" name="userid" class="form-control" " placeholder="&nbsp;用户名" >
           </div>
           <div class="form-group">
            <div class="password"><input type="password" name="password" class="form-control" placeholder="&nbsp;密码" ></div>
            </div>
            <div class="button"><input type="submit" class="btn btn-default" value="登&nbsp;&nbsp;录"/></div>
              </div>
          </form>
             <div class="zhuce"><a href="servlet/AreaServlet">新用户注册</a>&nbsp;|&nbsp;<a href="forget_password.jsp">忘记密码</a></div>

</div>

</body>
</html>
    <!-- 引入jQuery,bootstrap
    <script src="lib/jQuery/jquery-3.2.1.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>-->

    <!-- Bootstrap 默认的CSS样式
    <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/MyBootstrap.css"> -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.model.Area"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>SMS</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style>
    .aa{
      padding-top: 10px;
      padding-bottom: 10px;
      padding-left: 12px;
    }
    .bb{
      padding-top: 10px;
      padding-bottom: 10px;
      padding-left: 12px;

    }
    .cc{
      padding-top: 8px;
      padding-bottom: 10px;
      padding-left: 12px;
    }
    .text_14_orange{
      padding-bottom: 12px;
    }
    .text_14_black{
      padding-bottom: 8px;
    }
    .dd{
      margin: 100px auto;
      /*background:url(images/ti4.jpg) no-repeat; */
       background-color: rgba(256, 256, 256,0.78);
    }
    body{
      background:url(images/ti7.png) no-repeat top right;
    }
</style>
</head>
<body>
<table width="470" border="1" class="dd">
  <tr>
    <form action="servlet/UserServlet?action=register" method="post">
      <td>

        <table  class="aa" width="450" border="0" style="border-bottom:1px #CCCCCC dashed;">
          <tr>
            <td width="80" align="right" class="text_14_black">用户名：</td>
            <td width="135" align="left"><input type="text" name="userid"  style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;"  /></td>
            <td width="80" align="right" class="text_14_black">真实姓名：</td>
            <td width="135" align="left"><input  type="text" name="real_name" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;"  />
            </td>
          </tr>

          <tr>
            <td align="right" class="text_14_black" >性&nbsp;&nbsp;&nbsp;别：</td>
            <td align="left" class="text_14_gray1"><input type="radio" name="sex" checked="checked" value="男" />
              男&nbsp;
              <input type="radio" name="sex" value="女" />
              女</td>
            <td align="right" class="text_14_black">手机号：</td>
            <td align="left"><input name="mobile" type="text" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /></td>
          </tr>
          <tr>
            <td align="right"  class="text_14_black">所在地区：</td>
           
           
            
            <td align="left"><select style="width:120px;" name="area_id" class="text_14_gray1">
             <%
					ArrayList<Area> arealist = (ArrayList<Area>) session.getAttribute("arealist");
					for (int i = 0; i < arealist.size(); i++) {
							Area area = arealist.get(i);
			%>
									
					<option value="<%=area.getId()%>"><%=area.getTitle() %></option>
			<%
					}
			%>
              </select></td>
            <td align="right" class="text_14_black">&nbsp;</td>
            <td align="left">&nbsp;</td>
          </tr>
        </table>

        <table class="bb" width="450" border="0" style="border-bottom:1px #CCCCCC dashed; margin-top:10px;">
          <tr>
            <td width="50" align="right" class="text_14_black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td width="135" align="left"><input name="password" type="password" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /></td>
            <td width="90" align="right" class="text_14_black">确认密码：</td>
            <td width="135" align="left"><input name="repassword" type="password" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /></td>
          </tr>
          <tr>
            <td align="right" class="text_14_black">密码问题：</td>
            <td align="left" class="text_14_gray1"><!-- <input name="question" type="text" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /> -->
            <select name="question" type="text" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /> 
								<option value="你童年最好的朋友">你童年最好的朋友</option>
								<option value="你父亲的名字">你父亲的名字</option>
								<option value="你最喜欢的人">你最喜欢的人</option>
								<option value="你父亲的生日">你父亲的生日</option>
								<option value="你父亲的生日">你父亲的生日</option>
								<option value="你的生日">你的生日</option>
								<option value="你最好的闺蜜">你最好的闺蜜</option>
			</select>
			</td>
            <td align="right" class="text_14_black">密码答案：</td>
            <td align="left"><input name="answer" type="text" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" /></td>
          </tr>
          <tr>
            <td align="right" class="text_14_black">邮&nbsp;&nbsp;箱：</td>
            <td align="left"><span class="text_14_gray1">
              <input name="email" type="text" style="width:117px; background:#F5F5F5; color:#666666; border:1px #CCCCCC solid;" />
              </span></td>
            <td align="right" class="text_14_black">&nbsp;</td>
            <td align="left">&nbsp;</td>
          </tr>
        </table>

        <table class="cc" width="450" border="0" style="margin-top:10px;">
          <tr>
            <td class="text_14_orange" align="left">注：以上均为必填项，请认真填写！</td>
          </tr>
          <tr>
            <td align="center">
              <input type="submit"/>
                &nbsp;&nbsp;&nbsp;&nbsp;
              <input type="reset"/>
            </td>
          </tr>
        </table>

      </td>
    </form>

  </tr>

</table>

</body>
</html>

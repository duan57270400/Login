<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆系统界面</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
<style type="text/css">
#alert {
	color: #FF4D4D;
}
</style>
  </head>
  
   <body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
  <script>
function myFunction()
{
	account=document.form1.account.value;
	password=document.form1.password.value;
	var strExp=/^[A-Za-z0-9]+$/;
	
	if(account=="")
	{
		alert("账号不能为空");
		return false;
		
	}
	else if(account.length<5||account.length>15)
	{
		alert("用户名长度小于5或大于15");
		return false;
	}
	else if(/[@\/'\\"#$%&\^*]/.test(account))
	{
		    alert("有非法字符");
		    return false;
	}
	else if(password=="")
	{
		alert("密码不能为空");
		return false;
	}
	else if(password.length<5||password.length>15)
	{
		alert("密码长度小于5或大于15");
		return false;
	}
	else if(!(strExp.test(password)))
	{
		alert("密码只能为数字或字母" );
		return false;
	}
	else
	return true;


}
</script>

   <% session.removeAttribute("post_id");
      session.removeAttribute("post_id2");
   
   %>

  <div class="logintop">    
    <span>请输入您的用户名和密码:</span>      
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
    
    <div class="loginbox loginbox2">
    
   <form action= "<%=basePath%>/Login_login.action?myOrder=tologin" name="form1"  id="form1" method="post" onsubmit="return myFunction()">
    <ul>
    <div class="red" id="alert">	${msg }<br></div>
    <li><input name="account" type="text" class="loginuser"  /></li>
    <li><input name="password" type="password" class="loginpwd"/></li>
    
    <li>
    <input type="submit" class="loginbtn" value="登录" ><label><a href="<%=basePath%>/Check.action?order_operate=reg_account" target="_blank">注册账号</a></label>
    </li>
    </ul>
    
    
    </div>
    
    </div>
  </form>  
  
  </body>
</html>

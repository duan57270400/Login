<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.test.vo.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册账号界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	
  </head>
  
  <body>
<script type="text/javascript">  
 
  function reloadcode(obj,base){  
  var rand=new Date().getTime(); //这里用当前时间作为参数加到url中，是为了使URL发生变化，这样验证码才会动态加载，  
            //只是一个干扰作用，无确实意义，但却又非常巧妙，呵呵  
  obj.src=base+"SecurityCodeImage.action?abc="+rand; //其实服务器端是没有abc的字段的。  
  }  

</script>  
  
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">注册</a></li>
    </ul>
   </div>

  <script>
function myFunction()
{
	account=document.form1.account.value;
	password=document.form1.password.value;
	password_2=document.form1.password_2.value;
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
	else if(password!=password_2)
	{
		alert("输入的两次密码不一致" );
		return false;
	}
	
	else
	return true;


}
</script>
<form action= "<%=basePath%>/Login_reg.action?myOrder=toreg" name="form1"  id="form1" method="post" onsubmit="return myFunction()">
    <div class="formbody">
    
    <div class="formtitle"><span>注册信息</span></div>
    <ul class="forminfo">
    <li><label>输入账号</label><input type="text"  name="account" class="dfinput" /></li>
    <li><label>输入密码</label><input type="password" name="password" class="dfinput" /></li>
    <li><label>确认密码</label><input type="password" name="password_2" class="dfinput" /></li>
    <li><label>选择岗位</label>
    <select name="post">
    <s:iterator value="#session.post" var="post">
       <option value="<s:property value="#post.postName"/>" ><s:property value="#post.postName"/> </option>
     </s:iterator>
    </select>
    </li>
    <li><label>选择部门</label>
     <select name="dept" >
     <s:iterator value="#session.dept" var="dept">
 
<option value="<s:property value="#dept.deptName"/>"> <s:property value="#dept.deptName"/> </option>
</s:iterator>
</select>  
    </li>
    <li><label>姓名</label><input type="text"  name="username" class="dfinput" /></li>
    <li><label>性别</label><input type="text"  name="gender" class="dfinput" /></li>
    <li><label>年龄</label><input type="text"  name="age" class="dfinput" /></li>
    <li><label>职称</label><input type="text"  name="office" class="dfinput" /></li>
    <li><label>联系方式</label><input type="text"  name="telephone" class="dfinput" /></li>
     <li><label>验证码</label><input name="verify" id="verify" type="text" />
    <img name="verifyImg" id="verifyImg" src="<%=basePath %>/SecurityCodeImage.action" onclick="reloadcode(this,'<%=basePath%>')" alt="看不清，换一张"/></li>
<br><li><label>&nbsp;</label><input type="submit" class="btn" value="确认提交"/></li>
    </ul>
    
    </div>
 </form>
 
  </body>
</html>

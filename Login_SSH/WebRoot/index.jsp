<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统界面</title>
</head>

<body>
<p>&nbsp;请选择对应的操作:</p>
<form action="<%=basePath%>/Check.action" target="_blank"  method="post">
<input type="radio" name="order_operate" value="reg_account" >新增用户 <br>
<input type="radio" name="order_operate" value="user_login" >用户登录 <br>
<input type="submit" value="确定操作">

</form>




</body>
</html>
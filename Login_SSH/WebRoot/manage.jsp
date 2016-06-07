<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 登陆成功,请选择操作:<br><br>
  <body>
  <form action="<%=basePath%>/Check.action"  method="post" >
  <select name="order_operate" >
  <option value="users_manager">用户管理</option>
  <option value="post_manage">岗位管理</option>
  <option value="dept_manage">部门管理</option>
  </select>
  
 <br><input type ="submit" value="确定">
  </form>
  </body>
</html>

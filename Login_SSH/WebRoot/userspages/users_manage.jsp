<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <script type="text/javascript" >
 function onreturn()
    {
	
	history.back();
	}
</script>
<p>&nbsp;<a href="userspages/add_user.jsp" target="_blank" >新增用户</a></p>
<p>&nbsp;<a href="" target="_blank" >删除用户</a></p>
<p>&nbsp;<a href="" target="_blank" >更新用户</a></p>
<p>&nbsp;<a href="" target="_blank" >查询用户</a></p><br>
   <input type="button" onclick="onreturn()"  value="返回"/>
  </body>
</html>

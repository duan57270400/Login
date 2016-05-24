<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>岗位管理页面</title>
    
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
请选择需要的岗位操作:<br>
<form action="<%=basePath%>/Post_checkOperate.action" method="post">
  <select name="order" >
  <option value="add_post">增加岗位</option>
  <option value="del_post">删除岗位</option>
  <option value="up_post">更新岗位</option>
  <option value="look_post">查看岗位</option>
  </select>
  
 <br><input type ="submit" value="确定">
 <input type="button" onclick="onreturn()"  value="返回"/>

</form>
  </body>
</html>

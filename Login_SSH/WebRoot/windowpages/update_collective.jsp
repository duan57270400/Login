<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.util.*,java.sql.*" errorPage=""%>

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
    
    <title>集体岗页面</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">局党组操作</a></li>
    <li><a href="#">处理意见</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>填写页面</span></div>
     <form action="<%=basePath%>/Tax_updateComment.action" method="post">
    <ul class="forminfo">
    <li><label>处理意见</label><input type="textarea" name="comment" class="textinput" /></li>
    <li><input type="hidden"  name="post_id" value="<s:property value="#session.post_id"/>" /></li>
    <li><input type="hidden"  name="user_num" value="<s:property value="#session.user_num"/>" /></li>

    <li><label>&nbsp;</label><input  type="submit" class="btn" value="提交"/></li>
    </ul>
    </form>
    </div>
    

  </body>
</html>

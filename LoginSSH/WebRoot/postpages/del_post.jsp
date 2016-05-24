<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除岗位界面</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">岗位</a></li>
    <li><a href="#">删除岗位</a></li>
    </ul>
    </div>
    
       
    <div class="formbody">
    
    <div class="formtitle"><span>输入删除岗位编号</span></div>
     <form action="<%=basePath%>/Post_delPost.action" method="post">
    <ul class="forminfo">
    <li><label>岗位编号</label><input type="text" name="postTable.postId" value="" class="dfinput" /></li>
    <li><label>&nbsp;</label><input  type="submit" class="btn" value="提交"/></li>
    </ul>
    </form>
    </div>
    
  
  </body>
</html>

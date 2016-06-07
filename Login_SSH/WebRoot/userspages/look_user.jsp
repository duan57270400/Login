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
    
    <title>查看用户页面</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
<div class="place">
    <span>用户管理：</span>
    <ul class="placeul">
    <li><a href="">查看用户</a></li>
    <li><a href="">用户信息</a></li>
    </ul>
    </div>
      <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><a href=""><span><img src="images/t01.png" /></span>添加</a></li>

        </ul>
            
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>  
    </div>
    
    
     <table class="tablelist">
    	<thead>
    	<tr>
		<th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>姓名<i class="sort"><img src="images/px.gif" /></i></th>
        <th>性别</th>
        <th>年龄</th>
        <th>联系方式</th>
        <th>职称</th>
        <th>所属岗位</th>
        <th>所属部门</th>
        <th>操作</th>
    
        </tr>
        </thead>
        <tbody>
        <s:iterator value="pageUser.list">
        <tr>
		<td><input name="" type="checkbox" value="" /></td>
        <td><s:property value="username"/></td>
        <td><s:property value="gender"/></td>
        <td><s:property value="age"/></td>
        <td><s:property value="telephone"/></td>
        <td><s:property value="office"/></td>
        <td><s:property value="post"/></td>
        <td><s:property value="dept"/></td>
        
     
    
        <td><a href="" class="tablelink">修改</a><a href="" class="tablelink"> 删除</a></td>
        </tr> 
 
      </s:iterator>
        </tbody>
    </table><br>
    

     <s:iterator value="pageUser">
     <div class="pagin">
    	<div class="message">用户表共有<i class="blue"><s:property value="allRow"/></i>条记录,当前第<s:property value="currentPage"/>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="<%=basePath%>/Login_lookUsers.action?pageNum=<s:property value="%{currentPage-1}"/>"><span class="pagepre"></span></a></li>
         <s:iterator value="pageUser.detail" id="detail_num">
        <li class="paginItem"> <a href="<%=basePath%>/Login_lookUsers.action?pageNum=<s:property value="detail_num"/>" ><s:property value="detail_num"/></a></li>
         </s:iterator> 
        <li class="paginItem"><a href="<%=basePath%>/Login_lookUsers.action?pageNum=<s:property value="%{currentPage+1}"/>"><span class="pagenxt"></span></a></li>   
        </ul>
    </div>
    </s:iterator>

   
  </body>
</html>

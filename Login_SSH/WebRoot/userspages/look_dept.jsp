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
    
    <title>查看部门页面</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
<div class="place">
    <span>部门管理：</span>
    <ul class="placeul">
    <li><a href="">查看部门</a></li>
    <li><a href="">部门信息</a></li>
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
        <th>部门编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>部门名字</th>
        <th>部门电话</th> 
        <th>操作</th>
    
        </tr>
        </thead>
        <tbody>
        <s:iterator value="pageDept.list">
        <tr>
		<td><input name="" type="checkbox" value="" /></td>
        <td><s:property value="deptId"/></td>
        <td><s:property value="deptName"/></td>
        <td><s:property value="deptTel"/></td>
   
    
        <td><a href="" class="tablelink">修改</a><a href="" class="tablelink"> 删除</a></td>
        </tr> 
 
      </s:iterator>
        </tbody>
    </table><br>
    

     <s:iterator value="pageDept">
     <div class="pagin">
    	<div class="message">部门表共有<i class="blue"><s:property value="allRow"/></i>条记录,当前第<s:property value="currentPage"/>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="<%=basePath%>/Login_lookDept.action?pageNum=<s:property value="%{currentPage-1}"/>"><span class="pagepre"></span></a></li>
         <s:iterator value="pageDept.detail" id="detail_num">
        <li class="paginItem"> <a href="<%=basePath%>/Login_lookDept.action?pageNum=<s:property value="detail_num"/>" ><s:property value="detail_num"/></a></li>
         </s:iterator> 
        <li class="paginItem"><a href="<%=basePath%>/Login_lookDept.action?pageNum=<s:property value="%{currentPage+1}"/>"><span class="pagenxt"></span></a></li>   
        </ul>
    </div>
    </s:iterator>

   
  </body>
</html>

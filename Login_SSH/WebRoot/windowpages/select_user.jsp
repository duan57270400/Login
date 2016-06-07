<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.test.vo.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>指派人员页面</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
<div class="place">
    <span>首页：</span>
    <ul class="placeul">
    <li><a href="">申报纳税</a></li>
    <li><a href="">指派人员</a></li>
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
    <form action="<%=basePath%>/Tax_selectNextUser.action" method="post">
     <table class="tablelist">
    	<thead>
    	<tr>
		<th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>下一岗位名称<i class="sort"><img src="images/px.gif" /></i></th>
        <th>选择下一业务人员的用户编号</th>
        </tr>
        </thead> 
        
        <tbody>  
        <tr>
		<td><input name="" type="checkbox" value="" /></td>
		<% 
		String first_basic_num = (String)session.getAttribute("first_basic_num");
		String nextPost_id = (String)session.getAttribute("nextPost_id");
		String nextPost_name = (String)session.getAttribute("nextPost_name"); 
		%>
		
        <td><%=nextPost_name %></td>
        <td>  
        <select name="next_user_num" >
        <%     
        List list_select = (List)session.getAttribute("list_select");
        for(int i =0;i<list_select.size();i++)
        {
        	UserPost up = (UserPost)list_select.get(i);
        %>
             <option value="<%=up.getUserNum()%>" ><%=up.getUserNum()%> </option>
          <% } %>
    
    </select>     
        </td>
        <td><input type="hidden"  name="first_basic_num" value="<%=first_basic_num %>" /></td>
        <td><input type="hidden"  name="nextPost_id" value="<%=nextPost_id %>" /></td>
        
        </tr>   
        </tbody>
    </table>
     <br><input  type="submit" class="btn" value="确认提交"/>
    </form>  


   
  </body>
</html>

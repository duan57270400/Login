<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.util.*,java.sql.*" errorPage=""%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.test.vo.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务人员选择处理业务</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
  </head>
  
  <body>
<% String post_id = (String)session.getAttribute("post_id2"); 
   String user_num = (String)session.getAttribute("user_num");

%>

 <div class="place">
    <span>首页：</span>
    <ul class="placeul">
    <li><a href="">业务员审核</a></li>
    <li><a href="">选择处理业务单号</a></li>
    </ul>
 </div>
    

 <div class="rightinfo"><div class="tools"></div>
   <form action="<%=basePath%>/Tax_businessBrowse.action?user_num=<%=user_num %>&post_id=<%=post_id %>" method="post"> 
    <table class="tablelist">
    	<thead>
    	<tr>
    	<th>选择处理业务</th>
        <th>业务信息编号</th>
        <th>业务状态</th>
        </tr>
        </thead>

     <% 
       
     List list_business = (List)session.getAttribute("list_business");
     String status = "";
        for(int i=0;i<list_business.size();i++)
        {
        	PostFlow pf = (PostFlow)list_business.get(i);
        	if("0".equals(pf.getStatus()))
        	{
        		status="未办理";
        	}
        	if("1".equals(pf.getStatus()))
        	{
        		status="已办理";
        	}
     %>
        <tbody>
        <tr>
        <td><input type="radio" name="basic_info_num" value="<%=pf.getBasicInfoNum()%>"></td>
        <td><%=pf.getBasicInfoNum()%></td>
        <td><%=status%></td>
        </tr> 
        </tbody>
        <%
			}
		%>
        
    </table>
       
    <br><input  type="submit" class="btn" value="查看"/>

    </form>
   </div>
  </body>
</html>

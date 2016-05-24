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
    
    <title>浏览业务信息页面</title>
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
  <% String post_id2 = (String)session.getAttribute("post_id2");  //进到这个页面的人员的岗位编号一定是"post_02"
     String user_num = (String)session.getAttribute("user_num");
     String basic_info_num = (String)session.getAttribute("basic_info_num");
  %>
<div class="place">
    <span>首页：</span>
    <ul class="placeul">
    <li><a href="">业务员审核</a></li>
    <li><a href="">审核业务</a></li>
    </ul>
 </div>
 <div class="rightinfo">
 <div class="tools"></div>
   <form action="<%=basePath%>/Tax_businessUpdate.action" method="post"> 
    <table class="tablelist">
    	<thead>
    	<tr>
    	<th>基本信息编号</th>
        <th>收入总额</th>
        <th>不征税收入</th>
        <th>免税收入</th>
        <th>应税收入额</th>
        </tr>
        </thead>
 
        <% 	
           List list_Browse = (List)session.getAttribute("list_Browse");
           TaxTable taxTable = (TaxTable)list_Browse.get(0);
        %>
        <tbody>
        <tr>
    
        <td><%=taxTable.getBasicInfoNum()%></td>
        <td><%=taxTable.getGrossIncome()%></td>
        <td><%=taxTable.getNonTaxableIncome()%></td>
        <td><%=taxTable.getExemptIncome()%></td>
        <td><%=taxTable.getTaxableIncome()%></td>  
        </tr> 
        </tbody>
      </div> 
    </table>  <!-- 一个Table -->
   
     <br><br><br>
     <div>
     <ul class="forminfo">
    <li><input type="hidden"  name="basic_info_num" value="<%=basic_info_num %>" /></li>
    <li><input type="hidden"  name="post_id2" value="<%=post_id2 %>" /></li>
    <li><input type="hidden"  name="user_num" value="<%=user_num %>" /></li>
    <li><label>税务应纳所得税</label><input type="text" name="taxAuthorityPay" class="dfinput" /></li>
    <li><label>审核意见</label><textarea name="reviewComments" cols="" rows="" class="textinput"></textarea></li>

    </ul>    
    </div>   

    </div> <!-- 从这开始 --> 
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
   //	String first_basic_num = (String)session.getAttribute("first_basic_num"); //知道X001
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
       
        <td><input type="hidden"  name="nextPost_id" value="<%=nextPost_id %>" /></td>
        
        </tr>   
        </tbody>
    </table>
     <br><input  type="submit" class="btn" value="确认提交"/>
    
    
    </form>
  </body>
</html>

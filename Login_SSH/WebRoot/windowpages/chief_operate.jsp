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
  <% 
   //  String user_num = (String)session.getAttribute("user_num");
   //  String basic_info_num = (String)session.getAttribute("basic_info_num");
  %>
<div class="place">
    <span>首页：</span>
    <ul class="placeul">
    <li><a href="">股长审核</a></li>
    <li><a href="">审核业务</a></li>
    </ul>
 </div>
 <div class="rightinfo">
 <div class="tools"></div>
   <form action="<%=basePath%>/Tax_ChiefReception.action" method="post"> 
    <table class="tablelist">
    	<thead>
    	<tr>
    	<th>基本信息编号</th>
        <th>收入总额</th>
        <th>不征税收入</th>
        <th>免税收入</th>
        <th>应税收入额</th>
        <th>税务所交税</th>
        <th>业务员意见</th>
        </tr>
        </thead>
 
        <tbody>
        <tr>
        <s:iterator value="#session.list_Browse">
    
        <td><s:property value="basicInfoNum"/></td>
        <td><s:property value="grossIncome"/></td>
        <td><s:property value="nonTaxableIncome"/></td>
        <td><s:property value="exemptIncome"/></td>
        <td><s:property value="taxableIncome"/></td>
        <td><s:property value="taxAuthorityPay"/></td>
        <td><s:property value="reviewComments"/></td>
        </s:iterator>
        </tr> 
        </tbody>
      </div> 
    </table>  <!-- 一个Table -->
   
     <br><br><br>
     <div>
     <ul class="forminfo">
    <li><input type="hidden"  name="post_id" value="<s:property value="#session.post_id"/>" /></li>
    <li><input type="hidden"  name="basic_info_num" value="<s:property value="#session.basic_info_num"/>" /></li>
    <li><label>股长审核意见</label><textarea name="Chief_comments" cols="" rows="" class="textinput"></textarea></li>

    </ul>    
    </div>   

    </div> <!-- 从这开始 --> 
    <table class="tablelist">
    	<thead>
    	<tr>
		<th><input name="" type="checkbox" value="" /></th>
        <th>下一岗位名称<i class="sort"><img src="images/px.gif" /></i></th>
        <th>选择下一业务人员的用户编号</th>
        </tr>
        </thead> 
        
        <tbody>  
        <tr>
         <s:if test="#session.collectiveFlag==0">  <!--JSP表格排版  -->
		<td><input name="" type="checkbox" value="" /></td>
		</s:if>


		 <s:if test="#session.collectiveFlag==0">
        <td><s:property value="#session.nextPost_name"/> </td>
        <td>
                   
        <select name="next_user_num" >
        <s:iterator value="#session.list_select" var="ss">    
             <option value="<s:property value="#ss.userNum"/>" ><s:property value="#ss.userNum"/> </option>   
        </s:iterator>
        </select>        
        
        </td>
        </s:if>
        <!-- 可以复用 -->
        <s:if test="#session.collectiveFlag==1">
        <s:iterator value="#session.CollectiveList">
        <tr>
        <td><input name="CollectiveUserNum" type="checkbox" value="<s:property value="userNum"/>" /></td>
        <td><s:property value="#session.nextPost_name"/></td>
        <td><s:property value="userNum"/></td>
        </tr> 
        </s:iterator>  
        
        <td><input type="hidden"  name="CollectivePostId" value="<s:property value="#session.CollectivePostId"/>" /></td>
        <td><input type="hidden"  name="user_num" value="<s:property value="#session.ChiefNum"/>" /></td>   
        </s:if>
         <!-- 结束 -->

         
        </tr>   
        </tbody>
    </table>
  
  
     <br><input  type="submit" class="btn" value="确认提交"/>
    
    
    </form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.test.vo.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>纳税接待窗口界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	
  </head>
  
  <body>

  
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">申报纳税</a></li>
    <li><a href="#">接待窗口界面</a></li>
    </ul>
   </div>

<% String post_id = (String)session.getAttribute("post_id"); 
   String user_num = (String)session.getAttribute("user_num");

%>


<form action= "<%=basePath%>/Tax_windowReception.action" method="post" ">
    <div class="formbody">
    
    <div class="formtitle"><span>应纳税信息</span></div>
    <ul class="forminfo">
    <li><input type="hidden"  name="post_id" value="<s:property value="#session.post_id"/>" /></li>
    <li><input type="hidden"  name="user_num" value="<s:property value="#session.user_num"/>" /></li>
    <li><label>收入总额</label><input type="text"  name="taxTable.grossIncome" class="dfinput" /></li>
    <li><label>不征税收入</label><input type="text" name="taxTable.nonTaxableIncome" class="dfinput" /></li>
    <li><label>免税收入</label><input type="text" name="taxTable.exemptIncome" class="dfinput" /></li>
    <li><label>应税收入额</label><input type="text"  name="taxTable.taxableIncome" class="dfinput" /><i>结果:收入总额-不征税收入-免税收入(可不填)</i></li>
    </ul>
    </div> <!--从这开始  -->
 
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
		<% 
   //	String first_basic_num = (String)session.getAttribute("first_basic_num"); //知道X001
   //	String nextPost_id = (String)session.getAttribute("nextPost_id");
   // 	String nextPost_name = (String)session.getAttribute("nextPost_name"); 
		%>

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
        <td><input type="hidden"  name="basic_info_num" value="<s:property value="#session.basic_info_num"/>" /></td>   
        </s:if>
         <!-- 结束 -->
        <td><input type="hidden"  name="nextPost_id" value="<s:property value="#session.nextPost_id"/>" /></td>
         
        </tr>   
        </tbody>
    </table>
     <br><input  type="submit" class="btn" value="确认提交"/>
 </form>
 
  </body>
</html>

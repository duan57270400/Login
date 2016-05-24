<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>功能菜单页面</title>
    
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能操作页面</div>
	<%
	String post_id = (String)session.getAttribute("post_id");
	String post_id2 = (String)session.getAttribute("post_id2");  //到时查岗位流转表 
	String post_id3 = (String)session.getAttribute("post_id3");  //到时查岗位流转表 
    String user_num = (String)session.getAttribute("user_num");
	
	%>

    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <a href="<%=basePath%>/Post_checkOperate.action?order=look_post" target="rightFrame"><span><img src="images/leftico02.png" /></span>岗位管理</a>
    </div>
    	<ul class="menuson">   
       
        <li><cite></cite><a href="<%=basePath%>/Post_checkOperate.action?order=look_post" target="rightFrame">查看岗位</a><i></i></li>

        </ul>    
    </dd>
    <dd>
    <div class="title">
    <a href="<%=basePath%>/Login_lookUsers.action" target="rightFrame"><span><img src="images/leftico02.png" /></span>用户管理</a>
    </div>
    <ul class="menuson">
        <li><cite></cite>新增用户<i></i></li>
        <li><cite></cite><a href="<%=basePath%>/Login_lookUsers.action" target="rightFrame">查看用户</a><i></i></li>
        </ul>     
    </dd> 
     <dd>
    <div class="title">
    <a href="<%=basePath%>/Login_lookDept.action" target="rightFrame"><span><img src="images/leftico02.png" /></span>部门管理</a>
    </div>
    <ul class="menuson">
        <li><cite></cite>新增部门<i></i></li>
        <li><cite></cite><a href="<%=basePath%>/Login_lookDept.action" target="rightFrame">查看部门</a><i></i></li>
        </ul>     
    </dd> 

  
    <s:if test="#session.post_id=='post_01'">
       <dd>
    <div class="title">
    <a href="<%=basePath%>/Tax_windowsFirst.action?user_num=<s:property value="#session.user_num"/>&post_id=<s:property value="#session.post_id"/>" target="rightFrame"><span><img src="images/leftico02.png" /></span>申报纳税</a>
    </div>
    <ul class="menuson">
     
        </ul>     
    </dd> 
    </s:if>
     

    <s:if test="#session.post_id2=='post_02'">
       <dd>
    <div class="title">
    <a href="<%=basePath%>/Tax_businessReception.action?user_num=<%=user_num %>&post_id=<%=post_id2 %>" target="rightFrame"><span><img src="images/leftico02.png" /></span>业务员审核</a>
    </div>
    <ul class="menuson">
       
        </ul>     
    </dd> 
     </s:if>
     


    
    </dl>
      
    
</body>
</html>

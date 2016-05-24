package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.DAO.PostDAO;
import com.test.services.LoginService;
import com.test.vo.PageBean;
import com.test.vo.PostTable;

public class PostAction extends ActionSupport{
	
	private String order;
	private LoginService loginService1;
	private PostTable postTable;
	private PageBean pageBean; //封装了分页信息和数据内容的pageBean
	
	

	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public void setLoginService1(LoginService loginService1) {
		this.loginService1 = loginService1;
	}


	public PostTable getPostTable() {
		return postTable;
	}


	public void setPostTable(PostTable postTable) {
		this.postTable = postTable;
	}


	public String getOrder() {
		return order;
	}



	public void setOrder(String order) {
		this.order = order;
	}



	public String execute(){  //默认的执行方法

		return SUCCESS;
	}
	
	public String checkOperate()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String temp = request.getParameter("pageNum");
		int pageNum;
		
		if(temp==null)
		{
			pageNum = 0;
		}else
		{
			pageNum = Integer.parseInt(temp);
		}
			
		if(null != order && "add_post".equals(order))
		{
			return "add_post";
		}
		
		if(null != order && "del_post".equals(order))
		{
			return "del_post";
		}
		if(null != order && "up_post".equals(order))
		{
			return "up_post";
		}
		if(null != order && "look_post".equals(order))
		{	
			HttpServletRequest request1 = ServletActionContext.getRequest();
			String temp1 = request1.getParameter("pageNum");
			int Num; //表示接到的页码值，1,2,3
			
			if(temp1==null)
			{
				Num = 1;
			}else
			{
				Num = Integer.parseInt(temp1);
			}
		//	loginService1.lookPost(pageNum,2);
			pageBean = loginService1.queryForPage(2, Num);
			
			return "look_post";
		}
		
		return SUCCESS;
	}
	
	public String addPost()
	{	
		
		return loginService1.addPost(postTable);
	}
	
	public String delPost()
	{	
		String temp2 = postTable.getPostId();
	
		return loginService1.delPost(postTable);
	}
	
	public String upDatePost()
	{			
		return loginService1.upDatePost(postTable);
	}
	



}

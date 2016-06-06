package com.test.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.test.services.InService;
import com.test.services.LoginService;
import com.test.services.impl.InServiceImpl;
import com.test.vo.PageBean;
import com.test.vo.PostFlow;
import com.test.vo.UsersTable;


public class LoginAction extends ActionSupport{
	
	private String myOrder;
	private LoginService loginService1;
	private PageBean pageUser; //封装了分页信息和数据内容的pageBean
	private PageBean pageDept; //封装了分页信息和数据内容的pageBean
	private String msg;
	
	@Resource(name="inServiceImpl")
	private InService inServiceImpl;  //测试用接口223
	


	public String getMsg() {
		return msg;
	}




	public void setMsg(String msg) {
		this.msg = msg;
	}



	public PageBean getPageDept() {
		return pageDept;
	}



	public void setPageDept(PageBean pageDept) {
		this.pageDept = pageDept;
	}



	public PageBean getPageUser() {
		return pageUser;
	}



	public void setPageUser(PageBean pageUser) {
		this.pageUser = pageUser;
	}



	public void setLoginService1(LoginService loginService1) {
		this.loginService1 = loginService1;
	}



	public String execute(){  //默认的执行方法

		return SUCCESS;
	}
	
	public String toLeft()
	{
		return "toLeft";
	}
	

	public String reg()
	{
		if( null!= myOrder && "toreg".equals(myOrder) )
		{
		
			ActionContext actionContext = ActionContext.getContext();
	        Map session = actionContext.getSession();
	        UsersTable usersTable = new UsersTable(account, password, username, gender, age, telephone, office, dept, post);
		    
			String securityCode = (String)session.get("securityCode");
			
			if(null == verify || null == securityCode || !securityCode.equals(verify))
			   {
			        	return "yanzheng_error";
			   }
			
			String flag = loginService1.reg(usersTable);
		
			if(null!=flag && "Yes".equals(flag))
			{
				return "reg_success";

			}
			else
			{
				return "reg_error";

			}		
		}
		return "success";
	}
	
	public String login()
	{
		
		if( null!= myOrder && "tologin".equals(myOrder) )
		{
			
			inServiceImpl.addUser();
	
			String flag = loginService1.login(account,password);
			if(null!=flag && "Right".equals(flag))
			{				
				
				return "login_success";
			
			}else
			{
				msg="密码错误";
				return "login_error";
			}
				
		}
		return "success";
	}
	
	public String lookUsers()   //查看用户表信息
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

		pageUser = loginService1.userForPage(3, Num);
		
		return "look_user";
	}
	
	public String lookDept()
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

		pageDept = loginService1.deptForPage(2, Num);
		
		return "look_dept";
	}

	
	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getMyOrder() {
		return myOrder;
	}

	public void setMyOrder(String myOrder) {
		this.myOrder = myOrder;
	}
	
	private String account;   //账户
	private String password;  //密码
	private String username;  //用户姓名
	private String gender;    //性别
	private String age;       //年龄
	private String telephone;  //联系方式
	private String office;    //职称
	private String dept;      //部门
	private String post;      //岗位
	private String verify;    //验证码


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}






}

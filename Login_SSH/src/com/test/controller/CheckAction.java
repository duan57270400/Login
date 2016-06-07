package com.test.controller;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.test.services.LoginService;
import com.test.vo.PostTable;

public class CheckAction extends ActionSupport{
	
	private String order_operate;

	private LoginService loginService1;
	/**
	 * ���Գ���
	 * @param loginService1
	 */

	

	public void setLoginService1(LoginService loginService1) {
		this.loginService1 = loginService1;
	}



	public String execute(){  //Ĭ�ϵ�ִ�з���

		return SUCCESS;
	}



	public String getOrder_operate() {
		return order_operate;
	}

	public void setOrder_operate(String order_operate) {
		this.order_operate = order_operate;
	}
	
	public String checkOperate()
	{
		if(null != order_operate && "reg_account".equals(order_operate))
		{	
			loginService1.getPostAndDept();  //���ȫ���ĸ�λ����
     
			return "reg_account";
		}
		if(null != order_operate && "user_login".equals(order_operate))
		{	
			return "user_login";
		}
		
		if(null != order_operate && "users_manager".equals(order_operate))
		{
			return "users_manager";
		}
		if(null != order_operate && "post_manage".equals(order_operate))
		{
			return "post_manage";
		}
		
		return SUCCESS;
	}

}

package com.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.test.DAO.PostDAO;
import com.test.DAO.TaxDAO;
import com.test.DAO.UserDAO;
import com.test.test.Test3;
import com.test.vo.PageBean;
import com.test.vo.PostFlow;
import com.test.vo.PostTable;
import com.test.vo.TaxTable;
import com.test.vo.UserPost;
import com.test.vo.UsersTable;

public class LoginService {
	private UserDAO userDAO;
	private PostDAO postDAO;
	private TaxDAO taxDAO;	

	

	public void setTaxDAO(TaxDAO taxDAO) {
		this.taxDAO = taxDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void  getPostAndDept()
	{
		userDAO.getPostAndDept();
	}

	public String reg(UsersTable usersTable)
	{					
		return userDAO.reg(usersTable);
	}
	
	public String login(String account,String password)
	{		

		return userDAO.login(account, password);
	}
	
	public String addPost(PostTable postTable)
	{
				
		return postDAO.addPost(postTable);
	}
	
	public String delPost(PostTable postTable)
	{
		return postDAO.delPost(postTable);
	}
	
	public String upDatePost(PostTable postTable)
	{
		return postDAO.upDatePost(postTable);
	}
	
	public void lookPost(int pageNum,int records)
	{
		 postDAO.lookPost(pageNum,records);
	}
	
	public PageBean queryForPage(int records, int page)
	{
		return postDAO.queryForPage(records, page);
	}
	
	public PageBean userForPage(int records, int page)
	{
		return userDAO.userForPage(records, page);
	}
	
	public PageBean deptForPage(int records, int page)
	{
		return userDAO.deptForPage(records, page);
	}
	public String windowsFirst(String post_id,String user_num)   //第一步操作,录入数据及选出下一办人员
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
		PostTable pt2 = taxDAO.postNumUp(post_id);   //职位+1,取出下一位的岗位编号
		windowSession.put("nextPost_id", pt2.getPostId());  //下一个岗位的岗位编号
		windowSession.put("nextPost_name", pt2.getPostName());  //下一个岗位的名字
		taxDAO.getList(pt2);  //第二办的人员选择,选择编号
		
		return "windowsFirst";
	}
	
	public String windowReception(TaxTable taxTable,String post_id,String user_num,String next_user_num,String nextPost_id)  //窗口接待员岗位操作
	{
		calculate(taxTable);         //计算应税收入额 
		taxTable.setBasicInfoNum("X001");
		PostFlow pf = new PostFlow();  //岗位流转表开始储存数据
		pf.setBasicInfoNum("X001");
		pf.setPostId(post_id);
		pf.setUserNum(user_num);
		pf.setStatus("1");
		
		PostFlow pf_temp = new PostFlow();
		pf_temp.setBasicInfoNum("X001");
		pf_temp.setPostId(nextPost_id);
		pf_temp.setUserNum(next_user_num);
		pf_temp.setStatus("0");
		
		return taxDAO.windowReception(taxTable,pf,pf_temp,post_id,user_num);
	}
	
	 public static void calculate(TaxTable taxTable)   //计算应税收入额
	 {
			double grossIncome = Double.parseDouble(taxTable.getGrossIncome());
			double nonTaxableIncome =  Double.parseDouble(taxTable.getNonTaxableIncome());
			double exemptIncome = Double.parseDouble(taxTable.getExemptIncome());
			double taxableIncome = grossIncome - nonTaxableIncome - exemptIncome;
			taxTable.setTaxableIncome(String.valueOf(taxableIncome));
	 }
	
	public String selectNextUser(String first_basic_num,String nextPost_id,String next_user_num)
	{
		
		return taxDAO.selectNextUser(first_basic_num,nextPost_id,next_user_num);
	}
	
	public String businessReception(String post_id,String user_num)  //业务员业务操作
	{
			
		return taxDAO.businessReception(post_id, user_num);
	}
	
	public String businessBrowse(String basic_info_num,String post_id)  //查看信息和选择第三办人员
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
		PostTable pt2 = taxDAO.postNumUp(post_id);   //职位+1,取出下一位的岗位编号
		windowSession.put("nextPost_id", pt2.getPostId());  //下一个岗位的岗位编号
		windowSession.put("nextPost_name", pt2.getPostName());  //下一个岗位的名字
		taxDAO.getList(pt2);  //第二办的人员选择,选择编号
		
		return taxDAO.businessBrowse(basic_info_num);
	}
	
	public String businessUpdate(String basic_info_num,String post_id2,String user_num,String taxAuthorityPay,String reviewComments,String next_user_num)
	{
		PostTable pt2 = taxDAO.postNumUp(post_id2);   //职位+1,取出下一位的岗位编号
		String next_postId = pt2.getPostId();   //存进税表的第三办的岗位编号
		PostFlow pf_temp = new PostFlow();
		pf_temp.setBasicInfoNum("X001");
		pf_temp.setPostId(next_postId);
		pf_temp.setUserNum(next_user_num);
		pf_temp.setStatus("0");
		return taxDAO.businessUpdate(basic_info_num, post_id2, user_num, taxAuthorityPay, reviewComments,next_user_num,pf_temp);
	}
}

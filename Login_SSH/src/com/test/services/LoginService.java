package com.test.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.test.DAO.PostDAO;
import com.test.DAO.TaxDAO;
import com.test.DAO.UserDAO;
import com.test.vo.CollectiveComments;
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
	//����ڸ������----------
	public String updateComment(String user_num,String post_id,String comment)
	{
		String hql = "from CollectiveComments cc where cc.postId='"+post_id+"' and cc.userNum='"+user_num+"'";
		List list = taxDAO.getObject(hql);
		
		if(list.size()!=0)
		{
			CollectiveComments cc =(CollectiveComments) list.get(0);
			cc.setComment(comment);
			cc.setCompleteTime(new Date());
			cc.setStatus(1);
			taxDAO.update(cc);
		}
		
		//�ж��Ƿ����������Ա�Ƿ������
		String hql2="from CollectiveComments cc";
		List<CollectiveComments> list2 = taxDAO.getObject(hql2);
		int flag = 0;
		if(list2.size()!=0)
		{
			   for(CollectiveComments cc :list2)  //for eachѭ��
			   {
				   if(cc.getStatus()==0)
					   flag++;
			   }
			   if(flag==0)  //��������������ڵ���Աȫ������ˣ���ʱ��ת���1
			   {
				   String hql3 = "from PostFlow pf where pf.postId='"+post_id+"'";
				   List list3 = taxDAO.getObject(hql3);
				   PostFlow pf = (PostFlow)list3.get(0);
				   pf.setStatus("1");
				   taxDAO.update(pf);
				   
				   return "complete";
			   }
		
		}
	
		return "businessUpdate";
	}

	public String collectiveOperate(String user_num,String post_id)
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();

		 String hql_test = "from CollectiveComments cc where cc.postId='"+post_id+"' and cc.userNum='"+user_num+"'";
		 List test=taxDAO.testIsNull(hql_test);  //���Լ������������Ƿ��и��û��Ĺ���
		 if(test.size()==1)
		 {		
		      windowSession.put("user_num", user_num);
		      windowSession.put("post_id", post_id);
		      
			 return "update_collective.jsp";
		 }else
		 {
			 return "error";
		 }

		
	}
	public String windowsFirst(String post_id,String user_num)   //��һ������,¼�����ݼ�ѡ����һ����Ա
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
		PostTable pt2 = taxDAO.postNumUp(post_id);   //ְλ+1,ȡ����һλ�ĸ�λ���
		int collectiveFlag = 2;          
		if(pt2.getCollectivePost()==0)  //������Ǽ����,��һ����������
		{
			collectiveFlag = 0;         //����Ǽ����,��Ϊ0		
			windowSession.put("nextPost_id", pt2.getPostId());  //��һ����λ�ĸ�λ���
			
			taxDAO.getList(pt2);  //�ڶ������Աѡ��,ѡ����
		}else if(pt2.getCollectivePost()==1)   //����Ǽ����
		{
			collectiveFlag = 1;   //����Ǽ����,��Ϊ1
			String hql = "from UserPost up where up.postId='"+pt2.getPostId()+"'";
			List CollectiveList =taxDAO.getCollective_post(hql);  //��ü���ڵ��û����
			windowSession.put("CollectiveList", CollectiveList);
			windowSession.put("CollectivePostId", pt2.getPostId());  //����ڸ�λ���
			windowSession.put("basic_info_num", pt2.getBasicInfoNum()); //��������̺�

		}
		windowSession.put("collectiveFlag", collectiveFlag);
		windowSession.put("nextPost_name", pt2.getPostName());  //��һ����λ������
		
		return "windowsFirst";
	}
	public String chiefOperate(String user_num,String post_id3)  //�ɳ�����:�鿴��Ϣ��ѡ����İ���Ա
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
        windowSession.put("post_id", post_id3);
        String hql_test = "from PostFlow pf where pf.userNum='"+user_num+"' and pf.postId='"+post_id3+"'";
        List test=taxDAO.testIsNull(hql_test);  //���Ը�λ��ת�����Ƿ��и��û��Ĺ���
        if(test.size()!=0)
        {
        	  taxDAO.businessBrowse("X001");  //���˰����Ϣ
              PostTable pt2 = taxDAO.postNumUp(post_id3);   //ְλ+1,ȡ����һλ�ĸ�λ���
              int collectiveFlag = 2;          
      		if(pt2.getCollectivePost()==0)  //������Ǽ����,��һ����������
      		{
      			collectiveFlag = 0;         //����Ǽ����,��Ϊ0	
      			/**
      			 * �����������
      			 */		
      		}else if(pt2.getCollectivePost()==1)   //����Ǽ����
      		{
      			collectiveFlag = 1;   //����Ǽ����,��Ϊ1
      			String hql = "from UserPost up where up.postId='"+pt2.getPostId()+"'";
      			List CollectiveList =taxDAO.getCollective_post(hql);  //��ü���ڵ��û����
      			windowSession.put("CollectiveList", CollectiveList);
      			windowSession.put("CollectivePostId", pt2.getPostId());  //����ڸ�λ���
      			windowSession.put("basic_info_num", pt2.getBasicInfoNum()); //��������̺�			
      		}
      		windowSession.put("collectiveFlag", collectiveFlag);
      		windowSession.put("ChiefNum", user_num);
      		windowSession.put("nextPost_name", pt2.getPostName());  //��һ����λ������
        }
  
		return "chiefOperate";
	}
	
	public String businessBrowse(String basic_info_num,String post_id,String user_num)  //�鿴��Ϣ��ѡ���������Ա
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
		String hql = "from PostFlow pf where pf.postId='"+post_id+"' and pf.userNum='"+user_num+"'";
        List test=taxDAO.testIsNull(hql); 
        
        if(test.size()!=0)
        {
            PostTable pt2 = taxDAO.postNumUp(post_id);   //ְλ+1,ȡ����һλ�ĸ�λ���
            
            windowSession.put("nextPost_id", pt2.getPostId());  //��һ����λ�ĸ�λ���
        	windowSession.put("nextPost_name", pt2.getPostName());  //��һ����λ������  		
        	taxDAO.getList(pt2);  //���������Աѡ��,ѡ����  
     
        	/**SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	 * System.out.println("��ǰʱ����"+sdf.format(new Date()));
        	 * ��õ�ǰʱ��
        	 */
        	taxDAO.businessBrowse(basic_info_num);
        }
    	
    	return "businessBrowse";	
	}
	
	
	public String ChiefReception(String basic_info_num,String user_num,String Chief_comments,String CollectivePostId,String[] CollectiveUserNum,String post_id)   //�ɳ����¸�λ��ת��¼�뼯�����Ϣ
	{
		String hql = "from PostFlow pf where pf.postId='"+post_id+"' and pf.userNum='"+user_num+"'";
		List list = taxDAO.getObject(hql);

		if(list.size()!=0)
		{
			PostFlow pf = (PostFlow)list.get(0);
			pf.setStatus("1");
			taxDAO.update(pf);   //���¸�λ���Ϊ1��ʾ���
			String hql2 = "from TaxTable tt where tt.basicInfoNum='"+basic_info_num+"'";
			List list2 = taxDAO.getObject(hql2);
			TaxTable tt = (TaxTable)list2.get(0);
			tt.setChiefComments(Chief_comments);
			taxDAO.update(tt);   //˰�����
		}
		PostFlow pf = new PostFlow();
		pf.setBasicInfoNum(basic_info_num);
		pf.setPostId(CollectivePostId);
		pf.setUserNum("�����");
		pf.setStatus("0");
		taxDAO.save(pf);    //��ת�����ɼ���ڼ�¼
		
		//���ɸ�λ��λ�����
		CreateCollect(basic_info_num,CollectivePostId,CollectiveUserNum);
		
		return "businessUpdate";
	}
	

	public String windowReception(TaxTable taxTable,String post_id,String user_num,String next_user_num,String nextPost_id)  //���ڽӴ�Ա��λ����
	{
		calculate(taxTable);         //����Ӧ˰����� 
		taxTable.setBasicInfoNum("X001");
		PostFlow pf = new PostFlow();  //��λ��ת��ʼ��������
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
	
	 public static void calculate(TaxTable taxTable)   //����Ӧ˰�����
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
	
	public String businessReception(String post_id,String user_num)  //ҵ��Աҵ�����
	{
		ActionContext actionContext = ActionContext.getContext();
        Map businessSession = actionContext.getSession();
        PostTable pt2 = taxDAO.postNumUp(post_id);   //ְλ+1,ȡ����һλ�ĸ�λ���
		String hql="from PostFlow pf where pf.postId=? and pf.userNum=?";
		List list_business = taxDAO.businessReception(post_id, user_num, hql);
		businessSession.put("list_business", list_business);
		
		 
		return "businessChoice";
	}
	

	
	public String businessUpdate(String basic_info_num,String post_id2,String user_num,String taxAuthorityPay,String reviewComments,String next_user_num)
	{
		PostTable pt2 = taxDAO.postNumUp(post_id2);   //ְλ+1,ȡ����һλ�ĸ�λ���
		String next_postId = pt2.getPostId();   //���˰��ĵ�����ĸ�λ���
		PostFlow pf_temp = new PostFlow();
		pf_temp.setBasicInfoNum("X001");
		pf_temp.setPostId(next_postId);
		pf_temp.setUserNum(next_user_num);
		pf_temp.setStatus("0");
		return taxDAO.businessUpdate(basic_info_num, post_id2, user_num, taxAuthorityPay, reviewComments,next_user_num,pf_temp);
	}
	
	public void CreateCollect(String basic_info_num,String CollectivePostId,String[] CollectiveUserNum)    //���ɸ�λ��λ�����
	{
		for(int i=0;i<CollectiveUserNum.length;i++)
		{
			CollectiveComments cc = new CollectiveComments();
			cc.setBasicInfoNum(basic_info_num);
			cc.setPostId(CollectivePostId);
			cc.setStatus(0);
			cc.setUserNum(CollectiveUserNum[i]);
			taxDAO.save(cc);
		}
	}
}

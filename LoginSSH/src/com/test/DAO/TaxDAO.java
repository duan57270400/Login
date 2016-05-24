package com.test.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.test.vo.PostFlow;
import com.test.vo.PostTable;
import com.test.vo.TaxTable;

public class TaxDAO {
private BaseDAO baseDAO;
Session session = null;
	
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	public String businessUpdate(String basic_info_num,String post_id2,String user_num,String taxAuthorityPay,String reviewComments,String nextPost_id,PostFlow pf_temp )
	{
		session = baseDAO.getSession();
		session.beginTransaction();  //��������
		session.save(pf_temp);
		String hql = "from TaxTable tt where tt.basicInfoNum=?";
		Query query_hql = session.createQuery(hql);
		query_hql.setParameter(0,basic_info_num);
		List list1 = (List)query_hql.list();
		TaxTable taxTable = (TaxTable)list1.get(0);
		taxTable.setTaxAuthorityPay(taxAuthorityPay);
		taxTable.setReviewComments(reviewComments);
		
		String hql_two="from PostFlow pf where pf.basicInfoNum=? and pf.postId=? and pf.userNum=?";
		Query query_hql2 = session.createQuery(hql_two);
		query_hql2.setParameter(0,basic_info_num);
		query_hql2.setParameter(1,post_id2);
		query_hql2.setParameter(2,user_num);
		List list2 = (List)query_hql2.list();
		PostFlow postFlow = (PostFlow)list2.get(0);
		postFlow.setStatus("1");
		session.getTransaction().commit();   //�ύ����
		session.close();
		
		return "businessUpdate";
	}
	
	public String businessBrowse(String basic_info_num)  //�鿴�ڶ����˰����Ϣ
	{
	    session = baseDAO.getSession();
		session.beginTransaction();  //��������
		String hql = "from TaxTable tt where tt.basicInfoNum=? ";
		Query query_business = session.createQuery(hql);
		query_business.setParameter(0,basic_info_num);
	
		List list_Browse = query_business.list();
		ActionContext actionContext = ActionContext.getContext();
        Map businessSession = actionContext.getSession();
        businessSession.put("basic_info_num", basic_info_num);
        businessSession.put("list_Browse", list_Browse);
        session.close();
		return "businessBrowse";
	}
	public String businessReception(String post_id,String user_num)  //ҵ��Աҵ�����,ѡ��������ҵ����X001��X002
	{
	    session = baseDAO.getSession();
		session.beginTransaction();  //��������
		String hql="from PostFlow pf where pf.postId=? and pf.userNum=?";
		Query query_business = session.createQuery(hql);
		query_business.setParameter(0, post_id);
		query_business.setParameter(1, user_num);
		List list_business = query_business.list();
		ActionContext actionContext = ActionContext.getContext();
        Map businessSession = actionContext.getSession();
        businessSession.put("list_business", list_business);
        session.close();
		return "businessChoice";
	}
	
	public String selectNextUser(String first_basic_num,String nextPost_id,String next_user_num)
	{
		session = baseDAO.getSession();
		session.beginTransaction();  //��������
		PostFlow pf = new PostFlow();  //��λ��ת����ڶ�������
		pf.setBasicInfoNum(first_basic_num);
		pf.setPostId(nextPost_id);
		pf.setUserNum(next_user_num);
		pf.setStatus("0");
		session.save(pf);
		session.getTransaction().commit();   //�ύ����
		session.close();
		
		
		return "selectNextUser";
	}
	
	public void getList(PostTable pt2)
	{
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
	    session = baseDAO.getSession();
		session.beginTransaction();  //��������
		
	    String hql_select = "from UserPost up where up.postId=?";  //ѡ����ʵ�ָ����Ա
        Query query_select = session.createQuery(hql_select);
        query_select.setParameter(0, pt2.getPostId());
        List list_select = query_select.list();
        windowSession.put("list_select", list_select);  //�ڶ������Աѡ��,ѡ����
		
		session.getTransaction().commit();   //�ύ����
		session.close();
		
	}
	
	public String windowReception(TaxTable taxTable,PostFlow pf,PostFlow pf_temp,String post_id,String user_num)
	{
		
		session = baseDAO.getSession();
		session.beginTransaction();  //��������
		
	//	taxTable.setBasicInfoNum("X001"); 
		session.save(taxTable);      //˰���������
		
	//	PostFlow pf = new PostFlow();  //��λ��ת��ʼ��������
	//	pf.setBasicInfoNum("X001");
	//	pf.setPostId(post_id);
	//	pf.setUserNum(user_num);
	//	pf.setStatus("1");
		session.save(pf);       //��λ��ת���������
		session.save(pf_temp);
		
//		PostTable pt2 = postNumUp(post_id);   //ְλ+1,ȡ����һλ�ĸ�λ���
		
		ActionContext actionContext = ActionContext.getContext();
        Map windowSession = actionContext.getSession();
//      windowSession.put("first_basic_num", "X001");
//      windowSession.put("nextPost_id", pt2.getPostId());
//      windowSession.put("nextPost_name", pt2.getPostName());
        
//      String hql_select = "from UserPost up where up.postId=?";  //ѡ����ʵ�ָ����Ա
//      Query query_select = session.createQuery(hql_select);
//      query_select.setParameter(0, pt2.getPostId());
//      List list_select = query_select.list();
//      windowSession.put("list_select", list_select);  //�ڶ������Աѡ��,ѡ����
		
		session.getTransaction().commit();   //�ύ����
		session.close();
		
		return "selectNextUser";
	}
	

 
 public PostTable postNumUp(String post_id)    //ְλ+1,ȡ����һλ�ĸ�λ���
 {
    	session = baseDAO.getSession();
	    String hql_post = "from PostTable pt where pt.postId=?";  
		Query service_num = session.createQuery(hql_post);
		service_num.setParameter(0, post_id);
		List list1 = service_num.list();
		PostTable pt = (PostTable)list1.get(0);
		int num = Integer.parseInt(pt.getServiceNum());
		num = num + 1;
		String hql_up = "from PostTable pt where pt.serviceNum=?";
		Query num_temp = session.createQuery(hql_up);
		num_temp.setParameter(0, String.valueOf(num));
		List list2 = num_temp.list();
		PostTable pt2 = (PostTable)list2.get(0);
		session.close();
		return pt2;
 }

}

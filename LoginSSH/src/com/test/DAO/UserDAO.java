package com.test.DAO;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.test.vo.DeptTable;
import com.test.vo.PageBean;
import com.test.vo.PostTable;
import com.test.vo.UserPost;
import com.test.vo.UsersTable;


public class UserDAO   {
	
	private BaseDAO baseDAO;
	
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}


	public String reg(UsersTable usersTable)   //ע��
	{
		String flag = "Yes";
		String acc="";
	
		try
		{	
	//		ApplicationContext context = new FileSystemXmlApplicationContext("file:D:/WebExercise/LoginSSH/src/applicationContext.xml");
	//		BaseDAO baseDAO = (BaseDAO)context.getBean("baseDAO");
			String sql_sel="from UsersTable u where u.account= ?" ;
			Session session = baseDAO.getSession();
		
			Query query = session.createQuery(sql_sel);
			query.setParameter(0, usersTable.getAccount());							
			List usersList = query.list();

	
			if(usersList.size()!=0)
			{
				UsersTable temp =(UsersTable)usersList.get(0);  //�ж��˺��Ƿ���ע��
				acc =temp.getAccount();
			}
			
			
			if(acc.equals(usersTable.getAccount()))
			{
				flag = "No";
			}
					
				
			if("Yes".equals(flag))
			{
				session.beginTransaction();  //��������
		
			    session.save(usersTable);		  //����user����

				System.out.println("ע��ɹ�");
				
      /*		PostTable pt = new PostTable();  //����������
				pt.setPostId("post_01");
				pt.setPostName("�����λ");
				pt.setServiceNum("ser_01");
				session.save(pt);    //����������
     */		 
	//	   	  UserTable uu2 =(UserTable)session.get(UserTable.class,27); //���Ը���
	//	      uu2.setPassword("������");
				
	//		    session.update(uu2);
				session.getTransaction().commit();   //�ύ����
				
	//			System.out.println("���³ɹ�");   
			}
			else 
			{
				System.out.println("ע��ʧ��1");
			}
			session.close();
		}catch(Exception e){
            e.printStackTrace();    
        }
			
		return flag;
	}
	
	public String login(String account,String password)  //��¼
	{
		
		String acc="";
		String pw="";
		String flagName="Noright";
		String user_num="";  //��ʾ�û����
		
		
		try
		{
			ActionContext actionContext = ActionContext.getContext();
	        Map userTest = actionContext.getSession();
	//		ApplicationContext context = new FileSystemXmlApplicationContext("file:D:/WebExercise/Login3/src/applicationContext.xml");
	//		BaseDAO baseDAO = (BaseDAO)context.getBean("baseDAO");
	
			String sql2 = "from UsersTable ";
			Session session = baseDAO.getSession();
			
			Query query = session.createQuery(sql2);
			List usersList = query.list();
			
			for(int i=0;i<usersList.size();i++)
			{
				UsersTable user = (UsersTable)usersList.get(i);

				acc = user.getAccount();
				pw = user.getPassword();
				user_num  =user.getUserNum();   //�û����
			
				if(acc.equals(account) && pw.equals(password) )
				{
					userTest.put("user_num",user_num);  // �ѵ�½�û����û���ŷŽ�session
					flagName="Right";	
					//��ʼ��ȥ��Ա��λ��ƥ��Ȩ��
					String hql_un="from UserPost up where up.userNum=? ";
					Query query_un = session.createQuery(hql_un);
					query_un.setParameter(0,user_num);
									
					List un =query_un.list();
					for(int j=0;j<un.size();j++)
					{
						UserPost userPost = (UserPost)un.get(j);
						if("post_01".equals(userPost.getPostId()))
						{
							userTest.put("post_id","post_01");
						}
						if("post_02".equals(userPost.getPostId()))
						{
							userTest.put("post_id2","post_02");
						}
						if("post_03".equals(userPost.getPostId()))
						{
							userTest.put("post_id3","post_03");
						}

						
				
					}
					

				}	
			}

			session.close();
		}catch (Exception e) {
			System.out.println("��½ʧ��");
			e.printStackTrace();
		}
		return flagName;
	}
	
	public void  getPostAndDept()   //ȡ�ø�λ�Ͳ����б�
	{
		ActionContext actionContext = ActionContext.getContext();
        Map postAndDept = actionContext.getSession();
        
		String hql_one="from PostTable";   //---��ʼ��ø�λ����
		Session session = baseDAO.getSession();

		Query query_post = session.createQuery(hql_one);
		List list_post = query_post.list();
		
		postAndDept.put("post",list_post);
		
		String hql_two="from DeptTable";    //------��ʼ��ò�������
		Query query_dept = session.createQuery(hql_two);
		List lost_dept =query_dept.list();
		
		postAndDept.put("dept",lost_dept);
		session.close();
	}
	
	
	public PageBean userForPage(int records, int page)  //����û���ҳ����������
	{

		String hql = "from UsersTable"; //��ѯ���
		Session session = baseDAO.getSession();
		Query query_user = session.createQuery(hql);
		
		List allRecords = query_user.list();
		int allRow = allRecords.size();  //�ܼ�¼��
		
		final int length = records; // ÿҳ��¼��
		int totalPage = PageBean.countTatalPage(records, allRow); //��ҳ��
		final int currentPage = PageBean.countCurrentPage(page,totalPage); // ��ǰҳ
		final int offset = PageBean.countOffset(records, currentPage); //��ǰҳ��ʼ��¼
		
		
		
		query_user.setFirstResult(offset);
		query_user.setMaxResults(records);
		List<UsersTable> list_user = query_user.list();  //���ÿҳ�ľ�������
		

		//�ѷ�ҳ��Ϣ���浽Bean����
		PageBean pageBean  = new PageBean();
		pageBean.setPageSize(records);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list_user);
		pageBean.setDetail(pageBean.PageDetail(totalPage));
		pageBean.init();
		session.close();
		return pageBean;
	}
	
	
	public PageBean deptForPage(int records, int page)  //��ò��ŷ�ҳ����������
	{

		String hql = "from DeptTable"; //��ѯ���
		Session session = baseDAO.getSession();
		Query query_dept = session.createQuery(hql);
		
		List allRecords = query_dept.list();
		int allRow = allRecords.size();  //�ܼ�¼��
		
		final int length = records; // ÿҳ��¼��
		int totalPage = PageBean.countTatalPage(records, allRow); //��ҳ��
		final int currentPage = PageBean.countCurrentPage(page,totalPage); // ��ǰҳ
		final int offset = PageBean.countOffset(records, currentPage); //��ǰҳ��ʼ��¼
	
		
		
		query_dept.setFirstResult(offset);
		query_dept.setMaxResults(records);
		List<DeptTable> list_dept = query_dept.list();  //���ÿҳ�ľ�������
		

		//�ѷ�ҳ��Ϣ���浽Bean����
		PageBean pageBean  = new PageBean();
		pageBean.setPageSize(records);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list_dept);
		pageBean.setDetail(pageBean.PageDetail(totalPage));
		pageBean.init();
		session.close();
		return pageBean;
	}
	



}

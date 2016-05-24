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


	public String reg(UsersTable usersTable)   //注册
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
				UsersTable temp =(UsersTable)usersList.get(0);  //判断账号是否已注册
				acc =temp.getAccount();
			}
			
			
			if(acc.equals(usersTable.getAccount()))
			{
				flag = "No";
			}
					
				
			if("Yes".equals(flag))
			{
				session.beginTransaction();  //开启事务
		
			    session.save(usersTable);		  //保存user对象

				System.out.println("注册成功");
				
      /*		PostTable pt = new PostTable();  //测试两个表
				pt.setPostId("post_01");
				pt.setPostName("调查岗位");
				pt.setServiceNum("ser_01");
				session.save(pt);    //测试两个表
     */		 
	//	   	  UserTable uu2 =(UserTable)session.get(UserTable.class,27); //测试更新
	//	      uu2.setPassword("测试中");
				
	//		    session.update(uu2);
				session.getTransaction().commit();   //提交事务
				
	//			System.out.println("更新成功");   
			}
			else 
			{
				System.out.println("注册失败1");
			}
			session.close();
		}catch(Exception e){
            e.printStackTrace();    
        }
			
		return flag;
	}
	
	public String login(String account,String password)  //登录
	{
		
		String acc="";
		String pw="";
		String flagName="Noright";
		String user_num="";  //表示用户编号
		
		
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
				user_num  =user.getUserNum();   //用户编号
			
				if(acc.equals(account) && pw.equals(password) )
				{
					userTest.put("user_num",user_num);  // 把登陆用户的用户编号放进session
					flagName="Right";	
					//开始拿去人员岗位表匹配权限
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
			System.out.println("登陆失败");
			e.printStackTrace();
		}
		return flagName;
	}
	
	public void  getPostAndDept()   //取得岗位和部门列表
	{
		ActionContext actionContext = ActionContext.getContext();
        Map postAndDept = actionContext.getSession();
        
		String hql_one="from PostTable";   //---开始获得岗位名称
		Session session = baseDAO.getSession();

		Query query_post = session.createQuery(hql_one);
		List list_post = query_post.list();
		
		postAndDept.put("post",list_post);
		
		String hql_two="from DeptTable";    //------开始获得部门名称
		Query query_dept = session.createQuery(hql_two);
		List lost_dept =query_dept.list();
		
		postAndDept.put("dept",lost_dept);
		session.close();
	}
	
	
	public PageBean userForPage(int records, int page)  //获得用户分页和数据内容
	{

		String hql = "from UsersTable"; //查询语句
		Session session = baseDAO.getSession();
		Query query_user = session.createQuery(hql);
		
		List allRecords = query_user.list();
		int allRow = allRecords.size();  //总记录数
		
		final int length = records; // 每页记录数
		int totalPage = PageBean.countTatalPage(records, allRow); //总页数
		final int currentPage = PageBean.countCurrentPage(page,totalPage); // 当前页
		final int offset = PageBean.countOffset(records, currentPage); //当前页开始记录
		
		
		
		query_user.setFirstResult(offset);
		query_user.setMaxResults(records);
		List<UsersTable> list_user = query_user.list();  //获得每页的具体数据
		

		//把分页信息保存到Bean当中
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
	
	
	public PageBean deptForPage(int records, int page)  //获得部门分页和数据内容
	{

		String hql = "from DeptTable"; //查询语句
		Session session = baseDAO.getSession();
		Query query_dept = session.createQuery(hql);
		
		List allRecords = query_dept.list();
		int allRow = allRecords.size();  //总记录数
		
		final int length = records; // 每页记录数
		int totalPage = PageBean.countTatalPage(records, allRow); //总页数
		final int currentPage = PageBean.countCurrentPage(page,totalPage); // 当前页
		final int offset = PageBean.countOffset(records, currentPage); //当前页开始记录
	
		
		
		query_dept.setFirstResult(offset);
		query_dept.setMaxResults(records);
		List<DeptTable> list_dept = query_dept.list();  //获得每页的具体数据
		

		//把分页信息保存到Bean当中
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

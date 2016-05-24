package com.test.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionContext;
import com.test.vo.PageBean;
import com.test.vo.PostTable;


public class PostDAO {
	
	private BaseDAO baseDAO;
	Session session = null;
	

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	public String addPost(PostTable postTable)
	{
		session = baseDAO.getSession();
		session.beginTransaction();  //开启事务
		session.save(postTable);
		session.getTransaction().commit();   //提交事务
		session.close();
		return "addPost";
	}
	
	public String delPost(PostTable postTable)
	{
		session = baseDAO.getSession();
		session.beginTransaction();  //开启事务
		session.delete(postTable);
		session.getTransaction().commit();   //提交事务
		session.close();
		return "delPost";
	}
	
	public String upDatePost(PostTable postTable)
	{
		session = baseDAO.getSession();
		session.beginTransaction();  //开启事务
		String num = postTable.getPostId();
		String name = postTable.getPostName();
	

		postTable = (PostTable)session.get(PostTable.class,num);
		postTable.setPostName(name);
		session.update(postTable);
		session.getTransaction().commit();   //提交事务
		session.close();
		return "upDatePost";
	}
	
	public void lookPost(int pageNum,int records)
	{
		ActionContext actionContext = ActionContext.getContext();
        Map postSession = actionContext.getSession();
        
		String hql_one="from PostTable";   //---开始获得岗位名称
	    session = baseDAO.getSession();

		Query query_post = session.createQuery(hql_one);
		List allRecords = query_post.list();		
		postSession.put("allRecords",allRecords);  //获得总记录数
		
		int adllPages;           
		if(((allRecords.size()*1.0/records)-(allRecords.size()/records))>0)
		{
			adllPages = (allRecords.size()/records)+1;
		}
		else
		{
			adllPages = (allRecords.size()/records);
		}
		postSession.put("adllPages",adllPages);    //获得总页数
			
		query_post.setFirstResult((pageNum-1)*records);
		query_post.setMaxResults(records);
		List list_post = query_post.list();
		
		postSession.put("post",list_post);
		session.close();
			
	}
	
	public PageBean queryForPage(int records, int page)
	{
		String hql = "from PostTable"; //查询语句
	    session = baseDAO.getSession();
		Query query_post = session.createQuery(hql);
		
		List allRecords = query_post.list();
		int allRow = allRecords.size();  //一共含有XX条记录
	
		
		final int length = records; // 每页记录数
		int totalPage = PageBean.countTatalPage(records, allRow); //总页数
		final int currentPage = PageBean.countCurrentPage(page,totalPage); // 当前页
		final int offset = PageBean.countOffset(records, currentPage); //当前页开始记录

		
		query_post.setFirstResult(offset);
		query_post.setMaxResults(records);
		List<PostTable> list_post = query_post.list();  //获得每页的具体数据
		

		//把分页信息保存到Bean当中
		PageBean pageBean  = new PageBean();
		pageBean.setPageSize(records);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list_post);
		pageBean.setDetail(pageBean.PageDetail(totalPage));
		pageBean.init();
		session.close();
		return pageBean;
		
	}
	

}

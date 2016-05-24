package com.test.DAO.impl;



import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.test.DAO.InDAO;

@Repository("UserDAOImpl")
public class InDAOImpl  implements InDAO{
	

	Session session = null;
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public Session getSession() {
		Session session = sessionFactory.openSession();
		
		return session;
	}
	

	
	 public <T> void sava1(T entity1) {
		 session = getSession();
		 session.beginTransaction();  //开启事务
		 session.save(entity1);
		 session.getTransaction().commit();   //提交事务
		 session.close();
	       
	    }
	

}

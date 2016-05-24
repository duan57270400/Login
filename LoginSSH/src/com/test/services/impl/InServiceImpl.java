package com.test.services.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.DAO.impl.InDAOImpl;
import com.test.services.InService;
import com.test.test.Test3;
import com.test.vo.PostTable;

@Service("inServiceImpl")
public class InServiceImpl implements InService{
	

	
	@Resource(name="UserDAOImpl")
	private InDAOImpl UserDAOImpl;  //���ԵĽӿ���
	



	public void addUser()
	{
		PostTable postTable = new PostTable();
		postTable.setPostId("post_09");
		postTable.setPostName("��ѧ��");
		postTable.setServiceNum("0091");
		System.out.println("������"+postTable.getServiceNum());

		UserDAOImpl.sava1(postTable);
		
	}

	
	

}

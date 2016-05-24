package com.test.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.test.DAO.BaseDAO;
import com.test.services.LoginService;

public class TestUnits {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("file:D:/WebExercise/Login3/src/applicationContext.xml");
	//	LoginService a = (LoginService)context.getBean("loginService");
	//	System.out.println(a);

	}

}

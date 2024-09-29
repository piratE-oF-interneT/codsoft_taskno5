package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.app.factory.InstanceFactory;

public class ProjTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/com/app/cfgs/applicationContext.xml");
		
		InstanceFactory factory = context.getBean("factory", InstanceFactory.class);
		
		factory.software();
	}

}

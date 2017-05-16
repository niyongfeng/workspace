package com.nyf.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nyf.serviceImp.ProductServiceImp;
import com.nyf.serviceImp.TagServiceImp;
import com.nyf.serviceImp.UserServiceImp;


public class ServiceFactory {
	public static ProductServiceImp productServiceImp;
	public static TagServiceImp tagServiceImp;
	public static UserServiceImp userServiceImp;
	private static ApplicationContext context = new ClassPathXmlApplicationContext("mybatis_config.xml");
	static {
		productServiceImp = context.getBean("productServiceImp",ProductServiceImp.class);
		tagServiceImp = context.getBean("tagServiceImp",TagServiceImp.class);
		userServiceImp = context.getBean("userServiceImp", UserServiceImp.class);
	}
	
}

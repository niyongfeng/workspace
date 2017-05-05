package com.qingke.path;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class LearnPath {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		//ClasspathResource
		Resource r = context.getResource("classpath:applicationContext2.xml");
		System.out.println("Resource:" + r.getClass());
		//URLResource
		Resource r1 = context.getResource("file:applicationContext2.xml");
		System.out.println("Resource:" + r1.getClass());
		//ClasspathContextResource
		Resource r2 = context.getResource("applicationContext2.xml");
		System.out.println("Resource:" + r2.getClass());
		//ClasspathContextResource
		Resource r3 = context.getResource("/applicationContext2.xml");
		System.out.println("Resource:" + r3.getClass());
	}
}

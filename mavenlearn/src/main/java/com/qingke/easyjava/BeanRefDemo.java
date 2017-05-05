package com.qingke.easyjava;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanRefDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanOne.xml","beanTwo.xml");
		BeanWrapper bean1 = context.getBean("bean",BeanWrapper.class);
		bean1.getInnerBean().say();
		bean1.say();
		context.close();
	}
}

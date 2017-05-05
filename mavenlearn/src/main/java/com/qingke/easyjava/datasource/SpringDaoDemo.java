package com.qingke.easyjava.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDaoDemo {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//DataSource ds0 = (DataSource) context.getBean("baseDao");
		DataSource ds = (DataSource) context.getBean("dataSource");
		Connection conn = ds.getConnection();
		System.out.println("dataSource:" + ds);
		System.out.println("connection from dataSource:" + conn);
		
		DataSource ds2 = (DataSource) context.getBean("dataSource2");
		System.out.println("dataSource2:" + ds2);
		System.out.println("connection from dataSource:" + ds2.getConnection());
		
		DataSource ds3 = (DataSource) context.getBean("dataSource3");
		System.out.println("dataSource3:" + ds3);
		System.out.println("connection from dataSource:" + ds3.getConnection());
		
		((ClassPathXmlApplicationContext)context).close();
	}
}

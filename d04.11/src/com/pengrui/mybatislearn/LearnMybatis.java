package com.pengrui.mybatislearn;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pengrui.mybatis.projo.User;


public class LearnMybatis {

	public static void main(String[] args) {
		String resource = "mybatis_conf.xml";
		
		InputStream is = LearnMybatis.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = sessionFactory.openSession();
		
//		String str = "com.pengrui.mybatis.mapping.projectMapper.selectAll";
//		List<Project> list1 = session.selectList(str);
//		for(Project p : list1) { 
//			System.out.println(p);
//		}
		
		String str1 = "com.pengrui.mybatis.mapping.userMapper.selectAll";
		List<User> list2 = session.selectList(str1);
		for(User p : list2) {
			System.out.println(p);
		}
		session.commit();
		session.close();
	}
}

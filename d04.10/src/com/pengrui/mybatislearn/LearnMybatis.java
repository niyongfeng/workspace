package com.pengrui.mybatislearn;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pengrui.mybatis.projo.Project;
import com.pengrui.mybatis.projo.User;

public class LearnMybatis {

	public static void main(String[] args) {
		String resource = "mybatis_conf.xml";
		
		InputStream is = LearnMybatis.class.getClassLoader().getResourceAsStream(resource);
		
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = sessionFactory.openSession();
		
		//String statement = "com.pengrui.mybatis.mapping.userMapper.insertOne";
		//String statement = "com.pengrui.mybatis.mapping.userMapper.insertNoUserId2";
		//String statement = "com.pengrui.mybatis.mapping.userMapper.deleteOfId";
		//String statement = "com.pengrui.mybatis.mapping.userMapper.updateOfId";
		String statement = "com.pengrui.mybatis.mapping.userMapper.selectAll";
//		User u = new User();
	
//		u.setId(20);
//		u.setName("天才");
//		u.setGender("true");
//		u.setCompany("俊强");
//		u.setPhone("18100874037");
//		int count = session.insert(statement, u);
//		int count = session.delete(statement, u);
//		u.setId(1);
//		u.setName("kkkk");
//		u.setGender("false");
//		u.setCompany("lllll");
//		u.setPhone("110");
//		int count = session.update(statement, u);
//		Map<String,User> map = session.selectOne(statement,1);
//		for(String key : map.keySet()) {
//			System.out.println(key + ":" + map.get(key));
//		}
//		for(Map.Entry<String, User> entry : map.entrySet()) {
//			System.out.println(entry.toString());
//		}
		List<User> list = session.selectList(statement);
		for(User u : list) {
			System.out.println(u);
		}
		
		String str = "com.pengrui.mybatis.mapping.projectMapper.selectAll";
		List<Project> list1 = session.selectList(str);
		for(Project p : list1) {
			System.out.println(p);
		}
		
		session.commit();
//		System.out.println("insert count " + count + " as " + u);
		session.close();
	}
}

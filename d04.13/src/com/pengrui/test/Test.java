package com.pengrui.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pengrui.dao.ProjectDao;
import com.pengrui.dao.UserDao;
import com.pengrui.projo.Project;
import com.pengrui.projo.User;

public class Test {

	public static void main(String[] args) {
		String resource = "mybatis_conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		ProjectDao projectDao = session.getMapper(ProjectDao.class);
		Project project = new Project();
		User user = new User();
		UserDao userDao = session.getMapper(UserDao.class);
		//user.setId(1);
		List<User> list = userDao.select(user);
		for(User u : list) {
		System.out.println(u);
		}
//		project.setId(120);;
//		project.setName("倪永烽");
//		project.setDescription("开始打");
//		projectDao.insert(project);

		
//		List<Project> list = projectDao.select(project);
//		for(Project p : list) {
//			System.out.println(p);
//		}
//		project.setId(1);
//		project.setName("jiji");
//		project.setDescription("lpsds");
//		project.setUserId(2);
//		projectDao.update(project);
		session.commit();
		session.close();
	}

}

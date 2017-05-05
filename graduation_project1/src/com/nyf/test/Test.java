package com.nyf.test;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.QuestionDao;
import com.nyf.projo.Question;
import com.nyf.util.MybatisSessionFactory;

public class Test {

	public static void main(String[] args) {
		SqlSession session = MybatisSessionFactory.getSession();
//		ChairDao chairDao = session.getMapper(ChairDao.class);
//		List<Chair> list = chairDao.selectByString("三");
//		for(Chair c : list) {
//			System.out.println(c);
//		}
//		CompetitionDao cd = session.getMapper(CompetitionDao.class);
//		List<Competition> list = cd.selectAll();
//		System.out.println(list.size());
//		System.out.println("1");
//		for(Competition c : list) {
//			System.out.println(c);
//		}
//		LoginDao ld = session.getMapper(LoginDao.class);
//		List<Login> list = ld.selectAll();
//		List<Login> list1 = ld.selectByCode(1);
//		List<Login> list2 = ld.selectByName("zhangsan");
//		Login login = new Login();
//		login.setName("zhangsan");
//		login.setPwd("12345");
//		List<Login> list3 = ld.selectByLogin(login);
//		ChairDao cd = session.getMapper(ChairDao.class);
//		List<Chair> list1 = cd.selectByStringAndLoginId("1");
//		for(Chair c : list1) {
//			System.out.println(c);
//		}
		QuestionDao qd = session.getMapper(QuestionDao.class);
		Question q = new Question();
		q.setQuestion("11111");
		q.setLogin_id(5);
		System.out.println(q);
		System.out.println(qd.insert(q));
		session.commit();
		session.close();

	}

}

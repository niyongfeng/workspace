package com.application.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.domain.dao.ClazzDao;
import com.domain.pojo.Clazz;

public class TestMain {

	public static void main(String[] args) {
		String resouce = "mybatis_conf.xml";
		InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resouce);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = factory.openSession();
		ClazzDao clazzDao = ss.getMapper(ClazzDao.class);
		List<Clazz> clazzs = clazzDao.selectAll();
		for(Clazz cz : clazzs){
			System.out.println(cz);
		}
		ss.close();
	
	}

}

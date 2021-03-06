package com.qingke.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.qingke.dao.DictionaryDao;
import com.qingke.pojo.Dictionary;

public class DictionaryDaoTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession session;
	private static DictionaryDao dd;
	private static Dictionary d;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			dd = session.getMapper(DictionaryDao.class);
			d = new Dictionary();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsert() {
		d.setWord("gg");
		d.setDescription("结束");
		int i = dd.insert(d);
		System.out.println(i);
		session.commit();
	}

	@Test
	public void testSelectByWord() {
		List<Dictionary> list = new ArrayList<Dictionary>();
		list = dd.selectByWord("open");
		System.out.println(list);
	}

}

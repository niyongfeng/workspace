package com.qingke.service;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qingke.dao.DictionaryDao;
import com.qingke.pojo.Dictionary;

public class ReaderSqlService {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession session;
	private static DictionaryDao dd;
	private static Dictionary d;
	private static List<Dictionary> list;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			dd = session.getMapper(DictionaryDao.class);
			list = new ArrayList<Dictionary>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DictionaryDao getDictionaryDao() {
		return dd;
	}
	
	public static SqlSession getSession(){
		return session;
	}
	
	public static List<Dictionary> readerSql() {
		list = dd.select();
		return list;
	}
}

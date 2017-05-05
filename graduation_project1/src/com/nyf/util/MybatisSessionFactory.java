package com.nyf.util;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.nyf.projo.Login;
import com.nyf.test.Test;

public class MybatisSessionFactory {
	public static Login loginOk = new Login();

	public static SqlSession getSession() {
		String resource = "mybatis_conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		return session;
	}

	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}
}

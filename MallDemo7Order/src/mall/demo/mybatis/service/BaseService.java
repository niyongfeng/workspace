package mall.demo.mybatis.service;

import org.apache.ibatis.session.SqlSession;

public class BaseService {

	public BaseService() {
		// TODO Auto-generated constructor stub
	}
	
	public void closeSession(SqlSession session) {
		if(session != null) {
			session.close();
		}
	}

}

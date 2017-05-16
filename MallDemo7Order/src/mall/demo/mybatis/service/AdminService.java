package mall.demo.mybatis.service;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mall.demo.mybatis.pojo.Admin;
import mall.demo.mybatis.util.MybatisSessionUtil;
import mall.demo.util.SessionKeyEnum;

public class AdminService extends BaseService {
	private String mapper = "mall.demo.mybatis.mapper.AdminMapper.";
	private String queryByNamePassword = "getAdminByNamePassword";

	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin getByNamePassword(Admin admin) {
		SqlSession session = null;
		Admin retAdmin = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.mapper + this.queryByNamePassword;
			retAdmin = session.selectOne(st, admin);
			return retAdmin;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public boolean isAdminLogged(HttpSession session) {
		Object obj = session.getAttribute(SessionKeyEnum.isAdminIn.name());
		Object obj2 = session.getAttribute(SessionKeyEnum.adminObj.name());
		if(obj != null && obj2 != null) {
			return true;
		}
		return false;
	}

}

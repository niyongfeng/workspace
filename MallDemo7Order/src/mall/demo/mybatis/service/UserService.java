package mall.demo.mybatis.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mall.demo.mybatis.pojo.Notification;
import mall.demo.mybatis.pojo.User;
import mall.demo.mybatis.util.MybatisSessionUtil;
import mall.demo.util.NotificationTypeEnum;
import mall.demo.util.SessionKeyEnum;
import mall.demo.util.UserStatus;

public class UserService extends BaseService {
	private String userMapper = "mall.demo.mybatis.mapper.UserMapper.";
	private String addNewUser = "addNewUser";
	private String queryByLoginNamePassword = "queryByLoginNamePassword";
	private String selectAll = "selectAll";
	private String activeUserByName = "activeUserByName";
	private String updatePhotoById  = "updatePhotoById";
	
	private String notifyMapper = "mall.demo.mybatis.mapper.NotificationMapper.";
	private String addNewNotify = "addNewNotification";

	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addNewUser(User user) {
		SqlSession session = null;
		try {
			//add new user
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.userMapper + this.addNewUser;
			session.insert(st, user);
			//add new notification
			Notification notify = new Notification();
			notify.setnType(NotificationTypeEnum.registerNewUser.name());
			notify.setToken(UUID.randomUUID().toString());
			notify.setInfo(user.getLoginName());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 3);//三天过期，可以从配置文件或者其他设置
			notify.setExpireTime(cal.getTime());
			st = notifyMapper + addNewNotify;
			session.insert(st, notify);
			//send email
			//本该发送邮件的，不过实验了一下，发现大部分时候被打成垃圾邮件了。。。。
			//大家自行参考这个类去发邮件 mall.demo.util.EmailUtil
			//<contextRoot>/servlet/notify?token=xxxxxxxxx 可以用这个去激活
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public User getByLoginNamePassword(User user) {
		SqlSession session = null;
		User retUser = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.userMapper + this.queryByLoginNamePassword;
			retUser = session.selectOne(st, user);
			return retUser;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<User> getAllUsers() {
		SqlSession session = null;
		List<User> retUser = new ArrayList<User>();
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.userMapper + this.selectAll;
			retUser = session.selectList(st);
			return retUser;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public boolean isUserLogged(HttpSession session) {
		Object obj = session.getAttribute(SessionKeyEnum.isUserLoggedIn.name());
		Object obj2 = session.getAttribute(SessionKeyEnum.userObj.name());
		if(obj != null && obj2 != null) {
			return true;
		}
		return false;
	}
	
	public void activeUserByName(String loginName) {
		User user = new User();
		user.setLoginName(loginName);
		user.setStatus(UserStatus.ACTIVE);
		SqlSession session = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.userMapper + this.activeUserByName;
			session.update(st, user);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void updatePhoto(User user, String path) {
		user.setPhotoPath(path);
		SqlSession session = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String st = this.userMapper + this.updatePhotoById;
			session.update(st, user);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}

}

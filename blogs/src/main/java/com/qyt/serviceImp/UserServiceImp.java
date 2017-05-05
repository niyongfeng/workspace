package com.qyt.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qyt.dao.UserDao;
import com.qyt.pojo.User;
import com.qyt.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService{
	
	@Resource
	private UserDao us;
	public boolean insertUser(User user) {
		if(us.insert(user) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteUser(User user) {
		if(us.delete(user) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean updateUserName(User user) {
		if(us.updateName(user) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean updateUserPassword(User user) {
		if(us.updatePassword(user) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public List<User> selectByUserId(int id) {
		return us.selectById(id);
	}

	public List<User> selectByUserLoginName(User user) {
		
		return us.selectByLoginName(user);
	}
	public List<User> selectByUserName(User user) {
		return us.selectByName(user);
	}

	public List<User> selectIsLogin1(User user) {
		System.out.println("1111111111");
		List<User> l = us.selectIsLogin(user);
		System.out.println(l);
		return l;
	}
}

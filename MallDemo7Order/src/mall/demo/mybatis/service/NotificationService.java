package mall.demo.mybatis.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mall.demo.mybatis.pojo.Notification;
import mall.demo.mybatis.pojo.Product;
import mall.demo.mybatis.util.MybatisSessionUtil;

public class NotificationService extends BaseService {
	private String mapper = "mall.demo.mybatis.mapper.NotificationMapper.";
	private String selectByToken = "selectByToken";
	private String updateNotifyTime = "updateNotifyTime";

	public NotificationService() {
		// TODO Auto-generated constructor stub
	}
	
	public Notification getByToken(String token) {
		SqlSession session = null;
		Notification notify = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.mapper + this.selectByToken;
			notify = session.selectOne(statement, token);
			return notify;
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void updateNotifyTime(Notification notify) {
		SqlSession session = null;
		try {
			session = MybatisSessionUtil.getInstance().openSession();
			String statement = this.mapper + this.updateNotifyTime;
			session.update(statement, notify);
			session.commit();
			
		} catch (Exception e) {
			//很可能那里出错了，先简单一点直接作为运行时错误抛出去
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
	}
	
	public void expireNotification(Notification notify) {
		notify.setExpireTime(Calendar.getInstance().getTime());
		updateNotifyTime(notify);
	}

}

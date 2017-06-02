/**
 * 
 */
package com.xiaohoo.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaohoo.api.dao.ActivityInMapper;
import com.xiaohoo.api.dao.ActivityMapper;
import com.xiaohoo.api.dao.ActivityPaymentMapper;
import com.xiaohoo.api.dao.FavoritesMapper;
import com.xiaohoo.api.dao.UserMapper;
import com.xiaohoo.api.domain.Activity;
import com.xiaohoo.api.domain.ActivityIn;
import com.xiaohoo.api.domain.ActivityPayment;
import com.xiaohoo.api.domain.Favorites;
import com.xiaohoo.api.domain.User;
import com.xiaohoo.api.domain.enums.ActivityPaymentStatus;
import com.xiaohoo.api.domain.request.ActivitySearchRequest;
import com.xiaohoo.api.service.ActivityService;
import com.xiaohoo.api.service.ScheduledService;

/**
 * 活动
 * 
 * @author haojwang
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityMapper activityMapper;

	@Autowired
	ActivityPaymentMapper activityPaymentMapper;

	@Autowired
	ActivityInMapper activityInMapper;

	@Autowired
	ScheduledService schedule;

	@Autowired
	UserMapper userMapper;

	@Autowired
	FavoritesMapper favoritesMapper;

	private static Integer pageCount = 10;

	@Override
	@Transactional
	public boolean joinInActivity(Integer userId, Integer activityId) {
		// 参加人数是否达到上限,达到上限，返回false
		Activity activity = activityMapper.selectByPrimaryKey(activityId);
		if (activity.getMaxNumber() <= activity.getInNumber()) {
			// 活动人员已满
			return false;
		}
		// 加入，占一个人数
		activity.setInNumber(activity.getInNumber() + 1);
		activityMapper.updateByPrimaryKeySelective(activity);
		List<ActivityPayment> payments = activityPaymentMapper
				.getByActivityId(activityId);
		ActivityIn in = new ActivityIn();
		in.setActivityId(activityId);
		in.setUserId(userId);
		if (payments == null || payments.isEmpty()) {
			in.setStatus(ActivityPaymentStatus.Success.name());
			// 若活动免费，则报名成功
		} else {
			in.setStatus(ActivityPaymentStatus.UnPaid.name());
			// 若活动不免费,这状态为未支付，

			// 触发半小时定时任务，还未支付，则为过期(过期后，需要将报名人员-1)
			ActivityStatusChangeRunnable command = new ActivityStatusChangeRunnable(
					userId, activityId, ActivityPaymentStatus.Expired);
			// 支付成功后需要移除schedle Job
			schedule.addRunnable(userId, activityId, command);
		}
		activityInMapper.insertSelective(in);
		return true;
	}

	@Override
	@Transactional
	public void paidSuccess(Integer userId, Integer activityId) {
		// 移除schedule job
		schedule.removeRunnable(userId, activityId);
		// 更新支付状态
		activityInMapper.updateStatusByActivityId(
				ActivityPaymentStatus.Success.name(), userId, activityId);
	}

	@Override
	public List<Activity> getActivitiesBySearch(ActivitySearchRequest search) {

		Integer start = (search.getPage() - 1) * pageCount;
		search.setStart(start);
		search.setCount(pageCount);
		return activityMapper.searchActivities(search);
	}

	@Override
	public List<Activity> getActivitiesByType(User user, String type,
			Integer page) {
		Integer start = (page - 1) * pageCount;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("count", pageCount);
		map.put("page", page);
		map.put("school",
				user.getSchoolName() == null ? "" : user.getSchoolName());
		map.put("type", type);
		return activityMapper.getActivitiesByType(map);
	}

	@Override
	public Activity getActivityDetail(Integer activityId) {

		Activity activity = activityMapper.selectByPrimaryKey(activityId);
		if (activity != null) {
			// 获取支付详情
			List<ActivityPayment> payments = activityPaymentMapper
					.getByActivityId(activityId);

			activity.setPayments(payments);

			// 获取最近20人报名人员信息
			List<User> users = userMapper
					.getRecentInActivityUserByActivityId(activityId);
			activity.setUsers(users);
		}

		return activity;
	}

	@Override
	@Transactional
	public Integer addFavorite(Integer activityId, String activityName,
			User user) {
		Favorites f = new Favorites();
		f.setType("Activity");
		f.setTypeEntryId(activityId);
		f.setTypeEntryName(activityName);
		f.setUserId(user.getId());
		return favoritesMapper.insertSelective(f);
	}

	@Override
	public List<Activity> listFavorites(User user, Integer page) {
		Integer start = (page - 1) * pageCount;
		return activityMapper.getUserCollectActivites(user.getId(), start,
				pageCount);
	}

	@Override
	@Transactional
	public Integer deleteActivityInFavorites(Integer favoriteId) {
		return activityMapper.deleteByPrimaryKey(favoriteId);
	}

	@Override
	public List<Activity> getUserActivities(User user, Integer page) {
		Integer start = (page - 1) * pageCount;
		return activityMapper.getUserActivities(user.getId(), start, pageCount);
	}

	class ActivityStatusChangeRunnable implements Runnable {

		private Integer userId;
		private Integer activityId;
		private ActivityPaymentStatus toStatus;

		public ActivityStatusChangeRunnable(Integer userId, Integer activityId,
				ActivityPaymentStatus toStatus) {
			this.userId = userId;
			this.activityId = activityId;
			this.toStatus = toStatus;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		@Transactional
		public void run() {
			activityInMapper.updateStatusByActivityId(toStatus.name(), userId,
					activityId);
			// 活动参与人数-1
			activityMapper.updateInNumberMinusOne(activityId);
		}
	}

}

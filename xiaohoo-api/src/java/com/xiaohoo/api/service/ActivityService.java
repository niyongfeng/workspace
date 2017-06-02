/**
 * 
 */
package com.xiaohoo.api.service;

import java.util.List;

import com.xiaohoo.api.domain.Activity;
import com.xiaohoo.api.domain.User;
import com.xiaohoo.api.domain.request.ActivitySearchRequest;

/**
 * @author haojwang
 *
 */
public interface ActivityService {

	/**
	 * 加入活动
	 * 
	 * @param userId
	 * @param activityId
	 * @return
	 */
	public boolean joinInActivity(Integer userId, Integer activityId);

	/**
	 * 用户支付活动费用成功调用
	 * 
	 * @param userId
	 * @param activityId
	 */
	public void paidSuccess(Integer userId, Integer activityId);

	/**
	 * 获取活动详情
	 * 
	 * @param activityId
	 * @return
	 */
	public Activity getActivityDetail(Integer activityId);

	/**
	 * 根据搜索信息，获取活动列表
	 * 
	 * @param search
	 * @return
	 */
	public List<Activity> getActivitiesBySearch(ActivitySearchRequest search);

	/**
	 * 根据活动类型，获取活动列表
	 * 
	 * @param user
	 * @param type
	 * @return
	 */
	public List<Activity> getActivitiesByType(User user, String type,
			Integer page);

	/**
	 * 收藏活动
	 * 
	 * @param activityId
	 * @param activityName
	 * @param user
	 * @return
	 */
	public Integer addFavorite(Integer activityId, String activityName,
			User user);

	/**
	 * 显示收藏活动列表
	 * 
	 * @param user
	 * @param page
	 * @return
	 */
	public List<Activity> listFavorites(User user, Integer page);

	/**
	 * 删除收藏中的活动
	 * 
	 * @param favoriteId
	 * @return
	 */
	public Integer deleteActivityInFavorites(Integer favoriteId);

	/**
	 * 显示用户已参加活动列表
	 * @param user
	 * @param page
	 * @return
	 */
	public List<Activity> getUserActivities(User user, Integer page);
}

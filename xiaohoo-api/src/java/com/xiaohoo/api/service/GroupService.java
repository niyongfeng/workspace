/**
 * 
 */
package com.xiaohoo.api.service;

import com.xiaohoo.api.domain.Group;
import com.xiaohoo.api.domain.GroupMomentResponse;
import com.xiaohoo.api.domain.GroupMoments;
import com.xiaohoo.api.domain.User;

/**
 * 社群
 * 
 * @author haojwang
 *
 */
public interface GroupService {

	/**
	 * 加入社群,若社群已满，则返回失败
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public boolean joinInGroup(Integer userId, Integer groupId);

	/**
	 * 用户上传学生证，学生会证明照片，开通权限
	 * 
	 * @param user
	 * @param studentCard
	 * @param studentUnionCard
	 * @return
	 */
	public Integer userApplyRole(User user, String studentCard,
			String studentUnionCard);

	/**
	 * 审批用户权限，通过/拒绝
	 * 
	 * @param userId
	 * @param status
	 * @param comments
	 * @return
	 */
	public boolean approvalUserApplication(Integer userId, String status,
			String comments);

	/**
	 * 用户开通新社群
	 * 
	 * @param user
	 * @param group
	 * @return
	 */
	public boolean newGroup(User user, Group group);

	/**
	 * 用户发布新状态
	 * 
	 * @param user
	 * @param moments
	 * @return
	 */
	public boolean newMoments(User user, GroupMoments moments);

	/**
	 * 回复社群状态
	 * 
	 * @param user
	 * @param moments
	 * @return
	 */
	public boolean newMomentsResponse(User user, GroupMomentResponse mResponse);
}

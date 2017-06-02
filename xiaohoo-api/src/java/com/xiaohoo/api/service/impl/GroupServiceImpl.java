/**
 * 
 */
package com.xiaohoo.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaohoo.api.dao.GroupMapper;
import com.xiaohoo.api.dao.GroupMembersMapper;
import com.xiaohoo.api.dao.GroupMomentResponseMapper;
import com.xiaohoo.api.dao.GroupMomentsMapper;
import com.xiaohoo.api.dao.UserApplicationMapper;
import com.xiaohoo.api.dao.UserMapper;
import com.xiaohoo.api.domain.Group;
import com.xiaohoo.api.domain.GroupMembers;
import com.xiaohoo.api.domain.GroupMomentResponse;
import com.xiaohoo.api.domain.GroupMoments;
import com.xiaohoo.api.domain.User;
import com.xiaohoo.api.domain.UserApplication;
import com.xiaohoo.api.domain.enums.GroupMemberType;
import com.xiaohoo.api.domain.enums.UserApplyRoleStatus;
import com.xiaohoo.api.service.GroupService;

/**
 * @author haojwang
 *
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupMapper groupMapper;

	@Autowired
	GroupMembersMapper groupMembersMapper;

	@Autowired
	UserApplicationMapper userApplicationMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	GroupMomentsMapper groupMomentsMapper;

	@Autowired
	GroupMomentResponseMapper groupMomentResponseMapper;

	@Override
	@Transactional
	public boolean joinInGroup(Integer userId, Integer groupId) {
		// 检查社群人数
		Group group = groupMapper.selectByPrimaryKey(groupId);
		if (group.getInNumber() >= group.getMaxIn()) {
			// 社群人数已满
			return false;
		}
		// 未看到审批功能，直接加入社群
		// 社群参加人数+1
		group.setInNumber(group.getInNumber() + 1);
		groupMapper.updateByPrimaryKeySelective(group);
		// 社群匹配关系
		GroupMembers member = new GroupMembers();
		member.setUserId(userId);
		member.setGroupId(groupId);
		member.setType(GroupMemberType.Member.name());
		groupMembersMapper.insertSelective(member);

		return true;
	}

	@Override
	@Transactional
	public Integer userApplyRole(User user, String studentCard,
			String studentUnionCard) {
		UserApplication application = new UserApplication();
		application.setUserId(user.getId());
		application.setStudentCard(studentCard);
		application.setStudentUnionCard(studentUnionCard);
		application.setStatus(UserApplyRoleStatus.Apply.name());
		return userApplicationMapper.insertSelective(application);
	}

	@Override
	@Transactional
	public boolean approvalUserApplication(Integer userId, String status,
			String comments) {

		userApplicationMapper.updateStatusByUserId(userId, status, comments);
		if (status.equals(UserApplyRoleStatus.Success.name())) {
			// 审批成功，修改用户role
			userMapper.updateLevelByUserId(userId, 1);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean newGroup(User user, Group group) {
		// 社群最大默认容量500人
		if (group.getMaxIn() == null) {
			group.setMaxIn(500);
		}
		// 默认群主在社群中
		group.setInNumber(1);
		// 社群归属学校为群主所在学校
		group.setSchoolId(user.getSchoolId());
		group.setSchoolName(user.getSchoolName());
		group.setCity(user.getCity());
		int gid = groupMapper.insertSelective(group);
		GroupMembers member = new GroupMembers();
		member.setGroupId(gid);
		member.setUserId(user.getId());
		member.setType(GroupMemberType.Host.name());
		groupMembersMapper.insertSelective(member);
		return true;
	}

	@Override
	@Transactional
	public boolean newMoments(User user, GroupMoments moments) {
		moments.setUserId(user.getId());
		groupMomentsMapper.insertSelective(moments);
		return true;
	}

	@Override
	@Transactional
	public boolean newMomentsResponse(User user, GroupMomentResponse mResponse) {

		mResponse.setRead(false);
		mResponse.setResponseBy(user.getId());
		groupMomentResponseMapper.insertSelective(mResponse);
		return true;
	}
}

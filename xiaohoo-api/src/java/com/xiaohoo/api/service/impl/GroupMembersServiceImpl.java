package com.xiaohoo.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaohoo.api.dao.GroupMembersMapper;
import com.xiaohoo.api.dao.GroupMomentResponseMapper;
import com.xiaohoo.api.dao.GroupMomentScroeMapper;
import com.xiaohoo.api.dao.TipOffMapper;
import com.xiaohoo.api.domain.GroupMomentResponse;
import com.xiaohoo.api.domain.GroupMomentScroe;
import com.xiaohoo.api.domain.NewGroupMembers;
import com.xiaohoo.api.domain.TipOff;
import com.xiaohoo.api.service.GroupMembersService;

//显示群内成员的功能实现类
//@Service
@Component
public class GroupMembersServiceImpl implements GroupMembersService{
	
	@Resource
	GroupMembersMapper groupMembersMapper;
	
	@Override
	public List<NewGroupMembers> getGroupMembers(Integer groupId, Integer userId) {
		//System.out.println("groupMembersMapper:" + groupMembersMapper);
		List<NewGroupMembers> groupMembers = groupMembersMapper.selectByGroupId(userId,groupId);
		//JSONArray json = JSONArray.fromObject(groupMembers); 
		//return json;
		return groupMembers;
	}

	@Autowired
	GroupMomentResponseMapper groupMomentResponseMapper;
	
	@Override
	public List<GroupMomentResponse> getGroupMomentResponse(Integer groupMomentsId) {
		List<GroupMomentResponse> getGroupMomentResponses = groupMomentResponseMapper.selectByGroupMomentsId(groupMomentsId);
		return getGroupMomentResponses;
	}

	@Autowired
	TipOffMapper tipOffMapper;

	@Override
	@Transactional
	public boolean tipOff(TipOff tipOff) {
		int b = tipOffMapper.insertSelective(tipOff);
		return (b != 0);
	}
	
	@Resource
	GroupMomentScroeMapper groupMomentScroeMapper;
	
	@Override
	public boolean statusMark(GroupMomentScroe groupMomentScroe) {
		//System.out.println("groupMomentScroeMapper:" + groupMomentScroeMapper);
		int b = groupMomentScroeMapper.insertSelective(groupMomentScroe);
		return (b != 0);
	}

	@Override
	public boolean responseTo(GroupMomentResponse groupMomentResponse) {
		int b = groupMomentResponseMapper.insertSelective(groupMomentResponse);
		return (b != 0);
	}

}

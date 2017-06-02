package com.xiaohoo.api.service;


import java.util.List;

import com.xiaohoo.api.domain.GroupMomentResponse;
import com.xiaohoo.api.domain.GroupMomentScroe;
import com.xiaohoo.api.domain.NewGroupMembers;
import com.xiaohoo.api.domain.TipOff;


public interface GroupMembersService {
	/**
	 * 显示群内成员列表
	 * @param groupId
	 * @param userId
	 * @return
	 */
	public List<NewGroupMembers> getGroupMembers(Integer groupId, Integer userId);
	
	/**
	 * 查看该条状态的所有回复信息
	 * @param groupMomentsId
	 * @return
	 */
	public List<GroupMomentResponse> getGroupMomentResponse(Integer groupMomentsId);
	
	/**
     * 新增举报数据
     * @param tipOff
     * @return int
     */
	public boolean tipOff(TipOff tipOff);
	
	/**
     * 新增状态分数
     * @param groupMomentScroe
     * @return int
     */
	
	public boolean statusMark(GroupMomentScroe groupMomentScroe);
	
	/**
	 * 社团状态回复
	 * @param groupMomentResponse
	 * @return
	 */
	public boolean responseTo(GroupMomentResponse groupMomentResponse);
}

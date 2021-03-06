package com.nyf.api.test;

import java.util.List;

import com.xiaohoo.api.domain.Notice;

public interface NoticeService {
	
	/**
     * 显示通知类型，用户消息，标记未读消息数量
     * @param UserID
     * @return List<Notice>
     */
	
	public List<Notice> notice(Integer noticeTo);
}

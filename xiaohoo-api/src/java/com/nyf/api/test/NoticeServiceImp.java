package com.nyf.api.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaohoo.api.dao.NoticeMapper;
import com.xiaohoo.api.domain.Notice;

//通知功能实现类
public class NoticeServiceImp implements NoticeService{

	@Autowired
	NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> notice(Integer noticeTo) {
		
		return null;
	}
	
}

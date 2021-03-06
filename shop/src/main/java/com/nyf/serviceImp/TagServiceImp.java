package com.nyf.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nyf.dao.TagDao;
import com.nyf.pojo.Tag;
import com.nyf.service.TagService;
@Service("tagService")
public class TagServiceImp implements TagService {

	@Resource
	private TagDao tagDao;
	@Override
	public List<Tag> selectTagServiceById(int id) {
		return tagDao.selectTagById(id);
	}

	@Override
	public List<Tag> selectTagServiceAll() {
		// TODO Auto-generated method stub
		return tagDao.selectTagAll();
	}

}

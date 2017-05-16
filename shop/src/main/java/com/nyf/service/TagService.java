package com.nyf.service;

import java.util.List;

import com.nyf.pojo.Tag;

public interface TagService {
	List<Tag> selectTagServiceById(int id);
	List<Tag> selectTagServiceAll();
}

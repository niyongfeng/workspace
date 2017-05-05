package com.pengrui.dao;

import java.util.List;

public interface ProjectDao extends BaseDao{
	List selectByUserId(int id);
}
